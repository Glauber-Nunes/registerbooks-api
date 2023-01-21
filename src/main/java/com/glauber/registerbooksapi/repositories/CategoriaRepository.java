package com.glauber.registerbooksapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glauber.registerbooksapi.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	// METODO PARA VERIFICAR SE O NOME DA CATEGORIA JA EXISTE
	boolean existsByNome(String nome);
}
