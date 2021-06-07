package com.cg.lms.exception;

public class FeedbackNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public FeedbackNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FeedbackNotFoundException(String message) {
		super(message);
	}

	public FeedbackNotFoundException(Throwable cause) {
		super(cause);
	}

}
