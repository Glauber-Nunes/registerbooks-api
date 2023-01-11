package com.glauber.registerbooksapi.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glauber.registerbooksapi.DTOs.LivroDTO;
import com.glauber.registerbooksapi.domain.Categoria;
import com.glauber.registerbooksapi.domain.Livro;
import com.glauber.registerbooksapi.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	@Autowired()
	private LivroService livroService;

	@GetMapping("/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {

		Livro livro = livroService.findById(id);

		return ResponseEntity.ok().body(livro);
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat) {

		List<Livro> list = livroService.findAllCategoria(id_cat);

		List<LivroDTO> listDto = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

		// (URL DO MAPEAMENTO) http://localhost:8086/livros?categoria=id_cat

	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestBody Livro livro, @RequestBody Categoria categoria) {

		Livro lv = livroService.create(livro, categoria);

		return ResponseEntity.ok().body(lv);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
		Livro obj = livroService.update(id, livro);

		return ResponseEntity.ok().body(obj);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Long id, @RequestBody Livro livro) {
		Livro obj = livroService.update(id, livro);

		return ResponseEntity.ok().body(obj);
	}
}
