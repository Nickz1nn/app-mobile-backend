package com.appsport.appsportapi.domain.interesse;

public record InteresseResponseDTO(Long id, Long idUsuario, Long idEvento) {
	public InteresseResponseDTO(Interesse interesse) {
		this(interesse.getId(), interesse.getUsuario().getId(), interesse.getEvento().getId());
	}
}
