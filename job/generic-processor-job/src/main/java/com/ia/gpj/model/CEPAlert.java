package com.ia.gpj.model;

import com.ia.gpj.rule.Rule;
import com.ia.pdl.model.Event;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CEPAlert {

    public static String fromPattern(Rule rule, Map<String, List<Event>> pattern) {
        JSONObject json = new JSONObject();

        json.put("rule", rule.toJson());

        JSONObject matchJson = new JSONObject();
        for(Map.Entry<String, List<Event>> entry : pattern.entrySet()) {
            String key = entry.getKey();
            List<Event> value = entry.getValue();

            JSONArray events = new JSONArray();
            for (Event event: value) {
                CEPEvent cepEvent = (CEPEvent) event;
                JSONObject eventJson = new JSONObject();
                for (Map.Entry<String, Object> attribute: cepEvent.getAttributes().entrySet()) {
                    eventJson.put(attribute.getKey(), attribute.getValue());
                }
                events.add(eventJson);
            }
            matchJson.put(key, events);
        }

        json.put("match", matchJson);

        json.put("date", new Date().getTime());

        return json.toString();
    }
}
