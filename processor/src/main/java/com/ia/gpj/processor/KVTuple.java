package com.ia.gpj.processor;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Key value tuple. Stores dictionary data in tuple format. Identifiers can be used to differentiate data.
 */
public class KVTuple extends Tuple2<String, Hashtable<String, String>> {

    public KVTuple(String identifier, Hashtable<String, String> data) {
        super(identifier, data);
    }

    public static KVTuple fromJson(String[] keys, ObjectNode json) {
        StringBuilder identifier = new StringBuilder();

        for (String key : keys) {
            identifier.append(json.get(key).asText());
            identifier.append("-");
        }

        Hashtable<String, String> data = new Hashtable<>();
        Iterator<String> jsonKeys = json.fieldNames();
        while (jsonKeys.hasNext()) {
            String key = jsonKeys.next();
            data.put(key, json.get(key).asText());
        }

        return new KVTuple(identifier.toString(), data);
    }
}
