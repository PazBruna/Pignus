package br.com.pignus.pignusproject.entities;

public class UsuarioGestor extends Usuario {

	public UsuarioGestor() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int areaGerenciada;
	private final int tipo = 2;

	@Override
	public int getTipo() {
		return tipo;
	}

	public int getAreaGerenciada() {
		return areaGerenciada;
	}

	public void setAreaGerenciada(int areaGerenciada) {
		this.areaGerenciada = areaGerenciada;
	}

}
