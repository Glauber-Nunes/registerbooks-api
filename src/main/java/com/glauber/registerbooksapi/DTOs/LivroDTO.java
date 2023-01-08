package com.glauber.registerbooksapi.DTOs;

import com.glauber.registerbooksapi.domain.Categoria;
import com.glauber.registerbooksapi.domain.Livro;

import lombok.Getter;
import lombok.Setter;

public class LivroDTO {

	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String titulo;
	@Getter
	@Setter
	private String nome_autor;
	@Getter
	@Setter
	private String texto;
	
	@Getter
	@Setter
	private Categoria categoria;
	
	public LivroDTO(Livro entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.texto = entity.getTexto();
		this.categoria = entity.getCategoria();
	}
}
