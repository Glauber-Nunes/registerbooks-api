package com.glauber.registerbooksapi.resources;

import com.glauber.registerbooksapi.domain.Categoria;
import com.glauber.registerbooksapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired()
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscaPeloId(@PathVariable Long id){

      Categoria categoria = categoriaService.buscaPeloId(id);

      return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
    public List<Categoria> findall(){
         List<Categoria> list = categoriaService.findall();
        return  list;

    }
}
