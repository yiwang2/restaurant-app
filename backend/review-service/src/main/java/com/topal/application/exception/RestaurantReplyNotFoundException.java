package com.topal.application.exception;

public class RestaurantReplyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4537154809784680277L;

	public RestaurantReplyNotFoundException(String id) {
		super("Could not find reply by id " + id);
	}
}
