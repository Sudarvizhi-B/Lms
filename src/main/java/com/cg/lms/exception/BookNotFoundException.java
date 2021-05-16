package com.cg.lms.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookNotFoundException(String message) {
		super(message);
	}

	public BookNotFoundException(Throwable cause) {
		super(cause);
	}
}