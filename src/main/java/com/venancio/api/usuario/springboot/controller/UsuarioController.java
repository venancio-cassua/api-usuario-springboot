package com.venancio.api.usuario.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venancio.api.usuario.springboot.dto.UsuarioDto;
import com.venancio.api.usuario.springboot.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public ResponseEntity<List<UsuarioDto>> listaUsuarios() {

		return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.listarUsuarios());
	}

	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.cadastrarUsuario(usuarioDto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> mostrarUsuarioId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.mostrarUsuarioId(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {

		return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.atualizarUsuario(id, usuarioDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
		this.usuarioService.excluirUsuario(id);
		return ResponseEntity.noContent().build();
	}

}
