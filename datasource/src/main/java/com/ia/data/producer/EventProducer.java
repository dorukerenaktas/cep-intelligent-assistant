package com.ia.data.producer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Properties;

public class EventProducer {
    private String topic;
    private Producer<String, JsonNode> producer;

    public EventProducer(String broker, String topic) throws Exception {
        this.topic = topic;
        Properties props = new Properties();
        props.put("bootstrap.servers", broker);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.connect.json.JsonSerializer");
        this.producer = new KafkaProducer<>(props);
    }

    public void send(JSONObject json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode objNode = objectMapper.readTree(json.toString());

        ProducerRecord<String, JsonNode> record = new ProducerRecord<String, JsonNode>(
                this.topic, "event", objNode);
        this.producer.send(record);
    }
}
