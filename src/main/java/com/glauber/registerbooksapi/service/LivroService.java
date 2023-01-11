package com.glauber.registerbooksapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glauber.registerbooksapi.domain.Categoria;
import com.glauber.registerbooksapi.domain.Livro;
import com.glauber.registerbooksapi.repositories.LivroRepository;
import com.glauber.registerbooksapi.service.excptions.EntityNotFound;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Long id) {

		Optional<Livro> obj = livroRepository.findById(id);

		obj.orElseThrow(() -> new EntityNotFound("Livro Nao Encontrado Id: " + id + " Tipo " + Livro.class.getName()));

		return obj.get();
	}

	// PESQUISA TODOS OS LIVROS DE DETERMINADA CATEGORIA PESQUISADA PELO ID
	public List<Livro> findAllCategoria(Long id_cat) {

		categoriaService.findById(id_cat); // PESQUISA CATEGORIA NO BANCO PASSANDO O ID

		return livroRepository.findAllCategoria(id_cat);

	}

	public Livro create(Livro livro, Categoria categoria) {

		Livro lv = livroRepository.save(livro);

		return lv;

	}

	public Livro update(Long id, Livro livro) {

		Livro newObj = findById(id);
		updateDataLivro(newObj, livro);

		return livroRepository.save(newObj);

	}

	// APENAS PARA A CLASSE LIVROSERVICE
	private void updateDataLivro(Livro newObj, Livro livro) {

		newObj.setTitulo(livro.getTitulo());
		newObj.setNome_autor(livro.getNome_autor());
		newObj.setTexto(livro.getTexto());
		newObj.setCategoria(livro.getCategoria());
	}
}
