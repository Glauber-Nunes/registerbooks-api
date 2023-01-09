package com.glauber.registerbooksapi.domain;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
>>>>>>> 9b7125d04cfec2bf2f48e9c8cf2a4aa15aa9a629
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tabela_categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String descricao ;

    @OneToMany(mappedBy = "categoria")
    @Getter
    @Setter
<<<<<<< HEAD
    @JsonIgnore
=======
>>>>>>> 9b7125d04cfec2bf2f48e9c8cf2a4aa15aa9a629
    private List<Livro> livros = new ArrayList<>();

    public Categoria(){

    }

    public Categoria(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

<<<<<<< HEAD
=======
    public void addLivros (Livro livro){

        this.livros.add(livro);

    }
>>>>>>> 9b7125d04cfec2bf2f48e9c8cf2a4aa15aa9a629

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria categoria)) return false;
        return getId().equals(categoria.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}