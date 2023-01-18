package com.glauber.registerbooksapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tabela_categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@NotEmpty(message = "Campo NOME Deve Ser Informado")
	@Length(min = 3 , max = 40, message = "Informe Um Nome Com 3 a 40 Caracteres")
	private String nome;

	@Getter
	@Setter
	@NotEmpty(message = "Campo Descriçao Deve Ser Informado")
	@Length(min = 5 , max = 100, message = "Informe Uma Descriçao Com 5 a 100 Caracteres")
	private String descricao;

	@Getter
	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private List<Livro> livros = new ArrayList<>();

	public Categoria() {

	}

	public Categoria(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Categoria categoria))
			return false;
		return getId().equals(categoria.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}