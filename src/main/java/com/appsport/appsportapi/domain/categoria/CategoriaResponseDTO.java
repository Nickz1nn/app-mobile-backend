package com.appsport.appsportapi.domain.categoria;
public record CategoriaResponseDTO(Long id, String nome) {
    public CategoriaResponseDTO(Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }
}
