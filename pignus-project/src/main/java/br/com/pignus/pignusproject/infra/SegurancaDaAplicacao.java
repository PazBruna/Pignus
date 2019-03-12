package br.com.pignus.pignusproject.infra;

import org.springframework.stereotype.Component;

import br.com.pignus.pignusproject.repository.DadosUsuarios;

@Component
public class SegurancaDaAplicacao {
	DadosUsuarios dados = new DadosUsuarios();
	
	

	public Boolean permitirAcesso(String email, String senha) {
		String matrizLogin[][] = dados.retornaMatriz();
		boolean resposta = false;
		boolean respostaEmail = false;
		boolean respostaSenha = false;
		
		for (int i = 0; i < matrizLogin.length; i++) {
			
			if (matrizLogin[i][0].equals(email)) {
				respostaEmail = true;
			}
			for (int j = 0; j < matrizLogin[0].length; j++) {
				if (matrizLogin[i][j].equals(senha)) {
					respostaSenha = true;
					break;
				}
			}
			if (respostaEmail && respostaSenha) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}
}
