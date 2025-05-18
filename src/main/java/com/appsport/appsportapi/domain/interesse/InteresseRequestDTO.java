package com.appsport.appsportapi.domain.interesse;

import jakarta.validation.constraints.NotNull;

public record InteresseRequestDTO(
		@NotNull Long idUsuario,
		@NotNull Long idEvento
) {}
