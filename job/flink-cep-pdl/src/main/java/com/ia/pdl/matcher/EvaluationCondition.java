package com.ia.pdl.matcher;

import com.ia.pdl.model.Event;
import org.apache.flink.cep.pattern.conditions.IterativeCondition;

/**
 * Condition for Flink CEP which evaluates a list of expressions
 */
public class EvaluationCondition extends IterativeCondition<Event> {

    private static final long serialVersionUID = 9104383745848011462L;
    private AggregatingContextMatcher contextMatchers;

    public EvaluationCondition(AggregatingContextMatcher contextMatchers) {
        this.contextMatchers = contextMatchers;
    }

    @Override
    public boolean filter(Event event, Context<Event> context) {
        return contextMatchers.matches(event, context);
    }
}
