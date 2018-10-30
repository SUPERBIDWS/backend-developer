package com.test.sbws.blog.rest.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestErrorAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<Object> handleDefault(RuntimeException ex,
			WebRequest request) {
		
		String bodyOfResponse = "Erro Interno!";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}
