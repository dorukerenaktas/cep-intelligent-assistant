grammar PDL ;

@header {
package com.ia.pdl.language ;
}

/*
    Pattern Sequence.
    https://ci.apache.org/projects/flink/flink-docs-stable/dev/libs/cep.html#the-pattern-api
*/
patternSequence: skipStrategy? pattern (patternCombination)* stopCondition? timeWindow? EOF ;

/*
    After Match Skip Strategy.
        noSkip, Every possible match will be emitted.
        skipToNext, Discards every partial match that started with the same event, emitted match was started.
        skipPastLast, Discards every partial match that started after the match started but before it ended.
        skipToFirst, Discards every partial match that started after the match started but before the first event of PatternName occurred.
        skipToLast, Discards every partial match that started after the match started but before the last event of PatternName occurred.

    https://ci.apache.org/projects/flink/flink-docs-stable/dev/libs/cep.html#after-match-skip-strategy
*/
skipStrategy: MOD (noSkip | skipToNext | skipPastLast | skipToFirst | skipToLast) ;
noSkip: SKIP_NO_SKIP ;
skipToNext: SKIP_TO_NEXT ;
skipPastLast: SKIP_SKIP_PAST_LAST ;
skipToFirst: SKIP_SKIP_TO_FIRST LBRACK stringconstant RBRACK ;
skipToLast: SKIP_SKIP_TO_LAST LBRACK stringconstant RBRACK ;

/*
    Pattern Combination.
        Strict Contiguity:
            Expects all matching events to appear strictly one after the other, without any non-matching events in-between.

        Relaxed Contiguity:
            Ignores non-matching events appearing in-between the matching ones.

        Non-Deterministic Relaxed Contiguity:
            Further relaxes contiguity, allowing additional matches that ignore some matching events.


        next, for strict,
        followedBy, for relaxed, and
        followedByAny, for non-deterministic relaxed contiguity. or
        notNext, if you do not want an event type to directly follow another
        notFollowedBy, if you do not want an event type to be anywhere between two other event types.

    https://ci.apache.org/projects/flink/flink-docs-stable/dev/libs/cep.html#combining-patterns
*/
patternCombination: (next | followedBy | followedByAny | notNext | notFollowedBy) pattern ;
next: NEXT ;
followedBy: FOLLOWED_BY ;
followedByAny: FOLLOWED_BY_ANY ;
notNext: NOT_NEXT ;
notFollowedBy: NOT_FOLLOWED_BY ;

pattern: patternName quantifier? condition?;

patternName: IDENT | TICKED_STRING_LITERAL ;

/*

*/
quantifier: times | timesOrMore | oneOrMore | zeroOrMore ;
times: (LCURLY numberconstant RCURLY optional?) | (LCURLY numberconstant COMMA numberconstant RCURLY optional? greedy?);
timesOrMore: LCURLY numberconstant COMMA PLUS RCURLY optional? greedy? ;
oneOrMore: PLUS optional? greedy? ;
zeroOrMore: STAR optional? greedy? ;
optional: QUESTION ;
greedy: BXOR ;

condition: LPAREN expression? RPAREN ;
stopCondition: LBRACK expression? RBRACK ;

expression: orExpression ;
orExpression: andExpression (OR_EXPR andExpression)* ;
andExpression: operation (AND_EXPR operation)* ;

operation: equalsOperation | notEqualsOperation | lowerThanOperation | lowerEqualsOperation | greaterThanOperation | greaterEqualsOperation | containsOperation | notContainsOperation ;

equalsOperation: unaryExpression EQUALS unaryExpression ;
notEqualsOperation: unaryExpression NOT_EQUAL unaryExpression ;
lowerThanOperation: unaryExpression LT unaryExpression ;
lowerEqualsOperation: unaryExpression LE unaryExpression ;
greaterThanOperation: unaryExpression GT unaryExpression ;
greaterEqualsOperation: unaryExpression GE unaryExpression ;
containsOperation: unaryExpression CONTAINS unaryExpression ;
notContainsOperation: unaryExpression NOT_CONTAINS unaryExpression ;

unaryExpression: eventProperty | constant ;
eventProperty: eventPropertyAtomic (DOT eventPropertyAtomic)* ;

eventPropertyAtomic: eventPropertyIdent (
			lb=LBRACK ni=number RBRACK (q=QUESTION)? | lp=LPAREN (s=STRING_LITERAL | s=QUOTED_STRING_LITERAL) RPAREN (q=QUESTION)? | q1=QUESTION
			)? ;

eventPropertyIdent: ipi=keywordAllowedIdent (ESCAPECHAR DOT ipi2=keywordAllowedIdent?)* ;


