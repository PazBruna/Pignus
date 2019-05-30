package br.com.pignus.pignusproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.pignus.pignusproject.entities.Download;
import br.com.pignus.pignusproject.entities.Funcoes;
import br.com.pignus.pignusproject.entities.Setor;

public interface DownloadRepository extends JpaRepository<Download, Integer> {
	@Query("From Download")
	public List<Download> findAllByFuncaoAndSetor(Funcoes funcaoUsuario, Setor setor);
	@Query("From Download where funcao_download_id = ?1")
	public List<Download> findAllByFuncaoDownload(Funcoes funcaoUsuario);
	@Query("From Download where nomePrograma = ?1")
	public String findByNome(String nomePrograma);
	@Query("From Download where link = ?1")
	public String findByLink(String link);
	@Query("From Download")
	public List<Download> findAllById(int id);
	

}
