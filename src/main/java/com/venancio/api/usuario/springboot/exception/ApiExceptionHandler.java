package com.venancio.api.usuario.springboot.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(EmailJaCadastradoException.class)
	public ResponseEntity<ApiError> tratarEmailJaCadastrado(
			EmailJaCadastradoException excep, HttpServletRequest req){
		
		ApiError erro = new ApiError(
				LocalDateTime.now(), 
				HttpStatus.CONFLICT.value(), 
				"Conflict", 
				excep.getMessage(), 
				req.getRequestURI()
				);
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<ApiError> tratarRecursoNaoEncontrado(
			RecursoNaoEncontradoException excep, HttpServletRequest req){
		
		ApiError erro = new ApiError(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				"Not Found", 
				excep.getMessage(), 
				req.getRequestURI()
				);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
