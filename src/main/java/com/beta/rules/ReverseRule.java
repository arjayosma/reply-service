package com.beta.rules;

public class ReverseRule implements Rule {
    @Override
    public String apply(String message) {
	StringBuilder m = new StringBuilder(message);
	return m.reverse().toString();
    }
}
