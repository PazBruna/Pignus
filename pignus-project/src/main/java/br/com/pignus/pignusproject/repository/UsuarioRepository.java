package br.com.pignus.pignusproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.entities.UsuarioGestor;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public boolean existsByEmailAndSenha(String email, String senha);

	public Usuario findByEmail(String email);
	
	//Buscando na Tabela
	@Query("from Usuario")
	public UsuarioGestor findByNomeGestor(String nome);
	
	@Query("from Usuario")
	public List<Usuario> findAllByTipo(String tipo);

	@Query("select nome from Usuario where nome = ?1 ")
	public Usuario findByNome(String nome);

}
