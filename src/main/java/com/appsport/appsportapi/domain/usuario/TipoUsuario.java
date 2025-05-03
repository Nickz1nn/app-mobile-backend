package com.appsport.appsportapi.domain.usuario;

public enum TipoUsuario {
    ADMIN("admin"),
    USER("usuario");
    ;
//    ATHLETE,
//    MANAGER,
//    REFEREE,
//    SPECTATOR,
//    ORGANIZER,
    private String tipo;

    TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
