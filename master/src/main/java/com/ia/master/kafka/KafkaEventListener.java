package com.ia.master.kafka;

public interface KafkaEventListener {
    void OnEvent(String message);
}
