package com.glauber.registerbooksapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    //SERVE PARA MUDAR NOME DA COLUNA NO BANCO @Column(name = "`titu`")
    private String titulo;
    @Getter
    @Setter
    private String nome_autor;
    @Getter
    @Setter
    private String texto;
    @OneToOne
    @Getter
    @Setter
    private Categoria categoria;

    public Livro(){

    }
    public Livro(Long id, String titulo, String nome_autor, String texto,Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;
        return getId().equals(livro.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
