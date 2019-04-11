package br.com.pignus.pignusproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pignus.pignusproject.entities.Empresa;
import br.com.pignus.pignusproject.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public boolean existsByEmailAndSenha(String email,String senha);
	public Usuario findByEmail(String email);
	
	
}
