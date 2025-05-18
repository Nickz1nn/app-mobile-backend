package com.appsport.appsportapi.domain.desempenho;

import com.appsport.appsportapi.domain.eventos.Eventos;
import com.appsport.appsportapi.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
@Entity(name = "Desempenho")
@Table(name = "qbdf_desempenho")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Desempenho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_evento", referencedColumnName = "id", nullable = false)
	private Eventos evento;

	@Column(name = "tempo_prova", nullable = false)
	private Duration tempoProva;

	@Column(nullable = false)
	private Integer pontos;

	@Column(nullable = false)
	private Double media;

	@Column(length = 255)
	private String descricao;

	public Desempenho(DesempenhoRequestDTO data, Usuario usuario, Eventos evento) {
		this.usuario = usuario;
		this.evento = evento;
		this.tempoProva = data.tempoProva();
		this.pontos = data.pontos();
		this.media = data.media();
		this.descricao = data.descricao();
	}
}

