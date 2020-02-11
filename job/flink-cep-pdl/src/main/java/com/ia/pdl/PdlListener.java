package com.ia.pdl;

import com.ia.pdl.model.Event;
import com.ia.pdl.language.PDLBaseListener;
import com.ia.pdl.language.PDLParser;
import com.ia.pdl.matcher.AggregatingContextMatcher;
import com.ia.pdl.matcher.ContextMatcher;
import com.ia.pdl.matcher.EvaluationCondition;
import com.ia.pdl.matcher.EventTypeContextMatcher;
import org.apache.flink.cep.nfa.aftermatch.AfterMatchSkipStrategy;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.streaming.api.windowing.time.Time;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class PdlListener extends PDLBaseListener {
    private Pattern<Event, Event> pattern;
    private Expression expression;
    private AggregatingContextMatcher orAggregatingContextMatcher;
    private AggregatingContextMatcher currentContextMatcher;
    private AggregatingContextMatcher outerContextMatcher;
    private Quantifier.Builder quantifierBuilder;
    private boolean strictEventTypeMatching;
    private EvaluationCondition stopCondition;
    private static Map<String, BiFunction<Integer,Pattern<Event,Event>,Pattern<Event,Event>>> timeWindowAppliers = new HashMap<>();
    private BiFunction<Pattern<Event,Event>, String, Pattern<Event,Event>> patternCombiner = Pattern::next;
    private Stack<BiConsumer<PdlListener, Integer>> numberConstantApplier = new Stack<>();
    private Stack<BiConsumer<PdlListener, String>> stringConstantApplier = new Stack<>();


    static {
        timeWindowAppliers.put("h", (v,p) -> p.within(Time.hours(v)));
        timeWindowAppliers.put("m", (v,p) -> p.within(Time.minutes(v)));
        timeWindowAppliers.put("s", (v,p) -> p.within(Time.seconds(v)));
        timeWindowAppliers.put("ms", (v,p) -> p.within(Time.milliseconds(v)));
    }

    /**
     * Skip past strategy name used for identifying pattern name to skip after match.
     * SKIP_TO_FIRST, SKIP_TO_LAST options are require this property.
     * @see <a href="https://ci.apache.org/projects/flink/flink-docs-stable/dev/libs/cep.html#after-match-skip-strategy">After Match Skip Strategy</a>
     */
    private String skipStrategyPatternName;
    private AfterMatchSkipStrategy afterMatchSkipStrategy = AfterMatchSkipStrategy.noSkip();

    public PdlListener(boolean strictEventTypeMatching) {
        this.strictEventTypeMatching = strictEventTypeMatching;
    }

    @Override
    public void enterSkipToFirst(PDLParser.SkipToFirstContext ctx) {
        this.stringConstantApplier.push((t,v) -> t.skipStrategyPatternName = v);
    }

    @Override
    public void enterSkipToLast(PDLParser.SkipToLastContext ctx) {
        this.stringConstantApplier.push((t,v) -> t.skipStrategyPatternName = v);
    }

    @Override
    public void exitNoSkip(PDLParser.NoSkipContext ctx) {
        this.afterMatchSkipStrategy = AfterMatchSkipStrategy.noSkip();
    }

    @Override
    public void exitSkipToNext(PDLParser.SkipToNextContext ctx) {
        this.afterMatchSkipStrategy = AfterMatchSkipStrategy.skipToNext();
    }

    @Override
    public void exitSkipPastLast(PDLParser.SkipPastLastContext ctx) {
        this.afterMatchSkipStrategy = AfterMatchSkipStrategy.skipPastLastEvent();
    }

    @Override
    public void exitSkipToFirst(PDLParser.SkipToFirstContext ctx) {
        stringConstantApplier.pop();
        this.afterMatchSkipStrategy = AfterMatchSkipStrategy.skipToFirst(this.skipStrategyPatternName);
    }

    @Override
    public void exitSkipToLast(PDLParser.SkipToLastContext ctx) {
        stringConstantApplier.pop();
        this.afterMatchSkipStrategy = AfterMatchSkipStrategy.skipToLast(this.skipStrategyPatternName);
    }

    @Override
    public void enterNext(PDLParser.NextContext ctx) {
        patternCombiner = Pattern::next;
    }

    @Override
    public void enterFollowedBy(PDLParser.FollowedByContext ctx) {
        patternCombiner = Pattern::followedBy;
    }

    @Override
    public void enterFollowedByAny(PDLParser.FollowedByAnyContext ctx) {
        patternCombiner = Pattern::followedByAny;
    }

    @Override
    public void enterNotNext(PDLParser.NotNextContext ctx) {
        patternCombiner = Pattern::notNext;
    }

    @Override
    public void enterNotFollowedBy(PDLParser.NotFollowedByContext ctx) {
        patternCombiner = Pattern::notFollowedBy;
    }

    @Override
    public void enterPattern(PDLParser.PatternContext ctx) {
        this.quantifierBuilder = new Quantifier.Builder();
        this.outerContextMatcher = AggregatingContextMatcher.and();
        this.numberConstantApplier.push((t,v) -> t.quantifierBuilder = t.quantifierBuilder.bound(v));
    }

    @Override
    public void exitPattern(PDLParser.PatternContext ctx) {
        pattern = pattern.where(new EvaluationCondition(outerContextMatcher));
        this.pattern = this.quantifierBuilder.build().apply(pattern);
        this.numberConstantApplier.pop();
    }

    @Override
    public void enterPatternName(PDLParser.PatternNameContext ctx) {
        if (pattern == null) {
            pattern = Pattern.begin(ctx.getText(), afterMatchSkipStrategy);
        }
        else {
            pattern = patternCombiner.apply(pattern,ctx.getText());
        }
        outerContextMatcher.add(eventTypeMatcherFor(ctx.getText()));
    }

    private ContextMatcher eventTypeMatcherFor(String text) {
        return strictEventTypeMatching ?
                EventTypeContextMatcher.matching(text) :
                EventTypeContextMatcher.ignoring();
    }

    @Override
    public void enterTimes(PDLParser.TimesContext ctx) {
        this.quantifierBuilder = quantifierBuilder.times();
    }

    @Override
    public void enterTimesOrMore(PDLParser.TimesOrMoreContext ctx) {
        this.quantifierBuilder = quantifierBuilder.timesOrMore();
    }

    @Override
    public void enterOneOrMore(PDLParser.OneOrMoreContext ctx) {
        this.quantifierBuilder = quantifierBuilder.oneOrMore();
    }

    @Override
    public void enterZeroOrMore(PDLParser.ZeroOrMoreContext ctx) {
        this.quantifierBuilder = quantifierBuilder.zeroOrMore();
    }

    @Override
    public void enterOptional(PDLParser.OptionalContext ctx) {
        this.quantifierBuilder = quantifierBuilder.optional();
    }

    @Override
    public void enterGreedy(PDLParser.GreedyContext ctx) {
        this.quantifierBuilder = quantifierBuilder.greedy();
    }

    @Override
    public void exitCondition(PDLParser.ConditionContext ctx) {
        outerContextMatcher.add(orAggregatingContextMatcher);
    }

    @Override
    public void enterOrExpression(PDLParser.OrExpressionContext ctx) {
        orAggregatingContextMatcher = AggregatingContextMatcher.or();
        currentContextMatcher = orAggregatingContextMatcher;
    }

    @Override
    public void enterAndExpression(PDLParser.AndExpressionContext ctx) {
        currentContextMatcher = AggregatingContextMatcher.and();
    }

    @Override
    public void exitAndExpression(PDLParser.AndExpressionContext ctx) {
        orAggregatingContextMatcher.add(currentContextMatcher);
        currentContextMatcher = orAggregatingContextMatcher;
    }

    @Override
    public void enterOperation(PDLParser.OperationContext ctx) {
        this.expression = new Expression();
        numberConstantApplier.push((t,v) -> t.expression.setValue(v));
        stringConstantApplier.push((t,v) -> t.expression.setValue(v));
    }

    @Override
    public void exitOperation(PDLParser.OperationContext ctx) {
        currentContextMatcher.add(expression);
        expression = null;
        numberConstantApplier.pop();
        stringConstantApplier.pop();
    }

    @Override
    public void enterEqualsOperation(PDLParser.EqualsOperationContext ctx) {
        this.expression.setOperator(Operator.EQUALS);
    }

    @Override
    public void enterNotEqualsOperation(PDLParser.NotEqualsOperationContext ctx) {
        this.expression.setOperator(Operator.NOT_EQUALS);
    }

    @Override
    public void enterLowerThanOperation(PDLParser.LowerThanOperationContext ctx) {
        this.expression.setOperator(Operator.LOWER_THAN);
    }

    @Override
    public void enterLowerEqualsOperation(PDLParser.LowerEqualsOperationContext ctx) {
        this.expression.setOperator(Operator.LOWER_EQUALS);
    }

    @Override
    public void enterGreaterThanOperation(PDLParser.GreaterThanOperationContext ctx) {
        this.expression.setOperator(Operator.GREATER_THAN);
    }

    @Override
    public void enterGreaterEqualsOperation(PDLParser.GreaterEqualsOperationContext ctx) {
        this.expression.setOperator(Operator.GREATER_EQUALS);
    }

    @Override
    public void enterContainsOperation(PDLParser.ContainsOperationContext ctx) {
        this.expression.setOperator(Operator.CONTAINS);
    }

    @Override
    public void enterNotContainsOperation(PDLParser.NotContainsOperationContext ctx) {
        this.expression.setOperator(Operator.NOT_CONTAINS);
    }

    @Override
    public void exitStopCondition(PDLParser.StopConditionContext ctx) {
        stopCondition = new EvaluationCondition(orAggregatingContextMatcher);
    }

    @Override
    public void enterTimeWindow(PDLParser.TimeWindowContext ctx) {
        pattern = timeWindowAppliers.get(ctx.u.getText()).apply(Integer.parseInt(ctx.c.getText()), pattern);
        numberConstantApplier.push((l,v) -> {});
    }

    @Override
    public void exitTimeWindow(PDLParser.TimeWindowContext ctx) {
        numberConstantApplier.pop();
    }

    @Override
    public void exitEventPropertyIdent(PDLParser.EventPropertyIdentContext ctx) {
        if (expression.hasAttribute()) {
            if (expression.hasValueClassIdentifier()) {
                expression.setValueAttribute(ctx.getText());
            }
            else {
                expression.setValueClassIdentifier(ctx.getText());
            }
        }
        else {
            expression.setAttribute(ctx.getText());
        }
    }

    @Override
    public void exitStringconstant(PDLParser.StringconstantContext ctx) {
        String substring = ctx.getText().substring(1, ctx.getText().length() - 1);
        stringConstantApplier.peek().accept(this, substring);
    }

    @Override
    public void exitConstant(PDLParser.ConstantContext ctx) {
        if ((true+"").equals(ctx.getText())) {
            this.expression.setValue(true);
        }
        if ((false+"").equals(ctx.getText())) {
            this.expression.setValue(false);
        }
    }

    @Override
    public void exitNumberconstant(PDLParser.NumberconstantContext ctx) {
        int timesOrValue = Integer.parseInt(ctx.getText());
        numberConstantApplier.peek().accept(this, timesOrValue);
    }

    public Pattern<Event, Event> getPattern() {
        if (stopCondition != null) {
            pattern = pattern.until(stopCondition);
        }

        return pattern;
    }
}
