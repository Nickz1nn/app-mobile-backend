package com.appsport.appsportapi.services;

import com.appsport.appsportapi.domain.desempenho.Desempenho;
import com.appsport.appsportapi.domain.desempenho.DesempenhoRequestDTO;
import com.appsport.appsportapi.domain.desempenho.DesempenhoResponseDTO;
import com.appsport.appsportapi.domain.eventos.Eventos;
import com.appsport.appsportapi.domain.usuario.Usuario;
import com.appsport.appsportapi.repositories.DesempenhoRepository;
import com.appsport.appsportapi.repositories.EventoRepository;
import com.appsport.appsportapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DesempenhoService {

	@Autowired
	private DesempenhoRepository desempenhoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EventoRepository eventoRepository;

	public DesempenhoResponseDTO criarDesempenho(DesempenhoRequestDTO data) {
		Usuario usuario = usuarioRepository.findById(data.idUsuario())
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + data.idUsuario()));
		Eventos evento = eventoRepository.findById(data.idEvento())
				.orElseThrow(() -> new IllegalArgumentException("Evento não encontrado com ID: " + data.idEvento()));

		Desempenho desempenho = new Desempenho(data, usuario, evento);
		desempenhoRepository.save(desempenho);
		return new DesempenhoResponseDTO(desempenho);
	}

	public List<DesempenhoResponseDTO> listarDesempenhos() {
		return desempenhoRepository.findAll().stream()
				.map(DesempenhoResponseDTO::new)
				.collect(Collectors.toList());
	}

	public List<DesempenhoResponseDTO> listarDesempenhosPorUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + idUsuario));
		return desempenhoRepository.findByUsuario(usuario).stream()
				.map(DesempenhoResponseDTO::new)
				.collect(Collectors.toList());
	}

	public List<DesempenhoResponseDTO> listarDesempenhosPorEvento(Long idEvento) {
		Eventos evento = eventoRepository.findById(idEvento)
				.orElseThrow(() -> new IllegalArgumentException("Evento não encontrado com ID: " + idEvento));
		return desempenhoRepository.findByEvento(evento).stream()
				.map(DesempenhoResponseDTO::new)
				.collect(Collectors.toList());
	}

	public void deletarDesempenho(Long id) {
		if (!desempenhoRepository.existsById(id)) {
			throw new IllegalArgumentException("Desempenho não encontrado com ID: " + id);
		}
		desempenhoRepository.deleteById(id);
	}
}
