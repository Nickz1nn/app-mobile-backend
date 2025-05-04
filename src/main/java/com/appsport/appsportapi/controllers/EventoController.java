package com.appsport.appsportapi.controllers;

import com.appsport.appsportapi.domain.eventos.EventoRequestDTO;
import com.appsport.appsportapi.domain.eventos.EventoResponseDTO;
import com.appsport.appsportapi.domain.eventos.Eventos;
import com.appsport.appsportapi.repositories.EventoRepository;
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

    @PostMapping
    public ResponseEntity postEvento(@RequestBody @Valid EventoRequestDTO body){
        Eventos newEvento = new Eventos(body);

        this.eventoRepository.save(newEvento);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllEventos(){
        List<EventoResponseDTO> eventosList = this.eventoRepository
                .findAll()
                .stream()
                .map(EventoResponseDTO::new)
                .toList();

        return ResponseEntity.ok(eventosList);
    }
}
