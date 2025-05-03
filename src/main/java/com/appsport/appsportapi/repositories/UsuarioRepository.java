package com.appsport.appsportapi.repositories;

import com.appsport.appsportapi.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findUsuarioByEmail(String email);
    Optional<Usuario> findUsuarioByCpf(String cpf);
    Optional<Usuario> findUsuarioById(Long id);
}
