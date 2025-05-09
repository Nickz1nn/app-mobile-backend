package com.appsport.appsportapi.controllers;

import com.appsport.appsportapi.domain.categoria.CategoriaRequestDTO;
import com.appsport.appsportapi.domain.categoria.CategoriaResponseDTO;
import com.appsport.appsportapi.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> criarCategoria(@RequestBody @Valid CategoriaRequestDTO data){
        var categoria = categoriaService.salvarCategoria(data);
        return ResponseEntity.ok(new CategoriaResponseDTO(categoria));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarCategorias(){
        var categorias = categoriaService.listarCategorias();
        var response = categorias.stream()
                .map(CategoriaResponseDTO::new)
                .toList();
        return ResponseEntity.ok(response);
    }

}
