package com.appsport.appsportapi.domain.eventos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record EventoRequestDTO(
        @NotBlank
        String nome,

        @NotNull
        Long idCategoria,

        @NotNull
        Date dataEvento,

        @NotBlank
        String local,

        String descricao,

        @NotBlank
        String urlEvento,

        @NotBlank
        String organizador
) {}
