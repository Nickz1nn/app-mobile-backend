package com.appsport.appsportapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Usuario")
@Table(name = "qbdf_usuario")
@Getter
@Setter
@AllArgsConstructor
// @NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String primeiroNome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public Usuario() {

    }
}
