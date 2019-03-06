package br.com.pignus.pignusproject.entities;

public class Usuario {
	private int id;
	private String email;
	private String senha;
	private String nome;
	private String endereco;
	private final int tipo = 1;
	public Usuario(String email, String senha, String nome, String endereco) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.endereco = endereco;
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
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	
	
	
	

}