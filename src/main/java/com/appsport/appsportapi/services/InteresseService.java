package com.appsport.appsportapi.services;

import com.appsport.appsportapi.domain.eventos.Eventos;
import com.appsport.appsportapi.domain.interesse.Interesse;
import com.appsport.appsportapi.domain.interesse.InteresseRequestDTO;
import com.appsport.appsportapi.domain.interesse.InteresseResponseDTO;
import com.appsport.appsportapi.domain.usuario.Usuario;
import com.appsport.appsportapi.repositories.EventoRepository;
import com.appsport.appsportapi.repositories.InteresseRepository;
import com.appsport.appsportapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteresseService {

	@Autowired
	private InteresseRepository interesseRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EventoRepository eventoRepository;

	public Interesse salvarInteresse(InteresseRequestDTO data) {
		Usuario usuario = usuarioRepository.findById(data.idUsuario())
				.orElseThrow(
						()-> new IllegalArgumentException("Usuário não encontrado com o ID: " + data.idUsuario()));
		Eventos evento = eventoRepository.findById(data.idEvento())
				.orElseThrow(
						()-> new IllegalArgumentException("Evento não encontrado com o ID: " + data.idEvento()));

		Interesse interesse = new Interesse(data, usuario, evento);
		return interesseRepository.save(interesse);
	}

	public List<InteresseResponseDTO> listarInteressesPorUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(
						()-> new IllegalArgumentException("Usuário não encontrado com o ID: " + idUsuario));
		return interesseRepository.findByUsuario(usuario).stream()
				.map(InteresseResponseDTO::new)
				.toList();
	}

	public void removerInteresse(Long idInteresse){
		if (!interesseRepository.existsById(idInteresse)) {
			throw new IllegalArgumentException("Interesse não encontrado com o ID: " + idInteresse);
		}
		interesseRepository.deleteById(idInteresse);
	}
}
