package com.appsport.appsportapi.controllers;

import com.appsport.appsportapi.domain.usuario.Usuario;
import com.appsport.appsportapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// Endpoint para buscar usuário por ID
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		if (usuario == null) {
			return ResponseEntity.status(404).body(null);  // Retorna 404 se o usuário não for encontrado
		}
		return ResponseEntity.ok(usuario);  // Retorna os dados do usuário
	}
}
