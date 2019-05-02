package br.com.pignus.pignusproject.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("C")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true, nullable = false)
	private String email;
	private String senha;
	private String nome;
	private String funcao;
	@ManyToOne
	private Empresa empresa;
	@ManyToOne
	private Setor setor;
	@Column(insertable = false, updatable = false)
	private String tipo;
	@ManyToMany
	@JoinTable(name = "usuario_has_downloads", joinColumns = {
			@JoinColumn(name = "usuario_id") }, inverseJoinColumns = { @JoinColumn(name = "download_id") })
	private List<Download> downloadsUsuario = new ArrayList<>();

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Download> getDownloadsUsuario() {
		return downloadsUsuario;
	}

	public void setDownloadsUsuario(List<Download> downloadsUsuario) {
		this.downloadsUsuario = downloadsUsuario;
	}

	public void setFuncao(int nextInt) {
		// TODO Auto-generated method stub
		
	}

}