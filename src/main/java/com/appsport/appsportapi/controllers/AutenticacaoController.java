package com.appsport.appsportapi.controllers;

import com.appsport.appsportapi.domain.user.AutenticacaoDTO;
import com.appsport.appsportapi.domain.user.EmailResponseDTO;
import com.appsport.appsportapi.domain.user.RegistrarDTO;
import com.appsport.appsportapi.domain.user.Usuario;
import com.appsport.appsportapi.infra.security.TokenService;
import com.appsport.appsportapi.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("autenticacao")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/email")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new EmailResponseDTO(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody @Valid RegistrarDTO data) {
        if(this.usuarioRepository.findUsuarioByEmail(data.email())!= null) return ResponseEntity.badRequest().build();  {
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario newUsuario = new Usuario(data.email(), encryptedPassword, data.tipoUsuario());

        this.usuarioRepository.save(newUsuario);

        return ResponseEntity.ok().build();
    }
}
