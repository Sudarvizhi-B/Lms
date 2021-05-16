package com.cg.lms.exception;

public class ReaderNotFoundException extends RuntimeException {

	public ReaderNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReaderNotFoundException(String message) {
		super(message);	
	}

	public ReaderNotFoundException(Throwable cause) {
		super(cause);	
	}
	
}
