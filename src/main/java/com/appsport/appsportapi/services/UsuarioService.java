package com.appsport.appsportapi.services;

import com.appsport.appsportapi.domain.user.Usuario;
import com.appsport.appsportapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void salvarUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

}
