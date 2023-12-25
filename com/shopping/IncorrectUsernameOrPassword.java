package com.shopping;

public class IncorrectUsernameOrPassword extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IncorrectUsernameOrPassword(String message) {
		super(message);
	}
}
