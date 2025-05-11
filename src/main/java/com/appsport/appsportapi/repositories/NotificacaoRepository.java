package com.appsport.appsportapi.repositories;

import com.appsport.appsportapi.domain.notificacao.Notificacao;
import com.appsport.appsportapi.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    List<Notificacao> findByUsuario(Usuario usuario);
}
