//package com.appsport.appsportapi.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//import java.time.Duration;
//import java.util.Objects;
//
//@Entity
//@Table(name = "qbdf_notificacao")
//public class Notificacao {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
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
//    public String getMensagem() {
//        return mensagem;
//    }
//
//    public void setMensagem(String mensagem) {
//        this.mensagem = mensagem;
//    }
//
//    public LocalDateTime getDataEnvio() {
//        return dataEnvio;
//    }
//
//    public void setDataEnvio(LocalDateTime dataEnvio) {
//        this.dataEnvio = dataEnvio;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "id_usuario")
//    private Usuario usuario;
//
//    @Column(columnDefinition = "TEXT")
//    private String mensagem;
//
//    private LocalDateTime dataEnvio = LocalDateTime.now();
//}
