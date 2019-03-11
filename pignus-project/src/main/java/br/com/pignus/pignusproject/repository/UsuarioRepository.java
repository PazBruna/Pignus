package br.com.pignus.pignusproject.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.pignus.pignusproject.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
