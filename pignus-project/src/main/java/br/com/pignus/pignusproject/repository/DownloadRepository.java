package br.com.pignus.pignusproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.pignus.pignusproject.entities.Download;
import br.com.pignus.pignusproject.entities.Funcoes;
import br.com.pignus.pignusproject.entities.Setor;

public interface DownloadRepository extends JpaRepository<Download, Integer> {
	@Query("From Download")
	public List<Download> findByFuncaoAndSetor(Funcoes funcaoUsuario, Setor setor);

}
