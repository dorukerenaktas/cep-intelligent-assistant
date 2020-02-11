package com.ia.master;

import com.google.gson.*;
import com.ia.master.controller.StandardResponse;
import com.ia.master.controller.StatusResponse;
import com.ia.master.flink.FlinkAPI;
import com.ia.master.kafka.KafkaConsumerImp;
import org.apache.log4j.BasicConfigurator;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.util.ArrayList;
import java.util.Hashtable;

import static spark.Spark.*;

public class Main {

    static ArrayList<Session> socketConnections = new ArrayList<>();
    static Hashtable<String, JsonObject> submittedJobs = new Hashtable<>();

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();

        String broker = "localhost:9092";
        if (args.length > 0) {
            broker = args[0];
        } else if (System.getenv("KAFKA_BROKER") != null) {
            broker = System.getenv("KAFKA_BROKER");
        }

        String eventTopic = "Events";
        if (args.length > 1) {
            eventTopic = args[1];
        } else if (System.getenv("KAFKA_EVENTS_TOPIC") != null) {
            eventTopic = System.getenv("KAFKA_EVENTS_TOPIC");
        }

        String actionTopic = "Actions";
        if (args.length > 2) {
            actionTopic = args[2];
        } else if (System.getenv("KAFKA_ACTIONS_TOPIC") != null) {
            actionTopic = System.getenv("KAFKA_ACTIONS_TOPIC");
        }

        String flinkBaseApi = "http://localhost:8081";
        if (args.length > 3) {
            flinkBaseApi = args[3];
        } else if (System.getenv("FLINK_BASE_API") != null) {
            flinkBaseApi = System.getenv("FLINK_BASE_API");
        }

        String finalEventTopic = eventTopic;
        String finalActionTopic = actionTopic;

        KafkaConsumerImp eventConsumer = new KafkaConsumerImp(broker, eventTopic);
        eventConsumer.addListener(message -> broadcastMessage(finalEventTopic, message));
        eventConsumer.start();

        KafkaConsumerImp actionConsumer = new KafkaConsumerImp(broker, actionTopic);
        actionConsumer.addListener(message -> broadcastMessage(finalActionTopic, message));
        actionConsumer.start();

        FlinkAPI api = new FlinkAPI(flinkBaseApi);

        boolean uploaded = false;
        int tryCount = 0;
        while (!uploaded && tryCount < 10) {
            tryCount++;

            try {
                uploaded = true;
                api.uploadJar("/generic-processor-job-1.0.jar");
            } catch (Exception e) {
                e.printStackTrace();
                uploaded = false;
            }
        }

        webSocket("/socket", WebSocketHandler.class);
        port(4568);
        init();

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

        get("/rules", (req, res) -> {
            res.type("application/json");

            JsonObject jsonObject = api.getJobs().getAsJsonObject();
            JsonArray jobsArray = jsonObject.getAsJsonArray("jobs");

            JsonArray result = new JsonArray();
            for (JsonElement jsonElement: jobsArray) {
                JsonObject job = new JsonObject();
                String jobId = jsonElement.getAsJsonObject().get("id").getAsString();
                String jobStatus = jsonElement.getAsJsonObject().get("status").getAsString();

                job.addProperty("id", jobId);
                job.addProperty("status", jobStatus);
                if (submittedJobs.containsKey(jobId)) {
                    JsonObject submittedJob = submittedJobs.get(jobId);
                    job.addProperty("name", submittedJob.get("name").getAsString());
                    job.addProperty("pattern", submittedJob.get("pattern").getAsString());
                    job.addProperty("action", submittedJob.get("action").getAsString());
                } else {
                    job.addProperty("name", "-");
                    job.addProperty("pattern", "-");
                    job.addProperty("action", "-");
                }

                result.add(job);
            }

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, result));
        });

        post("/jobs", (req, res) -> {
            res.type("application/json");
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(req.body()).getAsJsonObject();
            JsonArray argsJson = json.get("args").getAsJsonArray();

            JsonObject result = api.submitJob(argsJson).getAsJsonObject();
            String jobId = result.get("jobid").getAsString();
            JsonObject jobJson = new JsonObject();
            jobJson.addProperty("id", jobId);
            jobJson.addProperty("name", argsJson.get(4).getAsString());
            jobJson.addProperty("pattern", argsJson.get(5).getAsString());
            jobJson.addProperty("action", argsJson.get(6).getAsString());

            submittedJobs.put(jobId, jobJson);

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, result));
        });
    }

    public static void broadcastMessage(String topic, String message) {
        socketConnections.stream().filter(Session::isOpen).forEach(session -> {
            try {
                JsonObject json = new JsonObject();
                json.addProperty("topic", topic);
                json.addProperty("message", message);
                session.getRemote().sendString(String.valueOf(json));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @WebSocket
    public static class WebSocketHandler {

        @OnWebSocketConnect
        public void onConnect(Session user) throws Exception {
            socketConnections.add(user);
        }

        @OnWebSocketClose
        public void onClose(Session user, int statusCode, String reason) {
            socketConnections.remove(user);
        }
    }
}
