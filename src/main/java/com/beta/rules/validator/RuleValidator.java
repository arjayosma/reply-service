package com.beta.rules.validator;

import java.util.ArrayList;
import java.util.List;

public class RuleValidator {
    private static List<Validation> ruleValidation = new ArrayList<>();

    static {
	ruleValidation.add(new RuleLength());
    }

    public static void validate(String rule) {
	for (Validation validation : ruleValidation) {
	    validation.validate(rule);
	}
    }
}

class RuleLength implements Validation {
    @Override
    public void validate(String data) {
	if (data.length() != 2) {
	    throw new IllegalArgumentException("Invalid rule - Rule length must be 2");
	}
    }
}