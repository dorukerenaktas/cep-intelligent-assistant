package com.ia.pdl.matcher;

import com.ia.pdl.model.Event;
import org.apache.flink.cep.pattern.conditions.IterativeCondition;

import java.io.Serializable;

/**
 * Matches a certain event type
 */
public class EventTypeContextMatcher implements ContextMatcher, Serializable {

	private static final long serialVersionUID = 3255672669611654982L;
	private String eventType;

	private EventTypeContextMatcher(String text) {
		this.eventType = text;
	}

	public static EventTypeContextMatcher matching(String text) {
		return new EventTypeContextMatcher(text);
	}

	public static EventTypeContextMatcher ignoring() {
		return new EventTypeContextMatcher(null);
	}

	@Override
	public boolean matches(Event event, IterativeCondition.Context<Event> context) {
		// always match when there is no strict type set
		if (this.eventType == null) {
			return true;
		}

		String eventType = event.getEventType();
		if (eventType != null) {
			return eventType.equals(this.eventType);
		}
		// when there is no type provided, assume it never matches.
		return false;
	}
}
