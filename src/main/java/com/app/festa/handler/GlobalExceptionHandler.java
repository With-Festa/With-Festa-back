package com.app.festa.handler;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value=IllegalArgumentException.class)
	public String handleArgumentException(IllegalArgumentException e) {
		return "<h1>" + e.getMessage() + "<h1>";
	}
	
	@ExceptionHandler(value=RuntimeException.class)
	public String runtTimeException(RuntimeException e ) {
		return "<h1>" + e.getMessage() + "<h1>";
	}
	
	@ExceptionHandler(value=NotFoundException.class)
	public String notFoundException(NotFoundException e) {
		return "<h1>" + e.getMessage() + "<h1>";
	}
	
}
