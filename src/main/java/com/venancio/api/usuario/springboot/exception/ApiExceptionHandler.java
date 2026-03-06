package com.venancio.api.usuario.springboot.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> tratarErroValidacao(MethodArgumentNotValidException excep, HttpServletRequest req){
		
		Map<String, String> erros = new HashMap<>();
		excep.getBindingResult().getFieldErrors().forEach(erro -> {
			erros.put(erro.getField(), erro.getDefaultMessage());
		});
		
		ApiError request = new ApiError(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				"Bad Request", 
				"Erro de validação", 
				req.getRequestURI()
				); 
		
		request.setErros(erros);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(request);
	}
}
