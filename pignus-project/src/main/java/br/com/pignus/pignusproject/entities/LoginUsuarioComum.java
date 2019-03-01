package br.com.pignus.pignusproject.entities;

public class LoginUsuarioComum {
	
	String email;
	String senha;
	String nome;
	String endereco;
	public LoginUsuarioComum(String email, String senha, String nome, String endereco) {
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
	
	
	
	

}