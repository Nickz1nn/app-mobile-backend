package com.appsport.appsportapi.controllers;

import com.appsport.appsportapi.domain.notificacao.NotificacaoRequestDTO;
import com.appsport.appsportapi.domain.notificacao.NotificacaoResponseDTO;
import com.appsport.appsportapi.services.NotificacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping
    public ResponseEntity<NotificacaoResponseDTO> criarNotificacao(@RequestBody @Valid NotificacaoRequestDTO data) {
        var notificacao = notificacaoService.criarNotificacao(data);
        return ResponseEntity.ok(new NotificacaoResponseDTO(notificacao));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<NotificacaoResponseDTO>> listarNotificacoes(@PathVariable Long idUsuario) {
        var notificacoes = notificacaoService.listarNotificacoesPorUsuario(idUsuario);
        var response = notificacoes.stream()
                .map(NotificacaoResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{idNotificacao}/lida")
    public ResponseEntity marcarComoLida(@PathVariable Long idNotificacao) {
        notificacaoService.marcarComoLida(idNotificacao);
        return ResponseEntity.ok().build();
    }
}
