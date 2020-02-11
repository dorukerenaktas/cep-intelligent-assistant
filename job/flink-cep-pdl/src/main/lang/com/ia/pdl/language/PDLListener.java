// Generated from PDL.g4 by ANTLR 4.7.1

package com.ia.pdl.language ;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PDLParser}.
 */
public interface PDLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PDLParser#patternSequence}.
	 * @param ctx the parse tree
	 */
	void enterPatternSequence(PDLParser.PatternSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#patternSequence}.
	 * @param ctx the parse tree
	 */
	void exitPatternSequence(PDLParser.PatternSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#skipStrategy}.
	 * @param ctx the parse tree
	 */
	void enterSkipStrategy(PDLParser.SkipStrategyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#skipStrategy}.
	 * @param ctx the parse tree
	 */
	void exitSkipStrategy(PDLParser.SkipStrategyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#noSkip}.
	 * @param ctx the parse tree
	 */
	void enterNoSkip(PDLParser.NoSkipContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#noSkip}.
	 * @param ctx the parse tree
	 */
	void exitNoSkip(PDLParser.NoSkipContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#skipToNext}.
	 * @param ctx the parse tree
	 */
	void enterSkipToNext(PDLParser.SkipToNextContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#skipToNext}.
	 * @param ctx the parse tree
	 */
	void exitSkipToNext(PDLParser.SkipToNextContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#skipPastLast}.
	 * @param ctx the parse tree
	 */
	void enterSkipPastLast(PDLParser.SkipPastLastContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#skipPastLast}.
	 * @param ctx the parse tree
	 */
	void exitSkipPastLast(PDLParser.SkipPastLastContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#skipToFirst}.
	 * @param ctx the parse tree
	 */
	void enterSkipToFirst(PDLParser.SkipToFirstContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#skipToFirst}.
	 * @param ctx the parse tree
	 */
	void exitSkipToFirst(PDLParser.SkipToFirstContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#skipToLast}.
	 * @param ctx the parse tree
	 */
	void enterSkipToLast(PDLParser.SkipToLastContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#skipToLast}.
	 * @param ctx the parse tree
	 */
	void exitSkipToLast(PDLParser.SkipToLastContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#patternCombination}.
	 * @param ctx the parse tree
	 */
	void enterPatternCombination(PDLParser.PatternCombinationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#patternCombination}.
	 * @param ctx the parse tree
	 */
	void exitPatternCombination(PDLParser.PatternCombinationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#next}.
	 * @param ctx the parse tree
	 */
	void enterNext(PDLParser.NextContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#next}.
	 * @param ctx the parse tree
	 */
	void exitNext(PDLParser.NextContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#followedBy}.
	 * @param ctx the parse tree
	 */
	void enterFollowedBy(PDLParser.FollowedByContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#followedBy}.
	 * @param ctx the parse tree
	 */
	void exitFollowedBy(PDLParser.FollowedByContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#followedByAny}.
	 * @param ctx the parse tree
	 */
	void enterFollowedByAny(PDLParser.FollowedByAnyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#followedByAny}.
	 * @param ctx the parse tree
	 */
	void exitFollowedByAny(PDLParser.FollowedByAnyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#notNext}.
	 * @param ctx the parse tree
	 */
	void enterNotNext(PDLParser.NotNextContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#notNext}.
	 * @param ctx the parse tree
	 */
	void exitNotNext(PDLParser.NotNextContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#notFollowedBy}.
	 * @param ctx the parse tree
	 */
	void enterNotFollowedBy(PDLParser.NotFollowedByContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#notFollowedBy}.
	 * @param ctx the parse tree
	 */
	void exitNotFollowedBy(PDLParser.NotFollowedByContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(PDLParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(PDLParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#patternName}.
	 * @param ctx the parse tree
	 */
	void enterPatternName(PDLParser.PatternNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#patternName}.
	 * @param ctx the parse tree
	 */
	void exitPatternName(PDLParser.PatternNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(PDLParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(PDLParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#times}.
	 * @param ctx the parse tree
	 */
	void enterTimes(PDLParser.TimesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#times}.
	 * @param ctx the parse tree
	 */
	void exitTimes(PDLParser.TimesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#timesOrMore}.
	 * @param ctx the parse tree
	 */
	void enterTimesOrMore(PDLParser.TimesOrMoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#timesOrMore}.
	 * @param ctx the parse tree
	 */
	void exitTimesOrMore(PDLParser.TimesOrMoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#oneOrMore}.
	 * @param ctx the parse tree
	 */
	void enterOneOrMore(PDLParser.OneOrMoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#oneOrMore}.
	 * @param ctx the parse tree
	 */
	void exitOneOrMore(PDLParser.OneOrMoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#zeroOrMore}.
	 * @param ctx the parse tree
	 */
	void enterZeroOrMore(PDLParser.ZeroOrMoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#zeroOrMore}.
	 * @param ctx the parse tree
	 */
	void exitZeroOrMore(PDLParser.ZeroOrMoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#optional}.
	 * @param ctx the parse tree
	 */
	void enterOptional(PDLParser.OptionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#optional}.
	 * @param ctx the parse tree
	 */
	void exitOptional(PDLParser.OptionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#greedy}.
	 * @param ctx the parse tree
	 */
	void enterGreedy(PDLParser.GreedyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#greedy}.
	 * @param ctx the parse tree
	 */
	void exitGreedy(PDLParser.GreedyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(PDLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(PDLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#stopCondition}.
	 * @param ctx the parse tree
	 */
	void enterStopCondition(PDLParser.StopConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#stopCondition}.
	 * @param ctx the parse tree
	 */
	void exitStopCondition(PDLParser.StopConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PDLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PDLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(PDLParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#orExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(PDLParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(PDLParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(PDLParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(PDLParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(PDLParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#equalsOperation}.
	 * @param ctx the parse tree
	 */
	void enterEqualsOperation(PDLParser.EqualsOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#equalsOperation}.
	 * @param ctx the parse tree
	 */
	void exitEqualsOperation(PDLParser.EqualsOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#notEqualsOperation}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualsOperation(PDLParser.NotEqualsOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#notEqualsOperation}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualsOperation(PDLParser.NotEqualsOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#lowerThanOperation}.
	 * @param ctx the parse tree
	 */
	void enterLowerThanOperation(PDLParser.LowerThanOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#lowerThanOperation}.
	 * @param ctx the parse tree
	 */
	void exitLowerThanOperation(PDLParser.LowerThanOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#lowerEqualsOperation}.
	 * @param ctx the parse tree
	 */
	void enterLowerEqualsOperation(PDLParser.LowerEqualsOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#lowerEqualsOperation}.
	 * @param ctx the parse tree
	 */
	void exitLowerEqualsOperation(PDLParser.LowerEqualsOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#greaterThanOperation}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanOperation(PDLParser.GreaterThanOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#greaterThanOperation}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanOperation(PDLParser.GreaterThanOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#greaterEqualsOperation}.
	 * @param ctx the parse tree
	 */
	void enterGreaterEqualsOperation(PDLParser.GreaterEqualsOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#greaterEqualsOperation}.
	 * @param ctx the parse tree
	 */
	void exitGreaterEqualsOperation(PDLParser.GreaterEqualsOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#containsOperation}.
	 * @param ctx the parse tree
	 */
	void enterContainsOperation(PDLParser.ContainsOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#containsOperation}.
	 * @param ctx the parse tree
	 */
	void exitContainsOperation(PDLParser.ContainsOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#notContainsOperation}.
	 * @param ctx the parse tree
	 */
	void enterNotContainsOperation(PDLParser.NotContainsOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#notContainsOperation}.
	 * @param ctx the parse tree
	 */
	void exitNotContainsOperation(PDLParser.NotContainsOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(PDLParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(PDLParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#eventProperty}.
	 * @param ctx the parse tree
	 */
	void enterEventProperty(PDLParser.EventPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#eventProperty}.
	 * @param ctx the parse tree
	 */
	void exitEventProperty(PDLParser.EventPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#eventPropertyAtomic}.
	 * @param ctx the parse tree
	 */
	void enterEventPropertyAtomic(PDLParser.EventPropertyAtomicContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#eventPropertyAtomic}.
	 * @param ctx the parse tree
	 */
	void exitEventPropertyAtomic(PDLParser.EventPropertyAtomicContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#eventPropertyIdent}.
	 * @param ctx the parse tree
	 */
	void enterEventPropertyIdent(PDLParser.EventPropertyIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#eventPropertyIdent}.
	 * @param ctx the parse tree
	 */
	void exitEventPropertyIdent(PDLParser.EventPropertyIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#timeWindow}.
	 * @param ctx the parse tree
	 */
	void enterTimeWindow(PDLParser.TimeWindowContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#timeWindow}.
	 * @param ctx the parse tree
	 */
	void exitTimeWindow(PDLParser.TimeWindowContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(PDLParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(PDLParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#numberconstant}.
	 * @param ctx the parse tree
	 */
	void enterNumberconstant(PDLParser.NumberconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#numberconstant}.
	 * @param ctx the parse tree
	 */
	void exitNumberconstant(PDLParser.NumberconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#stringconstant}.
	 * @param ctx the parse tree
	 */
	void enterStringconstant(PDLParser.StringconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#stringconstant}.
	 * @param ctx the parse tree
	 */
	void exitStringconstant(PDLParser.StringconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#keywordAllowedIdent}.
	 * @param ctx the parse tree
	 */
	void enterKeywordAllowedIdent(PDLParser.KeywordAllowedIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#keywordAllowedIdent}.
	 * @param ctx the parse tree
	 */
	void exitKeywordAllowedIdent(PDLParser.KeywordAllowedIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PDLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PDLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PDLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PDLParser.NumberContext ctx);
}