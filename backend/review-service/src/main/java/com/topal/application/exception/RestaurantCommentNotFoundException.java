package com.topal.application.exception;

public class RestaurantCommentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6069979576596569568L;

	public RestaurantCommentNotFoundException(String id) {
		super("Could not find comment by id " + id);
	}
}
