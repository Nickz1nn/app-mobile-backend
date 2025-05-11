package com.appsport.appsportapi.services;

import com.appsport.appsportapi.domain.notificacao.Notificacao;
import com.appsport.appsportapi.domain.notificacao.NotificacaoRequestDTO;
import com.appsport.appsportapi.domain.usuario.Usuario;
import com.appsport.appsportapi.repositories.NotificacaoRepository;
import com.appsport.appsportapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {
    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Notificacao criarNotificacao(NotificacaoRequestDTO data) {
        Optional<Usuario> usuario = usuarioRepository.findById(data.idUsuario());
        if (usuario.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + data.idUsuario());
        }

        Notificacao notificacao = new Notificacao(data, usuario.get());
        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> listarNotificacoesPorUsuario(Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if (usuario.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + idUsuario);
        }

        return notificacaoRepository.findByUsuario(usuario.get());
    }

    public void marcarComoLida(Long idNotificacao) {
        Notificacao notificacao = notificacaoRepository.findById(idNotificacao)
                .orElseThrow(() -> new IllegalArgumentException("Notificação não encontrada com o ID: " + idNotificacao));
        notificacao.setLida(true);
        notificacaoRepository.save(notificacao);
    }
}
