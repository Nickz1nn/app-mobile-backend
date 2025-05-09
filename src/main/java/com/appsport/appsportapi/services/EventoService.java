package com.appsport.appsportapi.services;

import com.appsport.appsportapi.domain.categoria.Categoria;
import com.appsport.appsportapi.domain.eventos.EventoRequestDTO;
import com.appsport.appsportapi.domain.eventos.EventoResponseDTO;
import com.appsport.appsportapi.domain.eventos.Eventos;
import com.appsport.appsportapi.repositories.CategoriaRepository;
import com.appsport.appsportapi.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Eventos criarEvento(EventoRequestDTO data) {
        Categoria categoria = categoriaRepository.findById(data.idCategoria())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        Eventos evento = new Eventos(data, categoria);
        return eventoRepository.save(evento);
    }

    public List<EventoResponseDTO> listarEventos() {
        return eventoRepository.findAll().stream()
                .map(EventoResponseDTO::new)
                .toList();
    }

}
