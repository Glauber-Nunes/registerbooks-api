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

        Livro livroProgramacao = new Livro(null,"Codigo Limpo","James Web","James web inventou o cod limpo",categoriaInformatica);
        categoriaInformatica.getLivros().add(livroProgramacao);

        categoriaRepository.saveAll(Arrays.asList(categoriaInformatica,categoriaFiccao,categoriaCientifica));
        livroRepository.saveAll(Arrays.asList(livroProgramacao));

    }
}
