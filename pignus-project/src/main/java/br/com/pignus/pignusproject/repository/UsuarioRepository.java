package br.com.pignus.pignusproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pignus.pignusproject.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
