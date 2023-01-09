package com.glauber.registerbooksapi.service;

import com.glauber.registerbooksapi.domain.Categoria;
import com.glauber.registerbooksapi.domain.Livro;
import com.glauber.registerbooksapi.repositories.CategoriaRepository;
import com.glauber.registerbooksapi.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DataService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;


    public void instanciaData(){


       // Categoria categoriaFiccao = new Categoria(null,"Ficçao","Livros De Ficçao");
        // Categoria categoriainfantil = new Categoria(null,"Infantil","Livros Infantil");

        Categoria categoriaInformatica = new Categoria(null,"Informatica","Livros De Informatica");
        Categoria categoriaCientifica = new Categoria(null,"Cientifica","Livros De Ciencia");


        Livro livroProgramacao = new Livro(null,"Codigo Limpo","James Web","James web inventou o cod limpo",categoriaInformatica);
        Livro livroJava = new Livro(null,"Aprenda Java","Eurick","Livro Para Aprender Java",categoriaInformatica);
        Livro livroCientifico = new Livro(null, "Ciencia da lua", "gustavo", "livro para amantes da lua",categoriaCientifica);
        Livro livroCientifico2 = new Livro(null, "Ciencia", "pedro", "livro para amantes da ciencia",categoriaCientifica);

        categoriaInformatica.getLivros().addAll(Arrays.asList(livroProgramacao,livroJava));
        categoriaCientifica.getLivros().addAll(Arrays.asList(livroCientifico,livroCientifico2));

        categoriaRepository.saveAll(Arrays.asList(categoriaInformatica,categoriaCientifica));
        livroRepository.saveAll(Arrays.asList(livroProgramacao,livroJava,livroCientifico,livroCientifico2));






    }
}
