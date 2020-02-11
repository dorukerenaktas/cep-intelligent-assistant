package com.ia.gpj.processor;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.util.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FlinkProcessor implements Processor {

    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private StreamExecutionEnvironment environment;

    public FlinkProcessor(SourceFunction<ObjectNode> source) {
        // TODO: Convert keys to argument
        String[] keys = {"session_id", "user_id"};

        this.environment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<ObjectNode> inputStream = this.environment.addSource(source);
        DataStream<KVTuple> parsedStream = inputStream.flatMap(new FlatMapFunction<ObjectNode, KVTuple>() {
            @Override
            public void flatMap(ObjectNode value, Collector<KVTuple> out) throws Exception {
                out.collect(KVTuple.fromJson(keys, value));
            }
        });
    }

    @Override
    public void start() throws Exception {
        this.environment.execute();
    }
}
