package br.com.pignus.pignusproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pignus.pignusproject.entities.Funcoes;

public interface FuncaoRepository extends JpaRepository<Funcoes, Integer>{

	@Query("from Funcoes")
	List<Funcoes> findAllByNome(String nomeFuncao);

}
