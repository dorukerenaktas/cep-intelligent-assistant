package com.ia.gpj;

import com.ia.gpj.processor.FlinkProcessor;
import org.apache.flink.formats.json.JsonNodeDeserializationSchema;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.log4j.BasicConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("sample-rules.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject employeeList = (JSONObject) obj;
            System.out.println(employeeList);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");

        FlinkKafkaConsumer<ObjectNode> consumer = new FlinkKafkaConsumer<>("Events", new JsonNodeDeserializationSchema(), properties);

        FlinkProcessor processor = new FlinkProcessor(consumer);
        processor.start();
    }
}
