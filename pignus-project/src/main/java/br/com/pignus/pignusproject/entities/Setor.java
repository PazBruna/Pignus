package br.com.pignus.pignusproject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Setor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true, nullable = false)
	private String nomeSetor;
	@ManyToOne
	private Empresa empresa;
	@OneToOne
	private UsuarioGestor gestor;
	@ManyToMany
	@JoinTable(name = "setor_has_download", joinColumns = { @JoinColumn(name = "setor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "download_id") })
	private List<Download> softwaresSetor = new ArrayList<>();

	public UsuarioGestor getGestor() {
		return gestor;
	}

	public void setGestor(UsuarioGestor gestor) {
		this.gestor = gestor;
	}

	public List<Download> getSoftwaresSetor() {
		return softwaresSetor;
	}

	public void setSoftwaresprojeto(List<Download> softwaresSetor) {
		this.softwaresSetor = softwaresSetor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeSetor() {
		return this.nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public UsuarioGestor getUsuarioGestor() {
		return this.gestor;
	}

	public void setUsuarioGestor(UsuarioGestor gestor) {
		this.gestor = gestor;
	}
}