package com.ia.gpj.processor;

public interface Processor {
    /**
     * Starts processor service and consumes data until it is stopped from outside.
     */
    void start() throws Exception;
}
