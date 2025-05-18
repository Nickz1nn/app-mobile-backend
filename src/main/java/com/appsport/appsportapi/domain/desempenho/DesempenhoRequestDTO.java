package com.appsport.appsportapi.domain.desempenho;

import jakarta.validation.constraints.NotNull;
import java.time.Duration;

// DTO para criação e atualização de Desempenho
public record DesempenhoRequestDTO(
		@NotNull Long idUsuario,
		@NotNull Long idEvento,
		@NotNull Duration tempoProva,
		@NotNull Integer pontos,
		@NotNull Double media,
		String descricao
) {}