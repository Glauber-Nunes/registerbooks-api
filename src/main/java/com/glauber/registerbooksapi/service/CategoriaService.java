package com.glauber.registerbooksapi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.glauber.registerbooksapi.DTOs.CategoriaDTO;
import com.glauber.registerbooksapi.domain.Categoria;
import com.glauber.registerbooksapi.repositories.CategoriaRepository;
import com.glauber.registerbooksapi.service.excptions.EntityNotFound;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findById(Long id) {

		// PESQUISO NO BANCO DE DADOS SE EXISTE OU NAO, SE EXISTE ME RETORNA SE NAO ME
		// LANÇA EXCESSAO
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

<<<<<<< HEAD
		categoriaOptional.orElseThrow(() -> new EntityNotFound("Categoria Nao Existe"));
=======
        //PESQUISO NO BANCO DE DADOS SE EXISTE OU NAO, SE EXISTE ME RETORNA SE NAO ME LANÇA EXCESSAO
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
>>>>>>> 9b7125d04cfec2bf2f48e9c8cf2a4aa15aa9a629

		return categoriaOptional.get();
	}

	public List<Categoria> findAll() {

		List<Categoria> list = categoriaRepository.findAll();

		return list;

		// List<CategoriaDTO> listDto = list.stream().map(obj -> new
		// CategoriaDTO(obj)).toList();
	}

	public Categoria save(Categoria categoria) {

		Categoria cat = categoriaRepository.save(categoria);

		return cat;

	}

	public CategoriaDTO update(Long id, CategoriaDTO dto) {

		// obj RECEBE A PESQUISA DO BANCO E RETORNA O OBJETO OU A EXCESSAO
		Categoria obj = findById(id);

		obj.setNome(dto.getNome());
		obj.setDescricao(dto.getDescricao());

		categoriaRepository.save(obj);

		return new CategoriaDTO(obj);

	}

	public void delete(Long id) {

		findById(id);

		try {
			categoriaRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new com.glauber.registerbooksapi.service.excptions.DataIntegrityViolationException(
					"Categoria Nao pode Ser Deletada Possui Livros Associados");
		}

	}
}
