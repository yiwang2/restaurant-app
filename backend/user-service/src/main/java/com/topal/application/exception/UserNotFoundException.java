package com.topal.application.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1803627348254029328L;

	public UserNotFoundException(Integer id) {
		super("Could not find user by id " + id);
	}
}
