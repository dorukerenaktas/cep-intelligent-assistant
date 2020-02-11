package com.ia.gpj.message;

import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.Properties;

public class Producer {

    public static SinkFunction<String> instance(String broker, String topic) {
        Properties producerProps = new Properties();
        producerProps.put("bootstrap.servers", broker);
        return new FlinkKafkaProducer<>(topic, new ProducerStringSerializationSchema(topic), producerProps, FlinkKafkaProducer.Semantic.NONE);
    }
}

