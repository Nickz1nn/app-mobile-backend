package com.appsport.appsportapi.repositories;

import com.appsport.appsportapi.domain.eventos.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Eventos, Long> {
}
