package com.glauber.registerbooksapi.resources;

import com.glauber.registerbooksapi.domain.Categoria;
import com.glauber.registerbooksapi.domain.Livro;
import com.glauber.registerbooksapi.service.CategoriaService;
import com.glauber.registerbooksapi.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroResource {

    @Autowired()
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscaPeloId(@PathVariable Long id){

      Livro livro = livroService.buscaPeloId(id);

      return ResponseEntity.ok().body(livro);
    }

    @GetMapping
    public List<Livro> findall(){
         List<Livro> list = livroService.findall();
        return  list;

    }
}
