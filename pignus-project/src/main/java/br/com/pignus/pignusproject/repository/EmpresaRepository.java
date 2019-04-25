package br.com.pignus.pignusproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pignus.pignusproject.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	public boolean existsByEmailAndSenha(String email, String senha);

	public Empresa findByEmail(String email);

}
