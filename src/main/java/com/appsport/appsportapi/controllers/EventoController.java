package com.appsport.appsportapi.controllers;

import com.appsport.appsportapi.domain.eventos.EventoRequestDTO;
import com.appsport.appsportapi.domain.eventos.EventoResponseDTO;
import com.appsport.appsportapi.domain.eventos.Eventos;
import com.appsport.appsportapi.repositories.EventoRepository;
import com.appsport.appsportapi.services.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("eventos")
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity criarEvento(@RequestBody @Valid EventoRequestDTO body){
        Eventos evento = eventoService.criarEvento(body);
        return ResponseEntity.ok(new EventoResponseDTO(evento));
    }

    @GetMapping

    public ResponseEntity<List<EventoResponseDTO>> listarEventos(){
        var eventos = eventoService.listarEventos();
        return ResponseEntity.ok(eventos);
    }

//    public ResponseEntity getAllEventos(){
//        List<EventoResponseDTO> eventosList = this.eventoRepository
//                .findAll()
//                .stream()
//                .map(EventoResponseDTO::new)
//                .toList();
//
//        return ResponseEntity.ok(eventosList);
//    }
}
