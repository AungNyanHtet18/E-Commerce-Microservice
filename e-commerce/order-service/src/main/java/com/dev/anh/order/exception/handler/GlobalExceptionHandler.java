package com.dev.anh.order.exception.handler;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.dev.anh.order.exception.BusinessException;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	ResponseEntity<String> handle(BusinessException exception) {
		 return ResponseEntity
			   .status(HttpStatus.BAD_REQUEST)
			   .body(exception.getMessage());
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	ResponseEntity<String> handle(EntityNotFoundException exception) {
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
