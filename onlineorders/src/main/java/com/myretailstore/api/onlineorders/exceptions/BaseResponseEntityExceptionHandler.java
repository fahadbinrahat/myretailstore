package com.myretailstore.api.onlineorders.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class BaseResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public final ResponseEntity<Object> UserNotFoundException(OrderNotFoundException unfe, WebRequest request){
		
		ErrorResponse errorResponse = new ErrorResponse(unfe.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
		
	}

}

