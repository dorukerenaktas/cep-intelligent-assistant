package com.ia.gpj.model;

import com.ia.pdl.model.Event;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

public class CEPEvent implements Event {

    private static final long serialVersionUID = 3601558599393520229L;
    private Map<String, Object> attributes = new HashMap<>();
    private String eventType;

    public CEPEvent(ObjectNode json) {
        Iterator<String> jsonKeys = json.fieldNames();
        while (jsonKeys.hasNext()) {
            String key = jsonKeys.next();
            attributes.put(key, json.get(key).asText());
        }
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    void setAttribute(String attribute, Object value) {
        this.attributes.put(attribute, value);
    }

    @Override
    public Optional<Object> getAttribute(String attribute) {
        if (attribute.contains(attribute)) {
            return Optional.of(attributes.get(attribute));
        }
        return Optional.empty();
    }

    @Override
    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
