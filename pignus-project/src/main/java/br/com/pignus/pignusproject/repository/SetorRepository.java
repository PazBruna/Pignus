package br.com.pignus.pignusproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pignus.pignusproject.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer>{
	

	
    
}