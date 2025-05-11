package com.appsport.appsportapi.domain.notificacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NotificacaoRequestDTO(

        @NotBlank
        String mensagem,

        @NotNull
        Long idUsuario
) {}
