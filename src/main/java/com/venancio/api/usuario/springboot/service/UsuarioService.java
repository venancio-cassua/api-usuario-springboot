package com.venancio.api.usuario.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.venancio.api.usuario.springboot.dto.UsuarioDto;
import com.venancio.api.usuario.springboot.model.UsuarioModel;
import com.venancio.api.usuario.springboot.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<UsuarioDto> listarUsuarios() {
		List<UsuarioModel> listaModel = this.usuarioRepository.findAll();

		List<UsuarioDto> listaDto = new ArrayList<>();

		for (UsuarioModel usuario : listaModel) {
			listaDto.add(new UsuarioDto(usuario));
		}

		return listaDto;
	}

	public UsuarioDto cadastrarUsuario(UsuarioDto usuarioDto) {
		
		if (this.usuarioRepository.existsByEmail(usuarioDto.getEmail())) {
			return null;
		}

		UsuarioModel usuario = new UsuarioModel();
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());

		UsuarioModel usuarioModel = this.usuarioRepository.save(usuario);

		return new UsuarioDto(usuarioModel);
	}

	public UsuarioDto mostrarUsuarioId(Long id) {
		Optional<UsuarioModel> usuarioOptional = this.usuarioRepository.findById(id);

		if (usuarioOptional.isEmpty()) {
			return null;
		}
 
		return new UsuarioDto(usuarioOptional.get());
	}

	public UsuarioDto atualizarUsuario(Long id, UsuarioDto usuarioDto) {
		Optional<UsuarioModel> usuarioOptional = this.usuarioRepository.findById(id);

		if (usuarioOptional.isEmpty()) {
			return null;
		}

		UsuarioModel usuarioModel = usuarioOptional.get();
		usuarioModel.setNome(usuarioDto.getNome());
		usuarioModel.setEmail(usuarioDto.getEmail());

		return new UsuarioDto(this.usuarioRepository.save(usuarioModel));
	}
	
	public void excluirUsuario(Long id) {
		
		Optional<UsuarioModel> usuarioOptional = this.usuarioRepository.findById(id);

		this.usuarioRepository.delete(usuarioOptional.get());
	}

}
