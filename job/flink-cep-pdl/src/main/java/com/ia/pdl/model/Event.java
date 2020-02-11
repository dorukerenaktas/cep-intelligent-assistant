package com.ia.pdl.model;

import java.io.Serializable;
import java.util.Optional;

/**
 * Describes an com.ia.event which occurs in the pattern stream.
 *
 * The com.ia.event has a set of associated attributes.
 */
public interface Event extends Serializable {

    /**
     * Returns an attribute of the com.ia.event.
     * @param attribute the name of the desired attribute.
     * @return The attribute or {@link Optional#empty()}} if not available
     */
    Optional<Object> getAttribute(String attribute);


    /**
     * Returns the type of the com.ia.event.
     * @return The type of the com.ia.event
     */
    String getEventType();
}