timeWindow: WITHIN c=numberconstant (u=HOUR_SHORT | u=MINUTE_SHORT | u=SECOND_SHORT | u=MILLSECONDS_SHORT) ;

constant: numberconstant | stringconstant | t=BOOLEAN_TRUE | BOOLEAN_FALSE | nu=VALUE_NULL ;
numberconstant: (m=MINUS | p=PLUS)? number ;
stringconstant: sl=STRING_LITERAL | qsl=QUOTED_STRING_LITERAL ;
keywordAllowedIdent: i1=IDENT | i2=TICKED_STRING_LITERAL | AT | ESCAPE | SUM | AVG | MAX | MIN | UNTIL | WEEKDAY | LW | INSTANCEOF | TYPEOF | CAST ;
number: INTEGER_LITERAL | FLOATING_POINT_LITERAL ;

/*
    Lexer rules.
*/

// Tokens
SKIP_NO_SKIP: 'no_skip' ;
SKIP_TO_NEXT: 'skip_to_next' ;
SKIP_SKIP_PAST_LAST: 'skip_past_last' ;
SKIP_SKIP_TO_FIRST: 'skip_to_first' ;
SKIP_SKIP_TO_LAST: 'skip_to_last' ;
IN_SET:'in' ;
BETWEEN:'between' ;
LIKE:'like' ;
REGEXP:'regexp' ;
ESCAPE:'escape' ;
OR_EXPR:'or' ;
AND_EXPR:'and' ;
NOT_EXPR:'not' ;
WHERE:'where' ;
AS:'as' ;
SUM:'sum' ;
AVG:'avg' ;
MAX:'max' ;
MIN:'min' ;
ON:'on' ;
IS:'is' ;
WEEKDAY:'weekday' ;
LW:'lastweekday' ;
INSTANCEOF:'instanceof' ;
TYPEOF:'typeof' ;
CAST:'cast' ;
CURRENT_TIMESTAMP:'current_timestamp' ;
UNTIL:'until' ;
AT:'at' ;
TIMEPERIOD_YEAR:'year' ;
TIMEPERIOD_YEARS:'years' ;
TIMEPERIOD_MONTH:'month' ;
TIMEPERIOD_MONTHS:'months' ;
TIMEPERIOD_WEEK:'week' ;
TIMEPERIOD_WEEKS:'weeks' ;
TIMEPERIOD_DAY:'day' ;
TIMEPERIOD_DAYS:'days' ;
TIMEPERIOD_HOUR:'hour' ;
TIMEPERIOD_HOURS:'hours' ;
TIMEPERIOD_MINUTE:'minute' ;
TIMEPERIOD_MINUTES:'minutes' ;
TIMEPERIOD_SEC:'sec' ;
TIMEPERIOD_SECOND:'second' ;
TIMEPERIOD_SECONDS:'seconds' ;
TIMEPERIOD_MILLISEC:'msec' ;
TIMEPERIOD_MILLISECOND:'millisecond' ;
TIMEPERIOD_MILLISECONDS:'milliseconds' ;
TIMEPERIOD_MICROSEC:'usec' ;
TIMEPERIOD_MICROSECOND:'microsecond' ;
TIMEPERIOD_MICROSECONDS:'microseconds' ;
BOOLEAN_TRUE:'true' ;
BOOLEAN_FALSE:'false' ;
VALUE_NULL:'null' ;
WITHIN: 'within' ;
HOUR_SHORT: 'h' ;
MINUTE_SHORT: 'm' ;
SECOND_SHORT: 's' ;
MILLSECONDS_SHORT: 'ms' ;

// Operators
NEXT: '->>' ;
FOLLOWED_BY: '->' ;
FOLLOWED_BY_ANY: '--' ;
NOT_NEXT: '!->>' ;
NOT_FOLLOWED_BY: '!->' ;
GOES: '=>' ;
EQUALS: '=' ;
QUESTION: '?' ;
LPAREN: '(' ;
RPAREN: ')' ;
LBRACK: '[' ;
RBRACK: ']' ;
LCURLY: '{' ;
RCURLY: '}' ;
COLON: ':' ;
COMMA: ',' ;
LNOT: '!' ;
BNOT: '~' ;
NOT_EQUAL: '!=' ;
DIV: '/' ;
PLUS: '+' ;
MINUS: '-' ;
STAR: '*' ;
MOD: '%' ;
GE: '>=' ;
GT: '>' ;
LE: '<=' ;
LT: '<' ;
CONTAINS: '><' ;
NOT_CONTAINS: '>!<' ;
BXOR: '^' ;
BOR: '|' ;
LOR: '||' ;
BAND: '&' ;
BAND_ASSIGN: '&=' ;
LAND: '&&' ;
SEMI: ' ;' ;
DOT: '.' ;
NUM_LONG: '\u18FF' ;  // assign bogus unicode characters so the token exists
NUM_DOUBLE: '\u18FE' ;
NUM_FLOAT: '\u18FD' ;
ESCAPECHAR: '\\' ;
ESCAPEBACKTICK: '`' ;
ATCHAR: '@' ;
HASHCHAR: '#' ;

