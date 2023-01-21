package com.glauber.registerbooksapi.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.glauber.registerbooksapi.domain.Livro;
import com.glauber.registerbooksapi.service.LivroService;

import jakarta.validation.Valid;

@CrossOrigin("*") // ANOTAÇAO PARA O FRONT END ANGULAR
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

	// PESQUISA TODOS OS LIVROS DE DETERMINADA CATEGORIA PESQUISADA PELO ID
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAllLivroPerCategoria(
			@RequestParam(value = "categoria", defaultValue = "0") Long id_cat) {

		List<Livro> list = livroService.findAllLivroPerCategoria(id_cat);

		List<LivroDTO> listDto = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

		// (URL DO MAPEAMENTO) http://localhost:8086/livros?categoria=id_cat

	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> update(@PathVariable Long id, @Valid @RequestBody Livro livro) {
		Livro obj = livroService.update(id, livro);

		return ResponseEntity.ok().body(obj);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Long id, @Valid @RequestBody Livro livro) {
		Livro obj = livroService.update(id, livro);

		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Long id_cate,
			@Valid @RequestBody Livro livro) {

		return ResponseEntity.status(HttpStatus.CREATED).
				body(livroService.create(id_cate, livro));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {

		livroService.delete(id);

		return ResponseEntity.ok().body("Livro Deletado Com Sucesso ID: " + id + ": " + Livro.class.getName());

	}
}
