package com.beta.rules;

import java.util.HashMap;
import java.util.Map;

import com.beta.rules.validator.MessageValidator;
import com.beta.rules.validator.RuleValidator;

public class RuleExecutor {
    private static Map<Character, Rule> ruleMapping = new HashMap<>();

    static {
	ruleMapping.put('1', new ReverseRule());
	ruleMapping.put('2', new HashRule());
    }

    public static String execute(String rule, String message) throws Exception {
	RuleValidator.validate(rule);
	MessageValidator.validate(message);
	String result = message;

	for (int i = 0; i < rule.length(); i++) {
	    char digit = rule.charAt(i);
	    Rule r = ruleMapping.get(digit);

	    if (r != null) {
		result = r.apply(result);
	    } else {
		throw new IllegalArgumentException("Invalid rule - Could not find rule '" + digit + "'");
	    }
	}

	return result;
    }
}
