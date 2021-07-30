package com.beta.replyservice;

public class ErrorMessage implements Message {
    private final String error;

    public ErrorMessage(String error) {
	this.error = error;
    }

    public String getError() {
	return error;
    }
}