package com.ia.gpj;

import com.ia.gpj.message.Consumer;
import com.ia.gpj.message.Producer;
import com.ia.gpj.processor.FlinkProcessor;
import com.ia.gpj.rule.Rule;

public class Main {
    public static void main(String[] args) throws Exception {
        String sourceBroker = "kafka:9093",
                sourceTopic = "Events",
                sinkBroker = "kafka:9093",
                sinkTopic = "Actions",
                ruleName = "Test rule",
                rulePattern = "A(user_id='102111')",
                ruleAction = "ALERT";
        if (args.length == 7) {
            sourceBroker = args[0];
            sourceTopic = args[1];
            sinkBroker = args[2];
            sinkTopic = args[3];
            ruleName = args[4];
            rulePattern = args[5];
            ruleAction = args[6];
        }

        FlinkProcessor processor = new FlinkProcessor(
                new Rule(ruleName, rulePattern, ruleAction),
                Consumer.instance(sourceBroker, sourceTopic),
                Producer.instance(sinkBroker, sinkTopic));

        processor.start();
    }
}
