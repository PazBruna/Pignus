package br.com.pignus.pignusproject.entities;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Projetos {
	private String nomeProjeto;
	private String clienteDoProjeto;
	private String descricaoProjeto;
	private Setor setor;
	private List<Download> softwaresprojeto;
	private List<Usuario> integrantesDoProjeto;

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getClienteDoProjeto() {
		return clienteDoProjeto;
	}

	public void setClienteDoProjeto(String clienteDoProjeto) {
		this.clienteDoProjeto = clienteDoProjeto;
	}

	public String getDescricaoProjeto() {
		return descricaoProjeto;
	}

	public void setDescricaoProjeto(String descricaoProjeto) {
		this.descricaoProjeto = descricaoProjeto;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public List<Download> getSoftwaresprojeto() {
		return softwaresprojeto;
	}

	public void setSoftwaresprojeto(List<Download> softwaresprojeto) {
		this.softwaresprojeto = softwaresprojeto;
	}

	public List<Usuario> getIntegrantesDoProjeto() {
		return integrantesDoProjeto;
	}

	public void setIntegrantesDoProjeto(List<Usuario> integrantesDoProjeto) {
		this.integrantesDoProjeto = integrantesDoProjeto;
	}

}
