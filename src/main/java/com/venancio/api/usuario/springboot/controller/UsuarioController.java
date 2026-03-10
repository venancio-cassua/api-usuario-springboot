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

import com.venancio.api.usuario.springboot.dto.UsuarioRequestDTO;
import com.venancio.api.usuario.springboot.dto.UsuarioResponseDTO;
import com.venancio.api.usuario.springboot.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Operation(summary = "Listar todos os usuários")
	@GetMapping
	public ResponseEntity<List<UsuarioResponseDTO>> listaUsuarios() {
 
		return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.listarUsuarios());
	}

	@Operation(summary = "Cadastrar novo usuário")
	@PostMapping
	public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@Valid @RequestBody UsuarioRequestDTO usuarioDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.cadastrarUsuario(usuarioDto));
	}

	@Operation(summary = "Buscar usuário por ID")
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDTO> mostrarUsuarioId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.mostrarUsuarioId(id));
	}

	@Operation(summary = "Atualizar usuário")
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO usuarioDto) {

		return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.atualizarUsuario(id, usuarioDto));
	}

	@Operation(summary = "Excluir usuário")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
		this.usuarioService.excluirUsuario(id);
		return ResponseEntity.noContent().build();
	} 

}
