package com.appsport.appsportapi.domain.notificacao;

import com.appsport.appsportapi.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "qbdf_notificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @Column(nullable = false)
    private String mensagem;

    @Column(nullable = false)
    private Date dataEnvio;

    @Column(nullable = false)
    private boolean lida = false;

    public Notificacao(NotificacaoRequestDTO data, Usuario usuario) {
        this.usuario = usuario;
        this.mensagem = data.mensagem();
        this.dataEnvio = new Date();
        this.lida = false;
    }
}
