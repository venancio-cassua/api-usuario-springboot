package com.venancio.api.usuario.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venancio.api.usuario.springboot.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	boolean existsByEmail(String email);
}
