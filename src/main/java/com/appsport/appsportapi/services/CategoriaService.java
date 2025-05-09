package com.appsport.appsportapi.services;

import com.appsport.appsportapi.domain.categoria.Categoria;
import com.appsport.appsportapi.domain.categoria.CategoriaRequestDTO;
import com.appsport.appsportapi.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvarCategoria(CategoriaRequestDTO data) {
        Categoria categoria = new Categoria();
        categoria.setNome(data.nome());
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
}
