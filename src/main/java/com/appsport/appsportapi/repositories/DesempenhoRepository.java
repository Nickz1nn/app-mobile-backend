package com.appsport.appsportapi.repositories;

import com.appsport.appsportapi.domain.desempenho.Desempenho;
import com.appsport.appsportapi.domain.eventos.Eventos;
import com.appsport.appsportapi.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DesempenhoRepository extends JpaRepository<Desempenho, Long> {
	List<Desempenho> findByUsuario(Usuario usuario);
	List<Desempenho> findByEvento(Eventos evento);
	Optional<Desempenho> findByUsuarioAndEvento(Usuario usuario, Eventos evento);
}
