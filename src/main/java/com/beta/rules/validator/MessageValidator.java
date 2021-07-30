package com.beta.rules.validator;

import java.util.ArrayList;
import java.util.List;

public class MessageValidator {
    private static List<Validation> ruleValidation = new ArrayList<>();

    static {
	ruleValidation.add(new MessageMatch());
    }

    public static void validate(String rule) {
	for (Validation validation : ruleValidation) {
	    validation.validate(rule);
	}
    }
}

class MessageMatch implements Validation {
    @Override
    public void validate(String data) {
	if (!data.matches("[a-z0-9]*")) {
	    throw new IllegalArgumentException("Invalid message - Must match this format '[a-z0-9]*'");
	}
    }
}