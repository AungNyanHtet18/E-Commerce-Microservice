package com.dev.anh.customer.customer.handler;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.dev.anh.customer.customer.exception.CustomerNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	ResponseEntity<String> handle(CustomerNotFoundException exception) {
		 return ResponseEntity
				   .status(HttpStatus.NOT_FOUND)
				   .body(exception.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exception) {
		
		var errors = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors()
		         .forEach(error -> {
		        	var fieldName = ((FieldError) error).getField(); 
		        	var errorMessage = error.getDefaultMessage();
		        	errors.put(fieldName, errorMessage);
		         });
		
		return ResponseEntity
				   .status(HttpStatus.BAD_REQUEST)
				   .body(new ErrorResponse(errors));
	}
}
