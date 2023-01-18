package com.glauber.registerbooksapi.domain;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tabela_livro")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@NotEmpty(message = "Campo TITULO Deve Ser Informado")
	@Length(min = 5, max = 30, message = "Informe Um TITULO Com no minimo 5 Caracteres e no Maximo 30 Caracteres")
	private String titulo;
	
	@Getter
	@Setter
	@NotEmpty(message = "Campo NOME AUTOR Deve Ser Informado")
	@Length(min = 10 , max = 50, message = "Informe Um Nome De AUTOR Com no Minimo 10 Caracteres e no Maximo 50 Caracteres")
	private String nome_autor;
	
	@Getter
	@Setter
	@NotEmpty(message = "Campo TEXTO Deve Ser Informado")
	@Length(min = 5 , max = 200, message = "Informe Um TEXTO Com no Minimo 5 Caracteres e no Maximo 200 Caracteres")
	private String texto;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Livro() {

	}

	public Livro(Long id, String titulo, String nome_autor, String texto, Categoria categoria) {
		this.id = id;
		this.titulo = titulo;
		this.nome_autor = nome_autor;
		this.texto = texto;
		this.categoria = categoria;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Livro livro))
			return false;
		return getId().equals(livro.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
