package com.appsport.appsportapi.domain.eventos;

import java.util.Date;

public record EventoResponseDTO(Long id, String nome, String categoria, Date data, String local,
                                String descricao, String url_evento, String organizador) {
    public EventoResponseDTO(Eventos eventos) {
        this(eventos.getId(),
                eventos.getNome(),
                eventos.getCategoria() != null ? eventos.getCategoria().getNome() : null,
                eventos.getData_evento(),
                eventos.getLocal(),
                eventos.getDescricao(),
                eventos.getUrl_evento(),
                eventos.getOrganizador());
    }
}
