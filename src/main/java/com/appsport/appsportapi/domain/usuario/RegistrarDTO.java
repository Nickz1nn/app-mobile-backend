package com.appsport.appsportapi.domain.usuario;

public record RegistrarDTO(String primeiroNome, String sobrenome, String cpf,String email, String senha, TipoUsuario tipoUsuario) {

}
