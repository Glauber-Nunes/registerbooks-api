package com.glauber.registerbooksapi.DTOs;

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

	public LivroDTO(Livro entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
	}
}
