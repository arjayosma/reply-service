package com.beta.replyservice;

public class ReplyMessage implements Message {
    private final String message;

    public ReplyMessage(String message) {
	this.message = message;
    }

    public String getMessage() {
	return message;
    }
}