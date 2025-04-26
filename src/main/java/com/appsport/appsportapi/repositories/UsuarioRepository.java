package com.appsport.appsportapi.repositories;

import com.appsport.appsportapi.domain.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByCpf(String cpf);
    Optional<Usuario> findUsuarioById(Long id);
}
