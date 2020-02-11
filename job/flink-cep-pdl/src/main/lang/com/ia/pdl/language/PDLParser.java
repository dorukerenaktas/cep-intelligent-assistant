// Generated from PDL.g4 by ANTLR 4.7.1

package com.ia.pdl.language ;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PDLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SKIP_NO_SKIP=1, SKIP_TO_NEXT=2, SKIP_SKIP_PAST_LAST=3, SKIP_SKIP_TO_FIRST=4, 
		SKIP_SKIP_TO_LAST=5, IN_SET=6, BETWEEN=7, LIKE=8, REGEXP=9, ESCAPE=10, 
		OR_EXPR=11, AND_EXPR=12, NOT_EXPR=13, WHERE=14, AS=15, SUM=16, AVG=17, 
		MAX=18, MIN=19, ON=20, IS=21, WEEKDAY=22, LW=23, INSTANCEOF=24, TYPEOF=25, 
		CAST=26, CURRENT_TIMESTAMP=27, UNTIL=28, AT=29, TIMEPERIOD_YEAR=30, TIMEPERIOD_YEARS=31, 
		TIMEPERIOD_MONTH=32, TIMEPERIOD_MONTHS=33, TIMEPERIOD_WEEK=34, TIMEPERIOD_WEEKS=35, 
		TIMEPERIOD_DAY=36, TIMEPERIOD_DAYS=37, TIMEPERIOD_HOUR=38, TIMEPERIOD_HOURS=39, 
		TIMEPERIOD_MINUTE=40, TIMEPERIOD_MINUTES=41, TIMEPERIOD_SEC=42, TIMEPERIOD_SECOND=43, 
		TIMEPERIOD_SECONDS=44, TIMEPERIOD_MILLISEC=45, TIMEPERIOD_MILLISECOND=46, 
		TIMEPERIOD_MILLISECONDS=47, TIMEPERIOD_MICROSEC=48, TIMEPERIOD_MICROSECOND=49, 
		TIMEPERIOD_MICROSECONDS=50, BOOLEAN_TRUE=51, BOOLEAN_FALSE=52, VALUE_NULL=53, 
		WITHIN=54, HOUR_SHORT=55, MINUTE_SHORT=56, SECOND_SHORT=57, MILLSECONDS_SHORT=58, 
		NEXT=59, FOLLOWED_BY=60, FOLLOWED_BY_ANY=61, NOT_NEXT=62, NOT_FOLLOWED_BY=63, 
		GOES=64, EQUALS=65, QUESTION=66, LPAREN=67, RPAREN=68, LBRACK=69, RBRACK=70, 
		LCURLY=71, RCURLY=72, COLON=73, COMMA=74, LNOT=75, BNOT=76, NOT_EQUAL=77, 
		DIV=78, PLUS=79, MINUS=80, STAR=81, MOD=82, GE=83, GT=84, LE=85, LT=86, 
		CONTAINS=87, NOT_CONTAINS=88, BXOR=89, BOR=90, LOR=91, BAND=92, BAND_ASSIGN=93, 
		LAND=94, SEMI=95, DOT=96, NUM_LONG=97, NUM_DOUBLE=98, NUM_FLOAT=99, ESCAPECHAR=100, 
		ESCAPEBACKTICK=101, ATCHAR=102, HASHCHAR=103, WS=104, SL_COMMENT=105, 
		ML_COMMENT=106, TICKED_STRING_LITERAL=107, QUOTED_STRING_LITERAL=108, 
		STRING_LITERAL=109, INTEGER_LITERAL=110, FLOATING_POINT_LITERAL=111, IDENT=112;
	public static final int
		RULE_patternSequence = 0, RULE_skipStrategy = 1, RULE_noSkip = 2, RULE_skipToNext = 3, 
		RULE_skipPastLast = 4, RULE_skipToFirst = 5, RULE_skipToLast = 6, RULE_patternCombination = 7, 
		RULE_next = 8, RULE_followedBy = 9, RULE_followedByAny = 10, RULE_notNext = 11, 
		RULE_notFollowedBy = 12, RULE_pattern = 13, RULE_patternName = 14, RULE_quantifier = 15, 
		RULE_times = 16, RULE_timesOrMore = 17, RULE_oneOrMore = 18, RULE_zeroOrMore = 19, 
		RULE_optional = 20, RULE_greedy = 21, RULE_condition = 22, RULE_stopCondition = 23, 
		RULE_expression = 24, RULE_orExpression = 25, RULE_andExpression = 26, 
		RULE_operation = 27, RULE_equalsOperation = 28, RULE_notEqualsOperation = 29, 
		RULE_lowerThanOperation = 30, RULE_lowerEqualsOperation = 31, RULE_greaterThanOperation = 32, 
		RULE_greaterEqualsOperation = 33, RULE_containsOperation = 34, RULE_notContainsOperation = 35, 
		RULE_unaryExpression = 36, RULE_eventProperty = 37, RULE_eventPropertyAtomic = 38, 
		RULE_eventPropertyIdent = 39, RULE_timeWindow = 40, RULE_constant = 41, 
		RULE_numberconstant = 42, RULE_stringconstant = 43, RULE_keywordAllowedIdent = 44, 
		RULE_number = 45;
	public static final String[] ruleNames = {
		"patternSequence", "skipStrategy", "noSkip", "skipToNext", "skipPastLast", 
		"skipToFirst", "skipToLast", "patternCombination", "next", "followedBy", 
		"followedByAny", "notNext", "notFollowedBy", "pattern", "patternName", 
		"quantifier", "times", "timesOrMore", "oneOrMore", "zeroOrMore", "optional", 
		"greedy", "condition", "stopCondition", "expression", "orExpression", 
		"andExpression", "operation", "equalsOperation", "notEqualsOperation", 
		"lowerThanOperation", "lowerEqualsOperation", "greaterThanOperation", 
		"greaterEqualsOperation", "containsOperation", "notContainsOperation", 
		"unaryExpression", "eventProperty", "eventPropertyAtomic", "eventPropertyIdent", 
		"timeWindow", "constant", "numberconstant", "stringconstant", "keywordAllowedIdent", 
		"number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'no_skip'", "'skip_to_next'", "'skip_past_last'", "'skip_to_first'", 
		"'skip_to_last'", "'in'", "'between'", "'like'", "'regexp'", "'escape'", 
		"'or'", "'and'", "'not'", "'where'", "'as'", "'sum'", "'avg'", "'max'", 
		"'min'", "'on'", "'is'", "'weekday'", "'lastweekday'", "'instanceof'", 
		"'typeof'", "'cast'", "'current_timestamp'", "'until'", "'at'", "'year'", 
		"'years'", "'month'", "'months'", "'week'", "'weeks'", "'day'", "'days'", 
		"'hour'", "'hours'", "'minute'", "'minutes'", "'sec'", "'second'", "'seconds'", 
		"'msec'", "'millisecond'", "'milliseconds'", "'usec'", "'microsecond'", 
		"'microseconds'", "'true'", "'false'", "'null'", "'within'", "'h'", "'m'", 
		"'s'", "'ms'", "'->>'", "'->'", "'--'", "'!->>'", "'!->'", "'=>'", "'='", 
		"'?'", "'('", "')'", "'['", "']'", "'{'", "'}'", "':'", "','", "'!'", 
		"'~'", "'!='", "'/'", "'+'", "'-'", "'*'", "'%'", "'>='", "'>'", "'<='", 
		"'<'", "'><'", "'>!<'", "'^'", "'|'", "'||'", "'&'", "'&='", "'&&'", "' ;'", 
		"'.'", "'\u18FF'", "'\u18FE'", "'\u18FD'", "'\\'", "'`'", "'@'", "'#'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SKIP_NO_SKIP", "SKIP_TO_NEXT", "SKIP_SKIP_PAST_LAST", "SKIP_SKIP_TO_FIRST", 
		"SKIP_SKIP_TO_LAST", "IN_SET", "BETWEEN", "LIKE", "REGEXP", "ESCAPE", 
		"OR_EXPR", "AND_EXPR", "NOT_EXPR", "WHERE", "AS", "SUM", "AVG", "MAX", 
		"MIN", "ON", "IS", "WEEKDAY", "LW", "INSTANCEOF", "TYPEOF", "CAST", "CURRENT_TIMESTAMP", 
		"UNTIL", "AT", "TIMEPERIOD_YEAR", "TIMEPERIOD_YEARS", "TIMEPERIOD_MONTH", 
		"TIMEPERIOD_MONTHS", "TIMEPERIOD_WEEK", "TIMEPERIOD_WEEKS", "TIMEPERIOD_DAY", 
		"TIMEPERIOD_DAYS", "TIMEPERIOD_HOUR", "TIMEPERIOD_HOURS", "TIMEPERIOD_MINUTE", 
		"TIMEPERIOD_MINUTES", "TIMEPERIOD_SEC", "TIMEPERIOD_SECOND", "TIMEPERIOD_SECONDS", 
		"TIMEPERIOD_MILLISEC", "TIMEPERIOD_MILLISECOND", "TIMEPERIOD_MILLISECONDS", 
		"TIMEPERIOD_MICROSEC", "TIMEPERIOD_MICROSECOND", "TIMEPERIOD_MICROSECONDS", 
		"BOOLEAN_TRUE", "BOOLEAN_FALSE", "VALUE_NULL", "WITHIN", "HOUR_SHORT", 
		"MINUTE_SHORT", "SECOND_SHORT", "MILLSECONDS_SHORT", "NEXT", "FOLLOWED_BY", 
		"FOLLOWED_BY_ANY", "NOT_NEXT", "NOT_FOLLOWED_BY", "GOES", "EQUALS", "QUESTION", 
		"LPAREN", "RPAREN", "LBRACK", "RBRACK", "LCURLY", "RCURLY", "COLON", "COMMA", 
		"LNOT", "BNOT", "NOT_EQUAL", "DIV", "PLUS", "MINUS", "STAR", "MOD", "GE", 
		"GT", "LE", "LT", "CONTAINS", "NOT_CONTAINS", "BXOR", "BOR", "LOR", "BAND", 
		"BAND_ASSIGN", "LAND", "SEMI", "DOT", "NUM_LONG", "NUM_DOUBLE", "NUM_FLOAT", 
		"ESCAPECHAR", "ESCAPEBACKTICK", "ATCHAR", "HASHCHAR", "WS", "SL_COMMENT", 
		"ML_COMMENT", "TICKED_STRING_LITERAL", "QUOTED_STRING_LITERAL", "STRING_LITERAL", 
		"INTEGER_LITERAL", "FLOATING_POINT_LITERAL", "IDENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PDLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PatternSequenceContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PDLParser.EOF, 0); }
		public SkipStrategyContext skipStrategy() {
			return getRuleContext(SkipStrategyContext.class,0);
		}
		public List<PatternCombinationContext> patternCombination() {
			return getRuleContexts(PatternCombinationContext.class);
		}
		public PatternCombinationContext patternCombination(int i) {
			return getRuleContext(PatternCombinationContext.class,i);
		}
		public StopConditionContext stopCondition() {
			return getRuleContext(StopConditionContext.class,0);
		}
		public TimeWindowContext timeWindow() {
			return getRuleContext(TimeWindowContext.class,0);
		}
		public PatternSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterPatternSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitPatternSequence(this);
		}
	}

	public final PatternSequenceContext patternSequence() throws RecognitionException {
		PatternSequenceContext _localctx = new PatternSequenceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_patternSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MOD) {
				{
				setState(92);
				skipStrategy();
				}
			}

			setState(95);
			pattern();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEXT) | (1L << FOLLOWED_BY) | (1L << FOLLOWED_BY_ANY) | (1L << NOT_NEXT) | (1L << NOT_FOLLOWED_BY))) != 0)) {
				{
				{
				setState(96);
				patternCombination();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(102);
				stopCondition();
				}
			}

			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITHIN) {
				{
				setState(105);
				timeWindow();
				}
			}

			setState(108);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipStrategyContext extends ParserRuleContext {
		public TerminalNode MOD() { return getToken(PDLParser.MOD, 0); }
		public NoSkipContext noSkip() {
			return getRuleContext(NoSkipContext.class,0);
		}
		public SkipToNextContext skipToNext() {
			return getRuleContext(SkipToNextContext.class,0);
		}
		public SkipPastLastContext skipPastLast() {
			return getRuleContext(SkipPastLastContext.class,0);
		}
		public SkipToFirstContext skipToFirst() {
			return getRuleContext(SkipToFirstContext.class,0);
		}
		public SkipToLastContext skipToLast() {
			return getRuleContext(SkipToLastContext.class,0);
		}
		public SkipStrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipStrategy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterSkipStrategy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitSkipStrategy(this);
		}
	}

	public final SkipStrategyContext skipStrategy() throws RecognitionException {
		SkipStrategyContext _localctx = new SkipStrategyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_skipStrategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(MOD);
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_NO_SKIP:
				{
				setState(111);
				noSkip();
				}
				break;
			case SKIP_TO_NEXT:
				{
				setState(112);
				skipToNext();
				}
				break;
			case SKIP_SKIP_PAST_LAST:
				{
				setState(113);
				skipPastLast();
				}
				break;
			case SKIP_SKIP_TO_FIRST:
				{
				setState(114);
				skipToFirst();
				}
				break;
			case SKIP_SKIP_TO_LAST:
				{
				setState(115);
				skipToLast();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoSkipContext extends ParserRuleContext {
		public TerminalNode SKIP_NO_SKIP() { return getToken(PDLParser.SKIP_NO_SKIP, 0); }
		public NoSkipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noSkip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterNoSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitNoSkip(this);
		}
	}

	public final NoSkipContext noSkip() throws RecognitionException {
		NoSkipContext _localctx = new NoSkipContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_noSkip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(SKIP_NO_SKIP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipToNextContext extends ParserRuleContext {
		public TerminalNode SKIP_TO_NEXT() { return getToken(PDLParser.SKIP_TO_NEXT, 0); }
		public SkipToNextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipToNext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterSkipToNext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitSkipToNext(this);
		}
	}

	public final SkipToNextContext skipToNext() throws RecognitionException {
		SkipToNextContext _localctx = new SkipToNextContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_skipToNext);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(SKIP_TO_NEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipPastLastContext extends ParserRuleContext {
		public TerminalNode SKIP_SKIP_PAST_LAST() { return getToken(PDLParser.SKIP_SKIP_PAST_LAST, 0); }
		public SkipPastLastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipPastLast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterSkipPastLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitSkipPastLast(this);
		}
	}

	public final SkipPastLastContext skipPastLast() throws RecognitionException {
		SkipPastLastContext _localctx = new SkipPastLastContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_skipPastLast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(SKIP_SKIP_PAST_LAST);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipToFirstContext extends ParserRuleContext {
		public TerminalNode SKIP_SKIP_TO_FIRST() { return getToken(PDLParser.SKIP_SKIP_TO_FIRST, 0); }
		public TerminalNode LBRACK() { return getToken(PDLParser.LBRACK, 0); }
		public StringconstantContext stringconstant() {
			return getRuleContext(StringconstantContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(PDLParser.RBRACK, 0); }
		public SkipToFirstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipToFirst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterSkipToFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitSkipToFirst(this);
		}
	}

	public final SkipToFirstContext skipToFirst() throws RecognitionException {
		SkipToFirstContext _localctx = new SkipToFirstContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_skipToFirst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(SKIP_SKIP_TO_FIRST);
			setState(125);
			match(LBRACK);
			setState(126);
			stringconstant();
			setState(127);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkipToLastContext extends ParserRuleContext {
		public TerminalNode SKIP_SKIP_TO_LAST() { return getToken(PDLParser.SKIP_SKIP_TO_LAST, 0); }
		public TerminalNode LBRACK() { return getToken(PDLParser.LBRACK, 0); }
		public StringconstantContext stringconstant() {
			return getRuleContext(StringconstantContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(PDLParser.RBRACK, 0); }
		public SkipToLastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipToLast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterSkipToLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitSkipToLast(this);
		}
	}

	public final SkipToLastContext skipToLast() throws RecognitionException {
		SkipToLastContext _localctx = new SkipToLastContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_skipToLast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(SKIP_SKIP_TO_LAST);
			setState(130);
			match(LBRACK);
			setState(131);
			stringconstant();
			setState(132);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternCombinationContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public NextContext next() {
			return getRuleContext(NextContext.class,0);
		}
		public FollowedByContext followedBy() {
			return getRuleContext(FollowedByContext.class,0);
		}
		public FollowedByAnyContext followedByAny() {
			return getRuleContext(FollowedByAnyContext.class,0);
		}
		public NotNextContext notNext() {
			return getRuleContext(NotNextContext.class,0);
		}
		public NotFollowedByContext notFollowedBy() {
			return getRuleContext(NotFollowedByContext.class,0);
		}
		public PatternCombinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternCombination; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterPatternCombination(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitPatternCombination(this);
		}
	}

	public final PatternCombinationContext patternCombination() throws RecognitionException {
		PatternCombinationContext _localctx = new PatternCombinationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_patternCombination);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEXT:
				{
				setState(134);
				next();
				}
				break;
			case FOLLOWED_BY:
				{
				setState(135);
				followedBy();
				}
				break;
			case FOLLOWED_BY_ANY:
				{
				setState(136);
				followedByAny();
				}
				break;
			case NOT_NEXT:
				{
				setState(137);
				notNext();
				}
				break;
			case NOT_FOLLOWED_BY:
				{
				setState(138);
				notFollowedBy();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(141);
			pattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NextContext extends ParserRuleContext {
		public TerminalNode NEXT() { return getToken(PDLParser.NEXT, 0); }
		public NextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_next; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterNext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitNext(this);
		}
	}

	public final NextContext next() throws RecognitionException {
		NextContext _localctx = new NextContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_next);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(NEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FollowedByContext extends ParserRuleContext {
		public TerminalNode FOLLOWED_BY() { return getToken(PDLParser.FOLLOWED_BY, 0); }
		public FollowedByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_followedBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterFollowedBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitFollowedBy(this);
		}
	}

	public final FollowedByContext followedBy() throws RecognitionException {
		FollowedByContext _localctx = new FollowedByContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_followedBy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(FOLLOWED_BY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FollowedByAnyContext extends ParserRuleContext {
		public TerminalNode FOLLOWED_BY_ANY() { return getToken(PDLParser.FOLLOWED_BY_ANY, 0); }
		public FollowedByAnyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_followedByAny; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterFollowedByAny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitFollowedByAny(this);
		}
	}

	public final FollowedByAnyContext followedByAny() throws RecognitionException {
		FollowedByAnyContext _localctx = new FollowedByAnyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_followedByAny);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(FOLLOWED_BY_ANY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotNextContext extends ParserRuleContext {
		public TerminalNode NOT_NEXT() { return getToken(PDLParser.NOT_NEXT, 0); }
		public NotNextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notNext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterNotNext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitNotNext(this);
		}
	}

	public final NotNextContext notNext() throws RecognitionException {
		NotNextContext _localctx = new NotNextContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_notNext);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(NOT_NEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotFollowedByContext extends ParserRuleContext {
		public TerminalNode NOT_FOLLOWED_BY() { return getToken(PDLParser.NOT_FOLLOWED_BY, 0); }
		public NotFollowedByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notFollowedBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterNotFollowedBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitNotFollowedBy(this);
		}
	}

	public final NotFollowedByContext notFollowedBy() throws RecognitionException {
		NotFollowedByContext _localctx = new NotFollowedByContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_notFollowedBy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(NOT_FOLLOWED_BY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternContext extends ParserRuleContext {
		public PatternNameContext patternName() {
			return getRuleContext(PatternNameContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitPattern(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			patternName();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (LCURLY - 71)) | (1L << (PLUS - 71)) | (1L << (STAR - 71)))) != 0)) {
				{
				setState(154);
				quantifier();
				}
			}

			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(157);
				condition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternNameContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(PDLParser.IDENT, 0); }
		public TerminalNode TICKED_STRING_LITERAL() { return getToken(PDLParser.TICKED_STRING_LITERAL, 0); }
		public PatternNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterPatternName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitPatternName(this);
		}
	}

	public final PatternNameContext patternName() throws RecognitionException {
		PatternNameContext _localctx = new PatternNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_patternName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !(_la==TICKED_STRING_LITERAL || _la==IDENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierContext extends ParserRuleContext {
		public TimesContext times() {
			return getRuleContext(TimesContext.class,0);
		}
		public TimesOrMoreContext timesOrMore() {
			return getRuleContext(TimesOrMoreContext.class,0);
		}
		public OneOrMoreContext oneOrMore() {
			return getRuleContext(OneOrMoreContext.class,0);
		}
		public ZeroOrMoreContext zeroOrMore() {
			return getRuleContext(ZeroOrMoreContext.class,0);
		}
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_quantifier);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				times();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				timesOrMore();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				oneOrMore();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				zeroOrMore();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimesContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(PDLParser.LCURLY, 0); }
		public List<NumberconstantContext> numberconstant() {
			return getRuleContexts(NumberconstantContext.class);
		}
		public NumberconstantContext numberconstant(int i) {
			return getRuleContext(NumberconstantContext.class,i);
		}
		public TerminalNode RCURLY() { return getToken(PDLParser.RCURLY, 0); }
		public OptionalContext optional() {
			return getRuleContext(OptionalContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PDLParser.COMMA, 0); }
		public GreedyContext greedy() {
			return getRuleContext(GreedyContext.class,0);
		}
		public TimesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_times; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterTimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitTimes(this);
		}
	}

	public final TimesContext times() throws RecognitionException {
		TimesContext _localctx = new TimesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_times);
		int _la;
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(168);
				match(LCURLY);
				setState(169);
				numberconstant();
				setState(170);
				match(RCURLY);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(171);
					optional();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(174);
				match(LCURLY);
				setState(175);
				numberconstant();
				setState(176);
				match(COMMA);
				setState(177);
				numberconstant();
				setState(178);
				match(RCURLY);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(179);
					optional();
					}
				}

				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BXOR) {
					{
					setState(182);
					greedy();
					}
				}

				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimesOrMoreContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(PDLParser.LCURLY, 0); }
		public NumberconstantContext numberconstant() {
			return getRuleContext(NumberconstantContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PDLParser.COMMA, 0); }
		public TerminalNode PLUS() { return getToken(PDLParser.PLUS, 0); }
		public TerminalNode RCURLY() { return getToken(PDLParser.RCURLY, 0); }
		public OptionalContext optional() {
			return getRuleContext(OptionalContext.class,0);
		}
		public GreedyContext greedy() {
			return getRuleContext(GreedyContext.class,0);
		}
		public TimesOrMoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timesOrMore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterTimesOrMore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitTimesOrMore(this);
		}
	}

	public final TimesOrMoreContext timesOrMore() throws RecognitionException {
		TimesOrMoreContext _localctx = new TimesOrMoreContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_timesOrMore);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(LCURLY);
			setState(188);
			numberconstant();
			setState(189);
			match(COMMA);
			setState(190);
			match(PLUS);
			setState(191);
			match(RCURLY);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(192);
				optional();
				}
			}

			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BXOR) {
				{
				setState(195);
				greedy();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OneOrMoreContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PDLParser.PLUS, 0); }
		public OptionalContext optional() {
			return getRuleContext(OptionalContext.class,0);
		}
		public GreedyContext greedy() {
			return getRuleContext(GreedyContext.class,0);
		}
		public OneOrMoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneOrMore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterOneOrMore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitOneOrMore(this);
		}
	}

	public final OneOrMoreContext oneOrMore() throws RecognitionException {
		OneOrMoreContext _localctx = new OneOrMoreContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_oneOrMore);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(PLUS);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(199);
				optional();
				}
			}

			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BXOR) {
				{
				setState(202);
				greedy();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ZeroOrMoreContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PDLParser.STAR, 0); }
		public OptionalContext optional() {
			return getRuleContext(OptionalContext.class,0);
		}
		public GreedyContext greedy() {
			return getRuleContext(GreedyContext.class,0);
		}
		public ZeroOrMoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zeroOrMore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterZeroOrMore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitZeroOrMore(this);
		}
	}

	public final ZeroOrMoreContext zeroOrMore() throws RecognitionException {
		ZeroOrMoreContext _localctx = new ZeroOrMoreContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_zeroOrMore);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(STAR);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(206);
				optional();
				}
			}

			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BXOR) {
				{
				setState(209);
				greedy();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionalContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(PDLParser.QUESTION, 0); }
		public OptionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterOptional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitOptional(this);
		}
	}

	public final OptionalContext optional() throws RecognitionException {
		OptionalContext _localctx = new OptionalContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_optional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(QUESTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GreedyContext extends ParserRuleContext {
		public TerminalNode BXOR() { return getToken(PDLParser.BXOR, 0); }
		public GreedyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greedy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterGreedy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitGreedy(this);
		}
	}

	public final GreedyContext greedy() throws RecognitionException {
		GreedyContext _localctx = new GreedyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_greedy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(BXOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(PDLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PDLParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(LPAREN);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ESCAPE) | (1L << SUM) | (1L << AVG) | (1L << MAX) | (1L << MIN) | (1L << WEEKDAY) | (1L << LW) | (1L << INSTANCEOF) | (1L << TYPEOF) | (1L << CAST) | (1L << UNTIL) | (1L << AT) | (1L << BOOLEAN_TRUE) | (1L << BOOLEAN_FALSE) | (1L << VALUE_NULL))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (PLUS - 79)) | (1L << (MINUS - 79)) | (1L << (TICKED_STRING_LITERAL - 79)) | (1L << (QUOTED_STRING_LITERAL - 79)) | (1L << (STRING_LITERAL - 79)) | (1L << (INTEGER_LITERAL - 79)) | (1L << (FLOATING_POINT_LITERAL - 79)) | (1L << (IDENT - 79)))) != 0)) {
				{
				setState(217);
				expression();
				}
			}

			setState(220);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StopConditionContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(PDLParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(PDLParser.RBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StopConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stopCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterStopCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitStopCondition(this);
		}
	}

	public final StopConditionContext stopCondition() throws RecognitionException {
		StopConditionContext _localctx = new StopConditionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stopCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(LBRACK);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ESCAPE) | (1L << SUM) | (1L << AVG) | (1L << MAX) | (1L << MIN) | (1L << WEEKDAY) | (1L << LW) | (1L << INSTANCEOF) | (1L << TYPEOF) | (1L << CAST) | (1L << UNTIL) | (1L << AT) | (1L << BOOLEAN_TRUE) | (1L << BOOLEAN_FALSE) | (1L << VALUE_NULL))) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & ((1L << (PLUS - 79)) | (1L << (MINUS - 79)) | (1L << (TICKED_STRING_LITERAL - 79)) | (1L << (QUOTED_STRING_LITERAL - 79)) | (1L << (STRING_LITERAL - 79)) | (1L << (INTEGER_LITERAL - 79)) | (1L << (FLOATING_POINT_LITERAL - 79)) | (1L << (IDENT - 79)))) != 0)) {
				{
				setState(223);
				expression();
				}
			}

			setState(226);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			orExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExpressionContext extends ParserRuleContext {
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR_EXPR() { return getTokens(PDLParser.OR_EXPR); }
		public TerminalNode OR_EXPR(int i) {
			return getToken(PDLParser.OR_EXPR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitOrExpression(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			andExpression();
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR_EXPR) {
				{
				{
				setState(231);
				match(OR_EXPR);
				setState(232);
				andExpression();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public List<TerminalNode> AND_EXPR() { return getTokens(PDLParser.AND_EXPR); }
		public TerminalNode AND_EXPR(int i) {
			return getToken(PDLParser.AND_EXPR, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitAndExpression(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			operation();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND_EXPR) {
				{
				{
				setState(239);
				match(AND_EXPR);
				setState(240);
				operation();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public EqualsOperationContext equalsOperation() {
			return getRuleContext(EqualsOperationContext.class,0);
		}
		public NotEqualsOperationContext notEqualsOperation() {
			return getRuleContext(NotEqualsOperationContext.class,0);
		}
		public LowerThanOperationContext lowerThanOperation() {
			return getRuleContext(LowerThanOperationContext.class,0);
		}
		public LowerEqualsOperationContext lowerEqualsOperation() {
			return getRuleContext(LowerEqualsOperationContext.class,0);
		}
		public GreaterThanOperationContext greaterThanOperation() {
			return getRuleContext(GreaterThanOperationContext.class,0);
		}
		public GreaterEqualsOperationContext greaterEqualsOperation() {
			return getRuleContext(GreaterEqualsOperationContext.class,0);
		}
		public ContainsOperationContext containsOperation() {
			return getRuleContext(ContainsOperationContext.class,0);
		}
		public NotContainsOperationContext notContainsOperation() {
			return getRuleContext(NotContainsOperationContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitOperation(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_operation);
		try {
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				equalsOperation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				notEqualsOperation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				lowerThanOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				lowerEqualsOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(250);
				greaterThanOperation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(251);
				greaterEqualsOperation();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(252);
				containsOperation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(253);
				notContainsOperation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualsOperationContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(PDLParser.EQUALS, 0); }
		public EqualsOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalsOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterEqualsOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitEqualsOperation(this);
		}
	}

	public final EqualsOperationContext equalsOperation() throws RecognitionException {
		EqualsOperationContext _localctx = new EqualsOperationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_equalsOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			unaryExpression();
			setState(257);
			match(EQUALS);
			setState(258);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotEqualsOperationContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode NOT_EQUAL() { return getToken(PDLParser.NOT_EQUAL, 0); }
		public NotEqualsOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notEqualsOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterNotEqualsOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitNotEqualsOperation(this);
		}
	}

	public final NotEqualsOperationContext notEqualsOperation() throws RecognitionException {
		NotEqualsOperationContext _localctx = new NotEqualsOperationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_notEqualsOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			unaryExpression();
			setState(261);
			match(NOT_EQUAL);
			setState(262);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LowerThanOperationContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(PDLParser.LT, 0); }
		public LowerThanOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerThanOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterLowerThanOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitLowerThanOperation(this);
		}
	}

	public final LowerThanOperationContext lowerThanOperation() throws RecognitionException {
		LowerThanOperationContext _localctx = new LowerThanOperationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_lowerThanOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			unaryExpression();
			setState(265);
			match(LT);
			setState(266);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LowerEqualsOperationContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode LE() { return getToken(PDLParser.LE, 0); }
		public LowerEqualsOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowerEqualsOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterLowerEqualsOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitLowerEqualsOperation(this);
		}
	}

	public final LowerEqualsOperationContext lowerEqualsOperation() throws RecognitionException {
		LowerEqualsOperationContext _localctx = new LowerEqualsOperationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_lowerEqualsOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			unaryExpression();
			setState(269);
			match(LE);
			setState(270);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GreaterThanOperationContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode GT() { return getToken(PDLParser.GT, 0); }
		public GreaterThanOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterThanOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterGreaterThanOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitGreaterThanOperation(this);
		}
	}

	public final GreaterThanOperationContext greaterThanOperation() throws RecognitionException {
		GreaterThanOperationContext _localctx = new GreaterThanOperationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_greaterThanOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			unaryExpression();
			setState(273);
			match(GT);
			setState(274);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GreaterEqualsOperationContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode GE() { return getToken(PDLParser.GE, 0); }
		public GreaterEqualsOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterEqualsOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterGreaterEqualsOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitGreaterEqualsOperation(this);
		}
	}

	public final GreaterEqualsOperationContext greaterEqualsOperation() throws RecognitionException {
		GreaterEqualsOperationContext _localctx = new GreaterEqualsOperationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_greaterEqualsOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			unaryExpression();
			setState(277);
			match(GE);
			setState(278);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContainsOperationContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode CONTAINS() { return getToken(PDLParser.CONTAINS, 0); }
		public ContainsOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_containsOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterContainsOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitContainsOperation(this);
		}
	}

	public final ContainsOperationContext containsOperation() throws RecognitionException {
		ContainsOperationContext _localctx = new ContainsOperationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_containsOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			unaryExpression();
			setState(281);
			match(CONTAINS);
			setState(282);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotContainsOperationContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public TerminalNode NOT_CONTAINS() { return getToken(PDLParser.NOT_CONTAINS, 0); }
		public NotContainsOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notContainsOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterNotContainsOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitNotContainsOperation(this);
		}
	}

	public final NotContainsOperationContext notContainsOperation() throws RecognitionException {
		NotContainsOperationContext _localctx = new NotContainsOperationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_notContainsOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			unaryExpression();
			setState(285);
			match(NOT_CONTAINS);
			setState(286);
			unaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public EventPropertyContext eventProperty() {
			return getRuleContext(EventPropertyContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_unaryExpression);
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESCAPE:
			case SUM:
			case AVG:
			case MAX:
			case MIN:
			case WEEKDAY:
			case LW:
			case INSTANCEOF:
			case TYPEOF:
			case CAST:
			case UNTIL:
			case AT:
			case TICKED_STRING_LITERAL:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				eventProperty();
				}
				break;
			case BOOLEAN_TRUE:
			case BOOLEAN_FALSE:
			case VALUE_NULL:
			case PLUS:
			case MINUS:
			case QUOTED_STRING_LITERAL:
			case STRING_LITERAL:
			case INTEGER_LITERAL:
			case FLOATING_POINT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				constant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventPropertyContext extends ParserRuleContext {
		public List<EventPropertyAtomicContext> eventPropertyAtomic() {
			return getRuleContexts(EventPropertyAtomicContext.class);
		}
		public EventPropertyAtomicContext eventPropertyAtomic(int i) {
			return getRuleContext(EventPropertyAtomicContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(PDLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PDLParser.DOT, i);
		}
		public EventPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterEventProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitEventProperty(this);
		}
	}

	public final EventPropertyContext eventProperty() throws RecognitionException {
		EventPropertyContext _localctx = new EventPropertyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_eventProperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			eventPropertyAtomic();
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(293);
				match(DOT);
				setState(294);
				eventPropertyAtomic();
				}
				}
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventPropertyAtomicContext extends ParserRuleContext {
		public Token lb;
		public NumberContext ni;
		public Token q;
		public Token lp;
		public Token s;
		public Token q1;
		public EventPropertyIdentContext eventPropertyIdent() {
			return getRuleContext(EventPropertyIdentContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(PDLParser.RBRACK, 0); }
		public TerminalNode RPAREN() { return getToken(PDLParser.RPAREN, 0); }
		public TerminalNode LBRACK() { return getToken(PDLParser.LBRACK, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PDLParser.LPAREN, 0); }
		public TerminalNode QUESTION() { return getToken(PDLParser.QUESTION, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(PDLParser.STRING_LITERAL, 0); }
		public TerminalNode QUOTED_STRING_LITERAL() { return getToken(PDLParser.QUOTED_STRING_LITERAL, 0); }
		public EventPropertyAtomicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventPropertyAtomic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterEventPropertyAtomic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitEventPropertyAtomic(this);
		}
	}

	public final EventPropertyAtomicContext eventPropertyAtomic() throws RecognitionException {
		EventPropertyAtomicContext _localctx = new EventPropertyAtomicContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_eventPropertyAtomic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			eventPropertyIdent();
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACK:
				{
				setState(301);
				((EventPropertyAtomicContext)_localctx).lb = match(LBRACK);
				setState(302);
				((EventPropertyAtomicContext)_localctx).ni = number();
				setState(303);
				match(RBRACK);
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(304);
					((EventPropertyAtomicContext)_localctx).q = match(QUESTION);
					}
				}

				}
				break;
			case LPAREN:
				{
				setState(307);
				((EventPropertyAtomicContext)_localctx).lp = match(LPAREN);
				setState(310);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING_LITERAL:
					{
					setState(308);
					((EventPropertyAtomicContext)_localctx).s = match(STRING_LITERAL);
					}
					break;
				case QUOTED_STRING_LITERAL:
					{
					setState(309);
					((EventPropertyAtomicContext)_localctx).s = match(QUOTED_STRING_LITERAL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(312);
				match(RPAREN);
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUESTION) {
					{
					setState(313);
					((EventPropertyAtomicContext)_localctx).q = match(QUESTION);
					}
				}

				}
				break;
			case QUESTION:
				{
				setState(316);
				((EventPropertyAtomicContext)_localctx).q1 = match(QUESTION);
				}
				break;
			case OR_EXPR:
			case AND_EXPR:
			case EQUALS:
			case RPAREN:
			case RBRACK:
			case NOT_EQUAL:
			case GE:
			case GT:
			case LE:
			case LT:
			case CONTAINS:
			case NOT_CONTAINS:
			case DOT:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EventPropertyIdentContext extends ParserRuleContext {
		public KeywordAllowedIdentContext ipi;
		public KeywordAllowedIdentContext ipi2;
		public List<KeywordAllowedIdentContext> keywordAllowedIdent() {
			return getRuleContexts(KeywordAllowedIdentContext.class);
		}
		public KeywordAllowedIdentContext keywordAllowedIdent(int i) {
			return getRuleContext(KeywordAllowedIdentContext.class,i);
		}
		public List<TerminalNode> ESCAPECHAR() { return getTokens(PDLParser.ESCAPECHAR); }
		public TerminalNode ESCAPECHAR(int i) {
			return getToken(PDLParser.ESCAPECHAR, i);
		}
		public List<TerminalNode> DOT() { return getTokens(PDLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PDLParser.DOT, i);
		}
		public EventPropertyIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventPropertyIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterEventPropertyIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitEventPropertyIdent(this);
		}
	}

	public final EventPropertyIdentContext eventPropertyIdent() throws RecognitionException {
		EventPropertyIdentContext _localctx = new EventPropertyIdentContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_eventPropertyIdent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			((EventPropertyIdentContext)_localctx).ipi = keywordAllowedIdent();
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESCAPECHAR) {
				{
				{
				setState(320);
				match(ESCAPECHAR);
				setState(321);
				match(DOT);
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ESCAPE) | (1L << SUM) | (1L << AVG) | (1L << MAX) | (1L << MIN) | (1L << WEEKDAY) | (1L << LW) | (1L << INSTANCEOF) | (1L << TYPEOF) | (1L << CAST) | (1L << UNTIL) | (1L << AT))) != 0) || _la==TICKED_STRING_LITERAL || _la==IDENT) {
					{
					setState(322);
					((EventPropertyIdentContext)_localctx).ipi2 = keywordAllowedIdent();
					}
				}

				}
				}
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeWindowContext extends ParserRuleContext {
		public NumberconstantContext c;
		public Token u;
		public TerminalNode WITHIN() { return getToken(PDLParser.WITHIN, 0); }
		public NumberconstantContext numberconstant() {
			return getRuleContext(NumberconstantContext.class,0);
		}
		public TerminalNode HOUR_SHORT() { return getToken(PDLParser.HOUR_SHORT, 0); }
		public TerminalNode MINUTE_SHORT() { return getToken(PDLParser.MINUTE_SHORT, 0); }
		public TerminalNode SECOND_SHORT() { return getToken(PDLParser.SECOND_SHORT, 0); }
		public TerminalNode MILLSECONDS_SHORT() { return getToken(PDLParser.MILLSECONDS_SHORT, 0); }
		public TimeWindowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeWindow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterTimeWindow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitTimeWindow(this);
		}
	}

	public final TimeWindowContext timeWindow() throws RecognitionException {
		TimeWindowContext _localctx = new TimeWindowContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_timeWindow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(WITHIN);
			setState(331);
			((TimeWindowContext)_localctx).c = numberconstant();
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HOUR_SHORT:
				{
				setState(332);
				((TimeWindowContext)_localctx).u = match(HOUR_SHORT);
				}
				break;
			case MINUTE_SHORT:
				{
				setState(333);
				((TimeWindowContext)_localctx).u = match(MINUTE_SHORT);
				}
				break;
			case SECOND_SHORT:
				{
				setState(334);
				((TimeWindowContext)_localctx).u = match(SECOND_SHORT);
				}
				break;
			case MILLSECONDS_SHORT:
				{
				setState(335);
				((TimeWindowContext)_localctx).u = match(MILLSECONDS_SHORT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public Token t;
		public Token nu;
		public NumberconstantContext numberconstant() {
			return getRuleContext(NumberconstantContext.class,0);
		}
		public StringconstantContext stringconstant() {
			return getRuleContext(StringconstantContext.class,0);
		}
		public TerminalNode BOOLEAN_TRUE() { return getToken(PDLParser.BOOLEAN_TRUE, 0); }
		public TerminalNode BOOLEAN_FALSE() { return getToken(PDLParser.BOOLEAN_FALSE, 0); }
		public TerminalNode VALUE_NULL() { return getToken(PDLParser.VALUE_NULL, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_constant);
		try {
			setState(343);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case INTEGER_LITERAL:
			case FLOATING_POINT_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				numberconstant();
				}
				break;
			case QUOTED_STRING_LITERAL:
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				stringconstant();
				}
				break;
			case BOOLEAN_TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(340);
				((ConstantContext)_localctx).t = match(BOOLEAN_TRUE);
				}
				break;
			case BOOLEAN_FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(341);
				match(BOOLEAN_FALSE);
				}
				break;
			case VALUE_NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(342);
				((ConstantContext)_localctx).nu = match(VALUE_NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberconstantContext extends ParserRuleContext {
		public Token m;
		public Token p;
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PDLParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(PDLParser.PLUS, 0); }
		public NumberconstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberconstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterNumberconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitNumberconstant(this);
		}
	}

	public final NumberconstantContext numberconstant() throws RecognitionException {
		NumberconstantContext _localctx = new NumberconstantContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_numberconstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				{
				setState(345);
				((NumberconstantContext)_localctx).m = match(MINUS);
				}
				break;
			case PLUS:
				{
				setState(346);
				((NumberconstantContext)_localctx).p = match(PLUS);
				}
				break;
			case INTEGER_LITERAL:
			case FLOATING_POINT_LITERAL:
				break;
			default:
				break;
			}
			setState(349);
			number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringconstantContext extends ParserRuleContext {
		public Token sl;
		public Token qsl;
		public TerminalNode STRING_LITERAL() { return getToken(PDLParser.STRING_LITERAL, 0); }
		public TerminalNode QUOTED_STRING_LITERAL() { return getToken(PDLParser.QUOTED_STRING_LITERAL, 0); }
		public StringconstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringconstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterStringconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitStringconstant(this);
		}
	}

	public final StringconstantContext stringconstant() throws RecognitionException {
		StringconstantContext _localctx = new StringconstantContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_stringconstant);
		try {
			setState(353);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				((StringconstantContext)_localctx).sl = match(STRING_LITERAL);
				}
				break;
			case QUOTED_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				((StringconstantContext)_localctx).qsl = match(QUOTED_STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordAllowedIdentContext extends ParserRuleContext {
		public Token i1;
		public Token i2;
		public TerminalNode IDENT() { return getToken(PDLParser.IDENT, 0); }
		public TerminalNode TICKED_STRING_LITERAL() { return getToken(PDLParser.TICKED_STRING_LITERAL, 0); }
		public TerminalNode AT() { return getToken(PDLParser.AT, 0); }
		public TerminalNode ESCAPE() { return getToken(PDLParser.ESCAPE, 0); }
		public TerminalNode SUM() { return getToken(PDLParser.SUM, 0); }
		public TerminalNode AVG() { return getToken(PDLParser.AVG, 0); }
		public TerminalNode MAX() { return getToken(PDLParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(PDLParser.MIN, 0); }
		public TerminalNode UNTIL() { return getToken(PDLParser.UNTIL, 0); }
		public TerminalNode WEEKDAY() { return getToken(PDLParser.WEEKDAY, 0); }
		public TerminalNode LW() { return getToken(PDLParser.LW, 0); }
		public TerminalNode INSTANCEOF() { return getToken(PDLParser.INSTANCEOF, 0); }
		public TerminalNode TYPEOF() { return getToken(PDLParser.TYPEOF, 0); }
		public TerminalNode CAST() { return getToken(PDLParser.CAST, 0); }
		public KeywordAllowedIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordAllowedIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterKeywordAllowedIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitKeywordAllowedIdent(this);
		}
	}

	public final KeywordAllowedIdentContext keywordAllowedIdent() throws RecognitionException {
		KeywordAllowedIdentContext _localctx = new KeywordAllowedIdentContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_keywordAllowedIdent);
		try {
			setState(369);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				((KeywordAllowedIdentContext)_localctx).i1 = match(IDENT);
				}
				break;
			case TICKED_STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				((KeywordAllowedIdentContext)_localctx).i2 = match(TICKED_STRING_LITERAL);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				match(AT);
				}
				break;
			case ESCAPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(358);
				match(ESCAPE);
				}
				break;
			case SUM:
				enterOuterAlt(_localctx, 5);
				{
				setState(359);
				match(SUM);
				}
				break;
			case AVG:
				enterOuterAlt(_localctx, 6);
				{
				setState(360);
				match(AVG);
				}
				break;
			case MAX:
				enterOuterAlt(_localctx, 7);
				{
				setState(361);
				match(MAX);
				}
				break;
			case MIN:
				enterOuterAlt(_localctx, 8);
				{
				setState(362);
				match(MIN);
				}
				break;
			case UNTIL:
				enterOuterAlt(_localctx, 9);
				{
				setState(363);
				match(UNTIL);
				}
				break;
			case WEEKDAY:
				enterOuterAlt(_localctx, 10);
				{
				setState(364);
				match(WEEKDAY);
				}
				break;
			case LW:
				enterOuterAlt(_localctx, 11);
				{
				setState(365);
				match(LW);
				}
				break;
			case INSTANCEOF:
				enterOuterAlt(_localctx, 12);
				{
				setState(366);
				match(INSTANCEOF);
				}
				break;
			case TYPEOF:
				enterOuterAlt(_localctx, 13);
				{
				setState(367);
				match(TYPEOF);
				}
				break;
			case CAST:
				enterOuterAlt(_localctx, 14);
				{
				setState(368);
				match(CAST);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(PDLParser.INTEGER_LITERAL, 0); }
		public TerminalNode FLOATING_POINT_LITERAL() { return getToken(PDLParser.FLOATING_POINT_LITERAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PDLListener ) ((PDLListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_la = _input.LA(1);
			if ( !(_la==INTEGER_LITERAL || _la==FLOATING_POINT_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3r\u0178\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\5\2`\n\2\3\2\3\2\7\2d\n\2\f\2\16\2g\13\2\3"+
		"\2\5\2j\n\2\3\2\5\2m\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3w\n\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\5\t\u008e\n\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\5\17\u009e\n\17\3\17\5\17\u00a1\n\17\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\5\21\u00a9\n\21\3\22\3\22\3\22\3\22\5\22\u00af\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00b7\n\22\3\22\5\22\u00ba\n\22\5\22\u00bc"+
		"\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00c4\n\23\3\23\5\23\u00c7\n"+
		"\23\3\24\3\24\5\24\u00cb\n\24\3\24\5\24\u00ce\n\24\3\25\3\25\5\25\u00d2"+
		"\n\25\3\25\5\25\u00d5\n\25\3\26\3\26\3\27\3\27\3\30\3\30\5\30\u00dd\n"+
		"\30\3\30\3\30\3\31\3\31\5\31\u00e3\n\31\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\33\7\33\u00ec\n\33\f\33\16\33\u00ef\13\33\3\34\3\34\3\34\7\34\u00f4"+
		"\n\34\f\34\16\34\u00f7\13\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5"+
		"\35\u0101\n\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!"+
		"\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\5"+
		"&\u0125\n&\3\'\3\'\3\'\7\'\u012a\n\'\f\'\16\'\u012d\13\'\3(\3(\3(\3(\3"+
		"(\5(\u0134\n(\3(\3(\3(\5(\u0139\n(\3(\3(\5(\u013d\n(\3(\5(\u0140\n(\3"+
		")\3)\3)\3)\5)\u0146\n)\7)\u0148\n)\f)\16)\u014b\13)\3*\3*\3*\3*\3*\3*"+
		"\5*\u0153\n*\3+\3+\3+\3+\3+\5+\u015a\n+\3,\3,\5,\u015e\n,\3,\3,\3-\3-"+
		"\5-\u0164\n-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u0174\n.\3/"+
		"\3/\3/\2\2\60\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\\2\4\4\2mmrr\3\2pq\2\u0190\2_\3\2\2\2\4p\3\2\2"+
		"\2\6x\3\2\2\2\bz\3\2\2\2\n|\3\2\2\2\f~\3\2\2\2\16\u0083\3\2\2\2\20\u008d"+
		"\3\2\2\2\22\u0091\3\2\2\2\24\u0093\3\2\2\2\26\u0095\3\2\2\2\30\u0097\3"+
		"\2\2\2\32\u0099\3\2\2\2\34\u009b\3\2\2\2\36\u00a2\3\2\2\2 \u00a8\3\2\2"+
		"\2\"\u00bb\3\2\2\2$\u00bd\3\2\2\2&\u00c8\3\2\2\2(\u00cf\3\2\2\2*\u00d6"+
		"\3\2\2\2,\u00d8\3\2\2\2.\u00da\3\2\2\2\60\u00e0\3\2\2\2\62\u00e6\3\2\2"+
		"\2\64\u00e8\3\2\2\2\66\u00f0\3\2\2\28\u0100\3\2\2\2:\u0102\3\2\2\2<\u0106"+
		"\3\2\2\2>\u010a\3\2\2\2@\u010e\3\2\2\2B\u0112\3\2\2\2D\u0116\3\2\2\2F"+
		"\u011a\3\2\2\2H\u011e\3\2\2\2J\u0124\3\2\2\2L\u0126\3\2\2\2N\u012e\3\2"+
		"\2\2P\u0141\3\2\2\2R\u014c\3\2\2\2T\u0159\3\2\2\2V\u015d\3\2\2\2X\u0163"+
		"\3\2\2\2Z\u0173\3\2\2\2\\\u0175\3\2\2\2^`\5\4\3\2_^\3\2\2\2_`\3\2\2\2"+
		"`a\3\2\2\2ae\5\34\17\2bd\5\20\t\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2"+
		"\2\2fi\3\2\2\2ge\3\2\2\2hj\5\60\31\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2km\5"+
		"R*\2lk\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7\2\2\3o\3\3\2\2\2pv\7T\2\2qw\5\6"+
		"\4\2rw\5\b\5\2sw\5\n\6\2tw\5\f\7\2uw\5\16\b\2vq\3\2\2\2vr\3\2\2\2vs\3"+
		"\2\2\2vt\3\2\2\2vu\3\2\2\2w\5\3\2\2\2xy\7\3\2\2y\7\3\2\2\2z{\7\4\2\2{"+
		"\t\3\2\2\2|}\7\5\2\2}\13\3\2\2\2~\177\7\6\2\2\177\u0080\7G\2\2\u0080\u0081"+
		"\5X-\2\u0081\u0082\7H\2\2\u0082\r\3\2\2\2\u0083\u0084\7\7\2\2\u0084\u0085"+
		"\7G\2\2\u0085\u0086\5X-\2\u0086\u0087\7H\2\2\u0087\17\3\2\2\2\u0088\u008e"+
		"\5\22\n\2\u0089\u008e\5\24\13\2\u008a\u008e\5\26\f\2\u008b\u008e\5\30"+
		"\r\2\u008c\u008e\5\32\16\2\u008d\u0088\3\2\2\2\u008d\u0089\3\2\2\2\u008d"+
		"\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0090\5\34\17\2\u0090\21\3\2\2\2\u0091\u0092\7=\2\2\u0092\23"+
		"\3\2\2\2\u0093\u0094\7>\2\2\u0094\25\3\2\2\2\u0095\u0096\7?\2\2\u0096"+
		"\27\3\2\2\2\u0097\u0098\7@\2\2\u0098\31\3\2\2\2\u0099\u009a\7A\2\2\u009a"+
		"\33\3\2\2\2\u009b\u009d\5\36\20\2\u009c\u009e\5 \21\2\u009d\u009c\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u00a1\5.\30\2\u00a0"+
		"\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\35\3\2\2\2\u00a2\u00a3\t\2\2"+
		"\2\u00a3\37\3\2\2\2\u00a4\u00a9\5\"\22\2\u00a5\u00a9\5$\23\2\u00a6\u00a9"+
		"\5&\24\2\u00a7\u00a9\5(\25\2\u00a8\u00a4\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9!\3\2\2\2\u00aa\u00ab\7I\2\2\u00ab"+
		"\u00ac\5V,\2\u00ac\u00ae\7J\2\2\u00ad\u00af\5*\26\2\u00ae\u00ad\3\2\2"+
		"\2\u00ae\u00af\3\2\2\2\u00af\u00bc\3\2\2\2\u00b0\u00b1\7I\2\2\u00b1\u00b2"+
		"\5V,\2\u00b2\u00b3\7L\2\2\u00b3\u00b4\5V,\2\u00b4\u00b6\7J\2\2\u00b5\u00b7"+
		"\5*\26\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8"+
		"\u00ba\5,\27\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2"+
		"\2\2\u00bb\u00aa\3\2\2\2\u00bb\u00b0\3\2\2\2\u00bc#\3\2\2\2\u00bd\u00be"+
		"\7I\2\2\u00be\u00bf\5V,\2\u00bf\u00c0\7L\2\2\u00c0\u00c1\7Q\2\2\u00c1"+
		"\u00c3\7J\2\2\u00c2\u00c4\5*\26\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c7\5,\27\2\u00c6\u00c5\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7%\3\2\2\2\u00c8\u00ca\7Q\2\2\u00c9\u00cb\5*\26\2\u00ca"+
		"\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ce\5,"+
		"\27\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\'\3\2\2\2\u00cf\u00d1"+
		"\7S\2\2\u00d0\u00d2\5*\26\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d4\3\2\2\2\u00d3\u00d5\5,\27\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5)\3\2\2\2\u00d6\u00d7\7D\2\2\u00d7+\3\2\2\2\u00d8\u00d9\7[\2"+
		"\2\u00d9-\3\2\2\2\u00da\u00dc\7E\2\2\u00db\u00dd\5\62\32\2\u00dc\u00db"+
		"\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7F\2\2\u00df"+
		"/\3\2\2\2\u00e0\u00e2\7G\2\2\u00e1\u00e3\5\62\32\2\u00e2\u00e1\3\2\2\2"+
		"\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7H\2\2\u00e5\61\3"+
		"\2\2\2\u00e6\u00e7\5\64\33\2\u00e7\63\3\2\2\2\u00e8\u00ed\5\66\34\2\u00e9"+
		"\u00ea\7\r\2\2\u00ea\u00ec\5\66\34\2\u00eb\u00e9\3\2\2\2\u00ec\u00ef\3"+
		"\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\65\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f5\58\35\2\u00f1\u00f2\7\16\2\2\u00f2\u00f4\5"+
		"8\35\2\u00f3\u00f1\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\67\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u0101\5:\36"+
		"\2\u00f9\u0101\5<\37\2\u00fa\u0101\5> \2\u00fb\u0101\5@!\2\u00fc\u0101"+
		"\5B\"\2\u00fd\u0101\5D#\2\u00fe\u0101\5F$\2\u00ff\u0101\5H%\2\u0100\u00f8"+
		"\3\2\2\2\u0100\u00f9\3\2\2\2\u0100\u00fa\3\2\2\2\u0100\u00fb\3\2\2\2\u0100"+
		"\u00fc\3\2\2\2\u0100\u00fd\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2"+
		"\2\2\u01019\3\2\2\2\u0102\u0103\5J&\2\u0103\u0104\7C\2\2\u0104\u0105\5"+
		"J&\2\u0105;\3\2\2\2\u0106\u0107\5J&\2\u0107\u0108\7O\2\2\u0108\u0109\5"+
		"J&\2\u0109=\3\2\2\2\u010a\u010b\5J&\2\u010b\u010c\7X\2\2\u010c\u010d\5"+
		"J&\2\u010d?\3\2\2\2\u010e\u010f\5J&\2\u010f\u0110\7W\2\2\u0110\u0111\5"+
		"J&\2\u0111A\3\2\2\2\u0112\u0113\5J&\2\u0113\u0114\7V\2\2\u0114\u0115\5"+
		"J&\2\u0115C\3\2\2\2\u0116\u0117\5J&\2\u0117\u0118\7U\2\2\u0118\u0119\5"+
		"J&\2\u0119E\3\2\2\2\u011a\u011b\5J&\2\u011b\u011c\7Y\2\2\u011c\u011d\5"+
		"J&\2\u011dG\3\2\2\2\u011e\u011f\5J&\2\u011f\u0120\7Z\2\2\u0120\u0121\5"+
		"J&\2\u0121I\3\2\2\2\u0122\u0125\5L\'\2\u0123\u0125\5T+\2\u0124\u0122\3"+
		"\2\2\2\u0124\u0123\3\2\2\2\u0125K\3\2\2\2\u0126\u012b\5N(\2\u0127\u0128"+
		"\7b\2\2\u0128\u012a\5N(\2\u0129\u0127\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012cM\3\2\2\2\u012d\u012b\3\2\2\2"+
		"\u012e\u013f\5P)\2\u012f\u0130\7G\2\2\u0130\u0131\5\\/\2\u0131\u0133\7"+
		"H\2\2\u0132\u0134\7D\2\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0140\3\2\2\2\u0135\u0138\7E\2\2\u0136\u0139\7o\2\2\u0137\u0139\7n\2"+
		"\2\u0138\u0136\3\2\2\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c"+
		"\7F\2\2\u013b\u013d\7D\2\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u0140\3\2\2\2\u013e\u0140\7D\2\2\u013f\u012f\3\2\2\2\u013f\u0135\3\2"+
		"\2\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140O\3\2\2\2\u0141\u0149"+
		"\5Z.\2\u0142\u0143\7f\2\2\u0143\u0145\7b\2\2\u0144\u0146\5Z.\2\u0145\u0144"+
		"\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u0142\3\2\2\2\u0148"+
		"\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014aQ\3\2\2\2"+
		"\u014b\u0149\3\2\2\2\u014c\u014d\78\2\2\u014d\u0152\5V,\2\u014e\u0153"+
		"\79\2\2\u014f\u0153\7:\2\2\u0150\u0153\7;\2\2\u0151\u0153\7<\2\2\u0152"+
		"\u014e\3\2\2\2\u0152\u014f\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0151\3\2"+
		"\2\2\u0153S\3\2\2\2\u0154\u015a\5V,\2\u0155\u015a\5X-\2\u0156\u015a\7"+
		"\65\2\2\u0157\u015a\7\66\2\2\u0158\u015a\7\67\2\2\u0159\u0154\3\2\2\2"+
		"\u0159\u0155\3\2\2\2\u0159\u0156\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u0158"+
		"\3\2\2\2\u015aU\3\2\2\2\u015b\u015e\7R\2\2\u015c\u015e\7Q\2\2\u015d\u015b"+
		"\3\2\2\2\u015d\u015c\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\3\2\2\2\u015f"+
		"\u0160\5\\/\2\u0160W\3\2\2\2\u0161\u0164\7o\2\2\u0162\u0164\7n\2\2\u0163"+
		"\u0161\3\2\2\2\u0163\u0162\3\2\2\2\u0164Y\3\2\2\2\u0165\u0174\7r\2\2\u0166"+
		"\u0174\7m\2\2\u0167\u0174\7\37\2\2\u0168\u0174\7\f\2\2\u0169\u0174\7\22"+
		"\2\2\u016a\u0174\7\23\2\2\u016b\u0174\7\24\2\2\u016c\u0174\7\25\2\2\u016d"+
		"\u0174\7\36\2\2\u016e\u0174\7\30\2\2\u016f\u0174\7\31\2\2\u0170\u0174"+
		"\7\32\2\2\u0171\u0174\7\33\2\2\u0172\u0174\7\34\2\2\u0173\u0165\3\2\2"+
		"\2\u0173\u0166\3\2\2\2\u0173\u0167\3\2\2\2\u0173\u0168\3\2\2\2\u0173\u0169"+
		"\3\2\2\2\u0173\u016a\3\2\2\2\u0173\u016b\3\2\2\2\u0173\u016c\3\2\2\2\u0173"+
		"\u016d\3\2\2\2\u0173\u016e\3\2\2\2\u0173\u016f\3\2\2\2\u0173\u0170\3\2"+
		"\2\2\u0173\u0171\3\2\2\2\u0173\u0172\3\2\2\2\u0174[\3\2\2\2\u0175\u0176"+
		"\t\3\2\2\u0176]\3\2\2\2\'_eilv\u008d\u009d\u00a0\u00a8\u00ae\u00b6\u00b9"+
		"\u00bb\u00c3\u00c6\u00ca\u00cd\u00d1\u00d4\u00dc\u00e2\u00ed\u00f5\u0100"+
		"\u0124\u012b\u0133\u0138\u013c\u013f\u0145\u0149\u0152\u0159\u015d\u0163"+
		"\u0173";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}