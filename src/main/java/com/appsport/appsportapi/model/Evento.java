//// Estrutura das entidades do backend em Java com Spring Boot
//// Pacote base: com.appsport.appsportapi.model
//
//package com.appsport.appsportapi.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//import java.time.Duration;
//import java.util.Objects;
//
//@Entity
//@Table(name = "qbdf_evento")
//public class Evento {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, length = 255)
//    private String nome;
//
//    @ManyToOne
//    @JoinColumn(name = "id_categoria")
//    private Categoria categoria;
//
//    @Column(nullable = false)
//    private LocalDateTime dataEvento;
//
//    @Column(nullable = false, length = 255)
//    private String local;
//
//    @Column(columnDefinition = "TEXT")
//    private String descricao;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public Categoria getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(Categoria categoria) {
//        this.categoria = categoria;
//    }
//
//    public LocalDateTime getDataEvento() {
//        return dataEvento;
//    }
//
//    public void setDataEvento(LocalDateTime dataEvento) {
//        this.dataEvento = dataEvento;
//    }
//
//    public String getLocal() {
//        return local;
//    }
//
//    public void setLocal(String local) {
//        this.local = local;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    public Usuario getOrganizador() {
//        return organizador;
//    }
//
//    public void setOrganizador(Usuario organizador) {
//        this.organizador = organizador;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "organizador")
//    private Usuario organizador;
//}
//
//
