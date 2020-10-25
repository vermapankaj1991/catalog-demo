package com.demo.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> badRequestHandler(BadRequestException e){
		return new ResponseEntity<String>(e.getError().toString(), HttpStatus.BAD_REQUEST);
	}

}
