package com.glauber.registerbooksapi.service;

import com.glauber.registerbooksapi.domain.Livro;
import com.glauber.registerbooksapi.repositories.LivroRepository;
import com.glauber.registerbooksapi.service.excptions.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public Livro findById(Long id) {

		Optional<Livro> obj = livroRepository.findById(id);

		obj.orElseThrow(() -> new EntityNotFound("Livro Nao Existe"));

		return obj.get();
	}

	public List<Livro> findall() {

		List<Livro> list = livroRepository.findAll();

		return list;
	}

	public Livro save(Livro livro) {

		Livro lv = livroRepository.save(livro);

		return lv;

	}
}
