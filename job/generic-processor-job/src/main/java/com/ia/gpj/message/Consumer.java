package com.ia.gpj.message;

import org.apache.flink.formats.json.JsonNodeDeserializationSchema;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.json.simple.JSONObject;

import java.util.Properties;

public class Consumer {

    public static SourceFunction<ObjectNode> instance(String broker, String topic) {
        Properties consumerProps = new Properties();
        consumerProps.setProperty("bootstrap.servers", broker);
        return new FlinkKafkaConsumer<>(topic, new JsonNodeDeserializationSchema(), consumerProps);
    }
}
