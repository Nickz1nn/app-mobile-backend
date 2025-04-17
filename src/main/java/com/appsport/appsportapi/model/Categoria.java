package com.appsport.appsportapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.Objects;

@Entity
@Table(name = "qbdf_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}