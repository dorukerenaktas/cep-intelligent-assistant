package com.ia.pdl;

import com.ia.pdl.model.Event;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DslTests {

    @Test
    public void shouldEvaluateNextPattern() throws Exception {

        DataStream<Event> dataStream = null;
        PatternStream<Event> patternStream = Pdl.compile("A(attribute >< 'testabc') -- B(attribute=30)", dataStream);

    }

}
