package com.glauber.registerbooksapi.service;

import com.glauber.registerbooksapi.domain.Categoria;
import com.glauber.registerbooksapi.domain.Livro;
import com.glauber.registerbooksapi.repositories.CategoriaRepository;
import com.glauber.registerbooksapi.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DataService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;


    public void instanciaData(){

        Categoria categoriaInformatica = new Categoria(null,"Informatica","Livros De Informatica");
        Categoria categoriaFiccao = new Categoria(null,"Ficçao","Livros De Ficçao");
        Categoria categoriaCientifica = new Categoria(null,"Cientifica","Livros De Ciencia");
        Categoria categoriainfantil = new Categoria(null,"Infantil","Livros Infantil");

        Livro livroProgramacao = new Livro(null,"Codigo Limpo","James Web","James web inventou o cod limpo",categoriaInformatica);
        Livro livroJava = new Livro(null,"Aprenda Java","Eurick","Livro Para Aprender Java",categoriaInformatica);
        Livro livroCientifico = new Livro(null, "Ciencia da lua", "gustavo", "livro para amantes da lua",categoriaCientifica);
        Livro livroCientifico2 = new Livro(null, "Ciencia", "pedro", "livro para amantes da ciencia",categoriaCientifica);

        categoriaRepository.saveAll(Arrays.asList(categoriaInformatica,categoriaFiccao,categoriaCientifica,categoriainfantil));
        livroRepository.saveAll(Arrays.asList(livroProgramacao,livroJava,livroCientifico,livroCientifico2));



    }
}
