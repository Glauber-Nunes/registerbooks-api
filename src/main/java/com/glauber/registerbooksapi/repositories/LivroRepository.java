package com.glauber.registerbooksapi.repositories;

import com.glauber.registerbooksapi.domain.Livro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY id")
	List<Livro> findAllLivroPerCategoria(@Param(value = "id_cat") Long id_cat);
}
