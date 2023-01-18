package com.glauber.registerbooksapi.DTOs;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.glauber.registerbooksapi.domain.Categoria;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

public class CategoriaDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long id;
	
    @Getter
    @Setter
    @NotEmpty(message = "Campo NOME Deve Ser Informado")
	@Length(min = 3 , max = 40, message = "Informe Um Nome Valido")
    private String nome;

    @Getter
    @Setter
    @NotEmpty(message = "Campo Descriçao Deve Ser Informado")
	@Length(min = 5 , max = 100, message = "Informe Uma Descriçao Valida")
    private String descricao;

    public CategoriaDTO(Categoria entity){
    	this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
    }

    public CategoriaDTO(){

    }
}
