package com.beta.rules;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class HashRule implements Rule {
    @Override
    public String apply(String message) throws NoSuchAlgorithmException {
	MessageDigest instance = MessageDigest.getInstance("MD5");
	instance.update(message.getBytes());
	byte[] digest = instance.digest();
	String hash = DatatypeConverter.printHexBinary(digest).toLowerCase();
	System.out.println(hash);
	return hash;
    }
}
