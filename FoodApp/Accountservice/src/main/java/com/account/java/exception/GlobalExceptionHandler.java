package com.account.java.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleException(MethodArgumentNotValidException ex) {
		List<FieldError> errors = ex.getFieldErrors();
		ValidationErrorResponse vrs = new ValidationErrorResponse();
		vrs.setDateTime(LocalDateTime.now());
		vrs.setStatusCode(HttpStatus.BAD_REQUEST.value());
		vrs.setMessage("please input proper data");

		for (FieldError fieldError : errors) {
			vrs.getErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ResponseEntity<ValidationErrorResponse>(vrs, HttpStatus.BAD_REQUEST);
	}

}
