package com.ia.gpj.rule.condition;

import com.ia.gpj.processor.KVTuple;

import org.apache.flink.cep.pattern.Pattern;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public interface Condition extends Serializable {
    Pattern<KVTuple, ?> toPattern(ArrayList<Hashtable<String, String>> data);
}
