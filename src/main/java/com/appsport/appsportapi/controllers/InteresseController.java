package com.appsport.appsportapi.controllers;

import com.appsport.appsportapi.domain.interesse.InteresseRequestDTO;
import com.appsport.appsportapi.domain.interesse.InteresseResponseDTO;
import com.appsport.appsportapi.services.InteresseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interesses")
public class InteresseController {
	@Autowired
	private InteresseService interesseService;

	@PostMapping
	public ResponseEntity<InteresseResponseDTO> criarInteresse(@RequestBody @Valid InteresseRequestDTO data) {
		var interesse = interesseService.salvarInteresse(data);
		return ResponseEntity.ok(new InteresseResponseDTO(interesse));
	}

	@GetMapping("/{idUsuario}")
	public ResponseEntity<List<InteresseResponseDTO>> listarInteresses(@PathVariable Long idUsuario) {
		var interesses = interesseService.listarInteressesPorUsuario(idUsuario);
		return ResponseEntity.ok(interesses);
	}

	@DeleteMapping("/{idInteresse}")
	public ResponseEntity<Void> removerInteresse(@PathVariable Long idInteresse) {
		interesseService.removerInteresse(idInteresse);
		return ResponseEntity.noContent().build();
	}
}
