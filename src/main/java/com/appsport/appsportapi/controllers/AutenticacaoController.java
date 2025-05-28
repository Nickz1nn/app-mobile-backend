package com.appsport.appsportapi.controllers;

import com.appsport.appsportapi.domain.usuario.AutenticacaoDTO;
import com.appsport.appsportapi.domain.usuario.RegistrarDTO;
import com.appsport.appsportapi.domain.usuario.Usuario;
import com.appsport.appsportapi.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autenticacao")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/email")
    public ResponseEntity<?> login(@RequestBody @Valid AutenticacaoDTO data) {
        Usuario usuario = (Usuario) usuarioRepository.findUsuarioByEmail(data.email());
        if (usuario == null) {
            return ResponseEntity.status(401).body("Usuário não encontrado");
        }

        boolean senhaCorreta = new BCryptPasswordEncoder().matches(data.senha(), usuario.getSenha());
        if (!senhaCorreta) {
            return ResponseEntity.status(401).body("Senha incorreta");
        }

        return ResponseEntity.ok("Login realizado com sucesso");
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody @Valid RegistrarDTO data) {
        if (this.usuarioRepository.findUsuarioByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().body("Email já cadastrado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

        Usuario newUsuario = new Usuario();
        newUsuario.setPrimeiroNome(data.primeiroNome());
        newUsuario.setSobrenome(data.sobrenome());
        newUsuario.setCpf(data.cpf());
        newUsuario.setEmail(data.email());
        newUsuario.setSenha(encryptedPassword);
        newUsuario.setTipoUsuario(data.tipoUsuario());

        this.usuarioRepository.save(newUsuario);

        return ResponseEntity.ok("Usuário registrado com sucesso");
    }
}
