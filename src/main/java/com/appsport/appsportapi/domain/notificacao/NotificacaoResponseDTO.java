package com.appsport.appsportapi.domain.notificacao;

import java.util.Date;

public record NotificacaoResponseDTO(
        Long id,
        String mensagem,
        Date dataEnvio,
        boolean lida,
        Long idUsuario
) {
    public NotificacaoResponseDTO(Notificacao notificacao) {
        this(
                notificacao.getId(),
                notificacao.getMensagem(),
                notificacao.getDataEnvio(),
                notificacao.isLida(),
                notificacao.getUsuario().getId()
        );
    }
}
