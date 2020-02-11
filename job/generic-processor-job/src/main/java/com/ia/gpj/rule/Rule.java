package com.ia.gpj.rule;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class Rule implements Serializable {

    private String name;

    private String pattern;

    private String action;

    public Rule(String name, String pattern, String action) {
        this.name = name;
        this.pattern = pattern;
        this.action = action;
    }

    public String getPattern() {
        return pattern;
    }

    public JSONObject toJson() {
        JSONObject rule = new JSONObject();
        rule.put("name", this.name);
        rule.put("pattern", this.pattern);
        rule.put("action", this.action);
        return rule;
    }
}
