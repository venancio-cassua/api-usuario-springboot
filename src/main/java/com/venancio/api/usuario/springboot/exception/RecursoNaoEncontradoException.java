package com.venancio.api.usuario.springboot.exception;

public class RecursoNaoEncontradoException extends RuntimeException {
	
	public RecursoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
}
