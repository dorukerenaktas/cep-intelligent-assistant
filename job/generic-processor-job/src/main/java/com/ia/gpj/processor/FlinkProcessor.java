package com.ia.gpj.processor;

import com.ia.gpj.model.CEPAlert;
import com.ia.gpj.model.CEPEvent;
import com.ia.gpj.rule.Rule;
import com.ia.pdl.Pdl;
import com.ia.pdl.model.Event;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;

public class FlinkProcessor implements Processor {

    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private StreamExecutionEnvironment environment;

    public FlinkProcessor(Rule rule, SourceFunction<ObjectNode> source, SinkFunction<String> sink) {

        this.environment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<ObjectNode> inputStream = this.environment.addSource(source);
        DataStream<Event> parsedStream = inputStream.flatMap(new FlatMapFunction<ObjectNode, Event>() {
            @Override
            public void flatMap(ObjectNode value, Collector<Event> out) throws Exception {
                out.collect(new CEPEvent(value));
            }
        });

        PatternStream<Event> patternStream = Pdl.compile(rule.getPattern(), parsedStream);
        DataStream<String> alertStream = patternStream.select(new PatternSelectFunction<Event, String>() {
            @Override
            public String select(Map<String, List<Event>> pattern) throws Exception {
                return CEPAlert.fromPattern(rule, pattern);
            }
        });

        alertStream.addSink(sink);
    }

    @Override
    public void start() throws Exception {
        this.environment.execute();
    }
}
