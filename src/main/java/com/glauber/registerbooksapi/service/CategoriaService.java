package com.glauber.registerbooksapi.service;

import com.glauber.registerbooksapi.domain.Categoria;
import com.glauber.registerbooksapi.repositories.CategoriaRepository;
import com.glauber.registerbooksapi.service.excptions.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria buscaPeloId(Long id) {

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        categoriaOptional.orElseThrow(()-> new EntityNotFound("Categoria Nao Existe"));

        return  categoriaOptional.get();
    }


    public List<Categoria> findall(){

        List<Categoria> list = categoriaRepository.findAll();

        return list;
    }
}
