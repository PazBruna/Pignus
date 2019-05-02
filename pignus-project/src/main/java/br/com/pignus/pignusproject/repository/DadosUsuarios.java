package br.com.pignus.pignusproject.repository;

public class DadosUsuarios {
	
	
	public String[][] retornaMatrizUsuarios() {
		String matrizLogin[][] = new String[5][2];

		matrizLogin[0][0] = "teste@teste";
		matrizLogin[0][1] = "1234";

		matrizLogin[1][0] = "gui@teste";
		matrizLogin[1][1] = "4321";

		matrizLogin[2][0] = "bianca@teste";
		matrizLogin[2][1] = "eminem";

		matrizLogin[3][0] = "eu@meu";
		matrizLogin[3][1] = "nos";

		matrizLogin[4][0] = "gui@teste";
		matrizLogin[4][1] = "issoae";
		return matrizLogin;
	}

	
	
	
	
	
	
	
}