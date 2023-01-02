package com.glauber.registerbooksapi.DTOs;

import com.glauber.registerbooksapi.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

public class CategoriaDTO {

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String descricao;

    public CategoriaDTO(Categoria entity){
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
    }

    public CategoriaDTO(){

    }
}
