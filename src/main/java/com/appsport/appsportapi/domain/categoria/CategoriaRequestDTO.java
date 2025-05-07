package com.appsport.appsportapi.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO(
        @NotBlank String nome
) {}