package com.ia.data;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ia.data.controller.StandardResponse;
import com.ia.data.controller.StatusResponse;
import com.ia.data.producer.EventProducer;
import com.ia.data.reader.LineReaderManager;
import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();

        String broker = "localhost:9092";
        if (args.length > 0) {
            broker = args[0];
        } else if (System.getenv("KAFKA_BROKER") != null) {
            broker = System.getenv("KAFKA_BROKER");
        }

        String topic = "Events";
        if (args.length > 1) {
            topic = args[1];
        } else if (System.getenv("KAFKA_TOPIC") != null) {
            topic = System.getenv("KAFKA_TOPIC");
        }

        EventProducer producer = new EventProducer(broker, topic);
        LineReaderManager manager = new LineReaderManager(producer);

        options("/*",
                (request, response) -> {
                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }
                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/state", (req, res) -> {
            res.type("application/json");

            JsonObject data = new JsonObject();
            data.addProperty("running", manager.getState());

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, data));
        });

        post("/start", (req, res) -> {
            res.type("application/json");

            JsonParser parser = new JsonParser();
            JsonElement jsonTree = parser.parse(req.body());
            if (jsonTree.isJsonObject()) {
                JsonObject jsonObject = jsonTree.getAsJsonObject();
                manager.start(jsonObject.getAsJsonPrimitive("frequency").getAsInt());

                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
            } else {
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR));
            }
        });

        post("/pause", (req, res) -> {
            res.type("application/json");
            manager.pause();
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        post("/stop", (req, res) -> {
            res.type("application/json");
            manager.stop();
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
    }
}
