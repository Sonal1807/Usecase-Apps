
package com.consumerbank.java.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerConfig {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleException(MethodArgumentNotValidException ex) {
		List<FieldError> errors = ex.getFieldErrors();
		ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
		for (FieldError err : errors) {
			validationErrorResponse.getErrors().put(err.getField(), err.getDefaultMessage());
		}
		validationErrorResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
		validationErrorResponse.setMessage("Entered values are wrong");
		validationErrorResponse.setTime(LocalDateTime.now());
		return new ResponseEntity<ValidationErrorResponse>(validationErrorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleException(CustomException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTime(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setResponseCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
