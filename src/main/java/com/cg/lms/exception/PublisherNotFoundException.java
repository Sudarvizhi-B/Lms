package com.cg.lms.exception;

public class PublisherNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PublisherNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PublisherNotFoundException(String message) {
		super(message);
	}

	public PublisherNotFoundException(Throwable cause) {
		super(cause);
	}

}
