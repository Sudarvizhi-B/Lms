package com.cg.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.lms.controller.ErrorResponse;

@ControllerAdvice
public class AuthorExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(AuthorNotFoundException exception) {

		ErrorResponse ae = new ErrorResponse();
		ae.setStatus(HttpStatus.NOT_FOUND.value());
		ae.setMessage(exception.getMessage());
		ae.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(ae, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {

		ErrorResponse ae = new ErrorResponse();
		ae.setStatus(HttpStatus.BAD_REQUEST.value());
		ae.setMessage(exception.getMessage());
		ae.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(ae, HttpStatus.BAD_REQUEST);
	}
}
