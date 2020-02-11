package com.ia.gpj.rule.condition;

import com.ia.gpj.processor.KVTuple;
import org.apache.flink.cep.pattern.Pattern;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Logical conditions are used for providing aggregation ability to conditions using boolean logic operators.
 */
public class LogicalCondition implements Condition {

    public enum LogicalOperatorType {
        AND, OR
    }

    private LogicalOperatorType operator;

    private ArrayList<Condition> conditions;

    public LogicalCondition(LogicalOperatorType operator, ArrayList<Condition> conditions) {
        this.operator = operator;
        this.conditions = conditions;
    }

    @Override
    public Pattern<KVTuple, ?> toPattern(ArrayList<Hashtable<String, String>> data) {
        Iterator<Condition> iterator = this.conditions.iterator();
        Pattern<KVTuple, ?> pattern;
        if (iterator.hasNext()) {
            pattern = Pattern.begin(iterator.next().toPattern(data));
            switch (this.operator) {
                case AND:
                    while (iterator.hasNext()) {
                        pattern = pattern.next(
                                Pattern.begin(iterator.next().toPattern(data))
                        );
                    }
                    break;
                case OR:
                    while (iterator.hasNext()) {

                    }
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return null;
    }
}
