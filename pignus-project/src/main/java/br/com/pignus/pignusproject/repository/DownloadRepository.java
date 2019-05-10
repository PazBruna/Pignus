package br.com.pignus.pignusproject.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.com.pignus.pignusproject.entities.Download;
import br.com.pignus.pignusproject.entities.LerArquivos;
public interface DownloadRepository extends JpaRepository<Download, Integer> {


	List<String> existsByNomePrograma(String nomePrograma);
	void save(LerArquivos ler);

}
