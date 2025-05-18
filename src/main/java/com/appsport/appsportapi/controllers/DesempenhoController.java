package com.appsport.appsportapi.controllers;

import com.appsport.appsportapi.domain.desempenho.DesempenhoRequestDTO;
import com.appsport.appsportapi.domain.desempenho.DesempenhoResponseDTO;
import com.appsport.appsportapi.services.DesempenhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desempenhos")
public class DesempenhoController {

	@Autowired
	private DesempenhoService desempenhoService;

	@PostMapping
	public ResponseEntity<DesempenhoResponseDTO> criarDesempenho(@RequestBody @Valid DesempenhoRequestDTO data) {
		var desempenho = desempenhoService.criarDesempenho(data);
		return ResponseEntity.ok(desempenho);
	}

	@GetMapping
	public ResponseEntity<List<DesempenhoResponseDTO>> listarDesempenhos() {
		var desempenhos = desempenhoService.listarDesempenhos();
		return ResponseEntity.ok(desempenhos);
	}

	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity<List<DesempenhoResponseDTO>> listarDesempenhosPorUsuario(@PathVariable Long idUsuario) {
		var desempenhos = desempenhoService.listarDesempenhosPorUsuario(idUsuario);
		return ResponseEntity.ok(desempenhos);
	}

	@GetMapping("/evento/{idEvento}")
	public ResponseEntity<List<DesempenhoResponseDTO>> listarDesempenhosPorEvento(@PathVariable Long idEvento) {
		var desempenhos = desempenhoService.listarDesempenhosPorEvento(idEvento);
		return ResponseEntity.ok(desempenhos);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarDesempenho(@PathVariable Long id) {
		desempenhoService.deletarDesempenho(id);
		return ResponseEntity.noContent().build();
	}
}
