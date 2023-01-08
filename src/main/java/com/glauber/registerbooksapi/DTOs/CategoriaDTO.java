package com.glauber.registerbooksapi.DTOs;

import java.io.Serializable;

import com.glauber.registerbooksapi.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

public class CategoriaDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;
	
    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String descricao;

    public CategoriaDTO(Categoria entity){
    	this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
    }

    public CategoriaDTO(){

    }
}
