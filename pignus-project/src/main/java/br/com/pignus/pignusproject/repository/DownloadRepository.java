package br.com.pignus.pignusproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pignus.pignusproject.entities.Download;

public interface DownloadRepository extends JpaRepository<Download, Integer> {

}
