//package com.appsport.appsportapi.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//import java.time.Duration;
//import java.util.Objects;
//
//@Entity
//@Table(name = "qbdf_desempenho")
//public class Desempenho {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "id_usuario")
//    private Usuario usuario;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    public Evento getEvento() {
//        return evento;
//    }
//
//    public void setEvento(Evento evento) {
//        this.evento = evento;
//    }
//
//    public Duration getTempoProva() {
//        return tempoProva;
//    }
//
//    public void setTempoProva(Duration tempoProva) {
//        this.tempoProva = tempoProva;
//    }
//
//    public Integer getPontos() {
//        return pontos;
//    }
//
//    public void setPontos(Integer pontos) {
//        this.pontos = pontos;
//    }
//
//    public Double getMedia() {
//        return media;
//    }
//
//    public void setMedia(Double media) {
//        this.media = media;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "id_evento")
//    private Evento evento;
//
//    private Duration tempoProva;
//
//    private Integer pontos;
//
//    private Double media;
//}
