package com.appsport.appsportapi.domain.interesse;

import com.appsport.appsportapi.domain.eventos.Eventos;
import com.appsport.appsportapi.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "qbdf_interesse")
@Entity(name = "Interesse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Interesse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn (name = "id_usuario", referencedColumnName = "id", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn (name = "id_evento", referencedColumnName = "id", nullable = false)
	private Eventos evento;

	public Interesse(InteresseRequestDTO data, Usuario usuario, Eventos evento) {
		this.usuario = usuario;
		this.evento = evento;
	}
}
