package com.glauber.registerbooksapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glauber.registerbooksapi.domain.Livro;
import com.glauber.registerbooksapi.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	@Autowired()
	private LivroService livroService;

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscaPeloId(@PathVariable Long id) {

		Livro livro = livroService.findById(id);

		return ResponseEntity.ok().body(livro);
	}

	@GetMapping
	public ResponseEntity<List<Livro>> findall() {
		List<Livro> list = livroService.findall();
		return ResponseEntity.ok().body(list);

	}

	@PostMapping
	public ResponseEntity<Livro> save(@RequestBody Livro livro) {

		Livro lv = livroService.save(livro);

		return ResponseEntity.ok().body(lv);

	}
}
