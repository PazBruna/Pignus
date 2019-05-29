package br.com.pignus.pignusproject.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pignus.pignusproject.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>{

	@Query("from Setor")
	List<Setor> findByNome(String nomeSetor);

	@Query ("from Setor")
	List<Setor> findAllById(int id);

	

	
    
}