package com.appsport.appsportapi.domain.desempenho;

import java.time.Duration;

public record DesempenhoResponseDTO(
		Long id,
		Long idUsuario,
		Long idEvento,
		Duration tempoProva,
		Integer pontos,
		Double media,
		String descricao,
		String nomeUsuario,
		String nomeEvento
) {
	public DesempenhoResponseDTO(Desempenho desempenho) {
		this(
				desempenho.getId(),
				desempenho.getUsuario().getId(),
				desempenho.getEvento().getId(),
				desempenho.getTempoProva(),
				desempenho.getPontos(),
				desempenho.getMedia(),
				desempenho.getDescricao(),
				desempenho.getUsuario().getPrimeiroNome() + " " + desempenho.getUsuario().getSobrenome(),
				desempenho.getEvento().getNome()
		);
	}
}
