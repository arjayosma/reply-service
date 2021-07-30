package com.beta.rules;

public interface Rule {
    /**
     * Receives a string `message` that will be processed depending on the rule
     * assigned.
     * 
     * @param message
     *                    string to be processed
     * @return result of applying the rule
     */
    String apply(String message) throws Exception;
}
