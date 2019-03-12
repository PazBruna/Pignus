package br.com.pignus.pignusproject.infra;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import br.com.pignus.pignusproject.repository.DadosUsuarios;

@Component
public class SegurancaDaAplicacao {
	DadosUsuarios dados = new DadosUsuarios();
	String matrizLogin[][] = dados.retornaMatrizUsuarios();
	String[][] matrizLog = new String[10][2];

	public Boolean permitirAcesso(String email, String senha) {

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

	public String[][] adicionaMatrizLog(String email) {
		for (int i = 0; i < matrizLog.length; i++) {
			if (matrizLog[i][0] == null) {
				matrizLog[i][0] = email;
			} 
			for (int j = 1; j < matrizLog[0].length;) {
				if (matrizLog[i][j] == null) {
					matrizLog[i][j] = Calendar.getInstance().toString();
					break;
				} 
			}
			break;
		}
		System.out.println("Histórico de acesso: ");
		
		for (int i = 0; i < matrizLog.length; i++) {
		
			for (int j = 0; j < matrizLog[0].length; j++) {
				System.out.println(matrizLog[i][j]);
			}
			System.out.println();
		} 
		return matrizLog;
	}

}
