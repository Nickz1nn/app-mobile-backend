package com.appsport.appsportapi.domain.eventos;

import com.appsport.appsportapi.domain.categoria.Categoria;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "qbdf_eventos")
@Entity(name = "Eventos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;

    private Date data_evento;

    private String local;

    private String descricao;

    private String url_evento;

    private String organizador;

    public Eventos(EventoRequestDTO data) {
        this.nome = data.nome();
        //this.categoria = new Categoria(data.idCategoria());
        this.data_evento = data.dataEvento();
        this.local = data.local();
        this.descricao = data.descricao();
        this.url_evento = data.urlEvento();
        this.organizador = data.organizador();
    }

}
