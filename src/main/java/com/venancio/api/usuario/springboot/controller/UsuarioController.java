package com.venancio.api.usuario.springboot.controller;

import java.util.List;

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
	public List<UsuarioDto> listaUsuarios() {
		return this.usuarioService.listarUsuarios();
	}

	@PostMapping
	public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {

		return this.usuarioService.cadastrarUsuario(usuarioDto);
	}

	@GetMapping("/{id}")
	public UsuarioDto mostrarUsuarioId(@PathVariable Long id) {
		return this.usuarioService.mostrarUsuarioId(id);
	}

	@PutMapping("/{id}")
	public UsuarioDto atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {

		return this.usuarioService.atualizarUsuario(id, usuarioDto);
	}
	
	@DeleteMapping("/{id}")
	public void excluirUsuario(@PathVariable Long id) {
		this.usuarioService.excluirUsuario(id);
	}

}
