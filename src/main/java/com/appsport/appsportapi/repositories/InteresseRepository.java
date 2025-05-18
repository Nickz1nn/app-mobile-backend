package com.appsport.appsportapi.repositories;

import com.appsport.appsportapi.domain.eventos.Eventos;
import com.appsport.appsportapi.domain.interesse.Interesse;
import com.appsport.appsportapi.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InteresseRepository extends JpaRepository<Interesse, Long> {
	List<Interesse> findByUsuario(Usuario usuario);
	List<Interesse> findByEvento(Eventos evento);
	Optional<Interesse> findByUsuarioAndEvento(Usuario usuario, Eventos evento);
	boolean existsByUsuarioAndEvento(Usuario usuario, Eventos evento);
}
