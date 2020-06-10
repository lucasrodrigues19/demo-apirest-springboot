package com.lrvendas.springbootex.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lrvendas.springbootex.services.exceptions.DatabaseException;
import com.lrvendas.springbootex.services.exceptions.ResourceNotFoundException;

@ControllerAdvice//interceptar as excessoes que ocorrerem para que esse objeto possa dar um possivel tratamento
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) //interceptar a requisição que gerou a exessao
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.ok().body(err);
	}
	
	@ExceptionHandler(DatabaseException.class) //interceptar a requisição que gerou a exessao
	public ResponseEntity<StandardError> resourceNotFound(DatabaseException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.ok().body(err);
	}
}