// Whitespace -- ignored
WS: (' ' | '\t' | '\f' | ('\r' | '\n'))+ -> channel(HIDDEN) ;

// Single-line comments
SL_COMMENT: '//' (~('\n'|'\r'))* ('\n'|'\r'('\n')?)? -> channel(HIDDEN) ;

// multiple-line comments
ML_COMMENT: '/*' (.)*? '*/' -> channel(HIDDEN) ;

TICKED_STRING_LITERAL: '`' ( EscapeSequence | ~('`'|'\\') )* '`' ;
QUOTED_STRING_LITERAL: '\'' ( EscapeSequence | ~('\''|'\\') )* '\'' ;
STRING_LITERAL: '"' ( EscapeSequence | ~('\\'|'"') )* '"' ;
INTEGER_LITERAL: DecimalIntegerLiteral | HexIntegerLiteral | OctalIntegerLiteral | BinaryIntegerLiteral ;
FLOATING_POINT_LITERAL: DecimalFloatingPointLiteral | HexadecimalFloatingPointLiteral ;
IDENT: ('a'..'z'|'_'|'$') ('a'..'z'|'_'|'0'..'9'|'$')* ;

fragment EscapeSequence: '\\' (	'n' | 'r' | 't' | 'b' | 'f' | '"' | '\'' | '\\' | UnicodeEscape | OctalEscape | . ) ;
fragment OctalEscape: '\\' ('0'..'3') ('0'..'7') ('0'..'7') | '\\' ('0'..'7') ('0'..'7') | '\\' ('0'..'7') ;
fragment UnicodeEscape: '\\' 'u' HexDigit HexDigit HexDigit HexDigit ;
fragment DecimalIntegerLiteral: DecimalNumeral IntegerTypeSuffix? ;
fragment HexIntegerLiteral: HexNumeral IntegerTypeSuffix? ;
fragment OctalIntegerLiteral: OctalNumeral IntegerTypeSuffix? ;
fragment BinaryIntegerLiteral: BinaryNumeral IntegerTypeSuffix? ;
fragment IntegerTypeSuffix: [lL] ;
fragment DecimalNumeral: '0' | ('0')* NonZeroDigit (Digits? | Underscores Digits) ;
fragment Digits: Digit (DigitOrUnderscore* Digit)? ;
fragment Digit: '0' | NonZeroDigit ;
fragment NonZeroDigit: [1-9] ;
fragment DigitOrUnderscore: Digit | '_' ;
fragment Underscores: '_'+ ;
fragment HexNumeral: '0' [xX] HexDigits ;
fragment HexDigits: HexDigit (HexDigitOrUnderscore* HexDigit)? ;
fragment HexDigit: [0-9a-fA-F] ;
fragment HexDigitOrUnderscore: HexDigit | '_' ;
fragment OctalNumeral: '0' Underscores? OctalDigits ;
fragment OctalDigits: OctalDigit (OctalDigitOrUnderscore* OctalDigit)? ;
fragment OctalDigit: [0-7] ;
fragment OctalDigitOrUnderscore: OctalDigit | '_' ;
fragment BinaryNumeral: '0' [bB] BinaryDigits ;
fragment BinaryDigits: BinaryDigit (BinaryDigitOrUnderscore* BinaryDigit)? ;
fragment BinaryDigit: [01] ;
fragment BinaryDigitOrUnderscore: BinaryDigit | '_' ;
fragment DecimalFloatingPointLiteral: Digits '.' Digits? ExponentPart? FloatTypeSuffix? | '.' Digits ExponentPart? FloatTypeSuffix? | Digits ExponentPart FloatTypeSuffix? | Digits FloatTypeSuffix ;
fragment ExponentPart: ExponentIndicator SignedInteger ;
fragment ExponentIndicator: [eE] ;
fragment SignedInteger: Sign? Digits ;
fragment Sign: [+-] ;
fragment FloatTypeSuffix: [fFdD] ;
fragment HexadecimalFloatingPointLiteral: HexSignificand BinaryExponent FloatTypeSuffix? ;
fragment HexSignificand: HexNumeral '.'? | '0' [xX] HexDigits? '.' HexDigits ;
fragment BinaryExponent: BinaryExponentIndicator SignedInteger ;
fragment BinaryExponentIndicator: [pP] ;