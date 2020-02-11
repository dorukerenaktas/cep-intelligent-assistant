package com.ia.executor.kafka;

public interface KafkaEventListener {
    void OnEvent(String message);
}
