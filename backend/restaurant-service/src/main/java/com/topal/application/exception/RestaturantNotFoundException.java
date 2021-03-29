package com.topal.application.exception;

public class RestaturantNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -194468520751216575L;

	public RestaturantNotFoundException(Integer id) {
		super("Could not find restaturant by id " + id);
	}
}
