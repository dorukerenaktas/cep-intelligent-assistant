package com.ia.pdl;

import com.ia.pdl.model.Event;
import com.ia.pdl.language.PDLLexer;
import com.ia.pdl.language.PDLParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.streaming.api.datastream.DataStream;

public class Pdl {

    /**
     * Enable strict event type matching. The class identifier in the expression must
     * match the event type. HostActive(hostname='abc') only matches when there is an
     * an event which has the event type 'HostActive'.
     */
    public static DslBuilder withStrictEventTypeMatching() {
        return new DslBuilder(true);
    }

    public static class DslBuilder {
        private boolean strictEventTypeMatching;

        DslBuilder(boolean strictEventTypeMatching) {
            this.strictEventTypeMatching = strictEventTypeMatching;
        }

        public PatternStream<Event> compile(String expression, DataStream<Event> dataStream) {
            return Pdl.compile(expression, dataStream, strictEventTypeMatching);
        }
    }

    /**
     * Returns a pattern stream based on a data stream and a pattern to search for
     * @param expression The expression representing the pattern which should be evaluated, refer to the projects documentation on syntax and features
     * @param dataStream The data stream which should be evaluated
     * @return The pattern stream providing the found patterns
     */
    public static PatternStream<Event> compile(String expression, DataStream<Event> dataStream) {
        return Pdl.compile(expression, dataStream, false);
    }

    private static PatternStream<Event> compile(String expression, DataStream<Event> dataStream, boolean strictEventTypeMatching) {
        CaseInsensitiveInputStream inputStream = new CaseInsensitiveInputStream(expression);
        PDLLexer lexer = new PDLLexer(inputStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PDLParser parser = new PDLParser(tokens);
        ParseTree parseTree = parser.patternSequence();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        PdlListener listener = new PdlListener(strictEventTypeMatching);
        parseTreeWalker.walk(listener, parseTree);

        return CEP.pattern(dataStream, listener.getPattern());
    }
}
