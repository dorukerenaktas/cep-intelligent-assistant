package com.ia.pdl;

import com.ia.pdl.model.Event;
import org.apache.flink.cep.pattern.Pattern;

/**
 * Represents the quantifiers applicable to the pattern. Use
 * {@link Builder} to create an instances.
 */
class Quantifier {

    private Integer lowerBound;
    private Integer upperBound;

    private boolean times;
    private boolean timesOrMore;
    private boolean oneOrMore;
    private boolean zeroOrMore;

    private boolean greedy;
    private boolean optional;

    private Quantifier() {
    }

    public Pattern<Event, Event> apply(Pattern<Event, Event> pattern) {
        if (this.times) {
            if (lowerBound != null && upperBound == null) {
                pattern = pattern.times(lowerBound);
            } else if (lowerBound != null) {
                pattern = pattern.times(lowerBound, upperBound);
            }
        } else if (this.timesOrMore) {
            pattern = pattern.timesOrMore(this.lowerBound);
        } else if (this.oneOrMore) {
            pattern = pattern.oneOrMore();
        } else if (this.zeroOrMore) {
            pattern = pattern.oneOrMore().optional();
        }

        if (optional) {
            pattern = pattern.optional();
        }
        if (greedy) {
            pattern = pattern.greedy();
        }
        return pattern;
    }

    public static class Builder {

        private Quantifier quantifier = new Quantifier();

        public Builder greedy() {
            quantifier.greedy = true;
            return this;
        }

        public Quantifier build() {
            return quantifier;
        }

        public Builder times() {
            quantifier.times = true;
            return this;
        }

        public Builder timesOrMore() {
            quantifier.timesOrMore = true;
            return this;
        }

        public Builder oneOrMore() {
            quantifier.oneOrMore = true;
            return this;
        }

        public Builder zeroOrMore() {
            quantifier.zeroOrMore = true;
            return this;
        }

        public Builder bound(int bound) {
            if (quantifier.lowerBound == null) {
                quantifier.lowerBound = bound;
            } else {
                quantifier.upperBound = bound;
            }
            return this;
        }

        public Builder optional() {
            quantifier.optional = true;
            return this;
        }
    }

}
