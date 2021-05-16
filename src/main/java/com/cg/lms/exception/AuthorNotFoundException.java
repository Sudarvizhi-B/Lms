package com.cg.lms.exception;

public class AuthorNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AuthorNotFoundException(String message, Throwable cause) {
		super(message, cause);	
	}

	public AuthorNotFoundException(String message) {
		super(message);
	}

	public AuthorNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
	
}
