package br.com.pignus.pignusproject.entities;

import javax.persistence.Entity;

@Entity
public class Download {
	private String nomePrograma;
	private String categoria;
	private String link;
	private Setor setor;
	
	
	public String getNomePrograma() {
		return nomePrograma;
	}
	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}
