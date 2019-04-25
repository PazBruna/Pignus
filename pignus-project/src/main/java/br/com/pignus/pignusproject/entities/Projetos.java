package br.com.pignus.pignusproject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projetos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nomeProjeto;
	private String clienteDoProjeto;
	private String descricaoProjeto;
	@ManyToOne
	private Setor setor;
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Download> softwaresProjeto = new ArrayList<>();
	@ManyToMany
	@JoinTable(name = "projeto_has_usuario", joinColumns = { @JoinColumn(name = "projeto_id") }, inverseJoinColumns = {
			@JoinColumn(name = "usuario_id") })
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

	public List<Download> getSoftwaresProjeto() {
		return softwaresProjeto;
	}

	public void setSoftwaresProjeto(List<Download> softwaresProjeto) {
		this.softwaresProjeto = softwaresProjeto;
	}

	public List<Usuario> getIntegrantesDoProjeto() {
		return integrantesDoProjeto;
	}

	public void setIntegrantesDoProjeto(List<Usuario> integrantesDoProjeto) {
		this.integrantesDoProjeto = integrantesDoProjeto;
	}

}
