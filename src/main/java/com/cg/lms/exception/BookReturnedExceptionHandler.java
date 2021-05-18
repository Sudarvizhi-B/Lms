package com.cg.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.lms.controller.ErrorResponse;

@ControllerAdvice
public class BookReturnedExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(BookNotFoundException exception) {
		ErrorResponse be = new ErrorResponse();
		be.setStatus(HttpStatus.NOT_FOUND.value());
		be.setMessage(exception.getMessage());
		be.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(be, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {

		ErrorResponse be = new ErrorResponse();
		be.setStatus(HttpStatus.BAD_REQUEST.value());
		be.setMessage(exception.getMessage());
		be.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(be, HttpStatus.BAD_REQUEST);
	}
}

