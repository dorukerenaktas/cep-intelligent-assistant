package com.ia.master.kafka;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.connect.json.JsonDeserializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerImp extends Thread {

    private Consumer<String, JsonNode> consumer;
    private ArrayList<KafkaEventListener> listeners = new ArrayList<>();

    public KafkaConsumerImp(String broker, String topic) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, broker);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumerGroup1");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        this.consumer = new KafkaConsumer<>(props);
        this.consumer.subscribe(Collections.singletonList(topic));
    }

    public void run(){
        try {
            while (true) {
                ConsumerRecords<String, JsonNode> consumerRecords = consumer.poll(100);
                if (consumerRecords.count() != 0) {
                    for (ConsumerRecord<String, JsonNode> record:consumerRecords) {
                        for (KafkaEventListener listener : this.listeners) {
                            listener.OnEvent(record.value().toString());
                        }
                    }

                    // commits the offset of record to broker.
                    consumer.commitAsync();
                }
                sleep(100);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addListener(KafkaEventListener listener) {
        this.listeners.add(listener);
    }
}
