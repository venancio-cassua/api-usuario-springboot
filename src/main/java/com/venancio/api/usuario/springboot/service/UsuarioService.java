package com.venancio.api.usuario.springboot.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.venancio.api.usuario.springboot.dto.UsuarioRequestDTO;
import com.venancio.api.usuario.springboot.dto.UsuarioResponseDTO;
import com.venancio.api.usuario.springboot.exception.EmailJaCadastradoException;
import com.venancio.api.usuario.springboot.exception.RecursoNaoEncontradoException;
import com.venancio.api.usuario.springboot.model.UsuarioModel;
import com.venancio.api.usuario.springboot.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<UsuarioResponseDTO> listarUsuarios() {
		List<UsuarioModel> listaModel = this.usuarioRepository.findAll();

		List<UsuarioResponseDTO> listaDto = new ArrayList<>();

		for (UsuarioModel usuario : listaModel) {
			listaDto.add(new UsuarioResponseDTO(usuario));
		}

		return listaDto;
	}

	public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioDto) {

		if (this.usuarioRepository.existsByEmail(usuarioDto.getEmail())) {
			throw new EmailJaCadastradoException("Email já cadastrado: " + usuarioDto.getEmail());
		}

		UsuarioModel usuario = new UsuarioModel();
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());

		UsuarioModel usuarioModel = this.usuarioRepository.save(usuario);

		return new UsuarioResponseDTO(usuarioModel);
	}

	public UsuarioResponseDTO mostrarUsuarioId(Long id) {
		
		UsuarioModel usuario = this.usuarioRepository.findById(id).orElseThrow(
				() -> new RecursoNaoEncontradoException("Usuário não encontrado com id: " + id));

		return new UsuarioResponseDTO(usuario);
	}

	public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO usuarioDto) {
		UsuarioModel usuario = this.usuarioRepository.findById(id).orElseThrow(
				() -> new RecursoNaoEncontradoException("Usuário não encontrado com id: " + id));

		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());

		return new UsuarioResponseDTO(this.usuarioRepository.save(usuario));
	}

	public void excluirUsuario(Long id) {

		UsuarioModel usuario = this.usuarioRepository.findById(id).orElseThrow(
				() -> new RecursoNaoEncontradoException("Usuário não encontrado com id: " + id)); 

		this.usuarioRepository.delete(usuario);
	}

}
