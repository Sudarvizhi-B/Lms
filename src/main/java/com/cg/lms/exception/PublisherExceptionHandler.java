package com.cg.lms.exception;

import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.lms.controller.ErrorResponse;

@ControllerAdvice
public class PublisherExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleAllExceptions(PublisherNotFoundException exception) {
		ErrorResponse pe = new ErrorResponse();
		
		pe.setStatus(HttpStatus.NOT_FOUND.value());
		pe.setMessage(exception.getMessage());
		pe.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(pe,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception exception) {
		ErrorResponse pe = new ErrorResponse();
		
		pe.setStatus(HttpStatus.BAD_REQUEST.value());
		pe.setMessage(exception.getMessage());
		pe.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(pe,HttpStatus.BAD_REQUEST);
	}
	
}

