package br.com.pignus.pignusproject.entities;

public class UsuarioGestor extends Usuario{
	private String cnpj;
	private final int tipo = 2;

	public UsuarioGestor(String email, String senha, String nome, String endereco) {
		super(email, senha, nome, endereco);
		// TODO Auto-generated constructor stub
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public int getTipo() {
		return tipo;
	}

	
	
	

}
