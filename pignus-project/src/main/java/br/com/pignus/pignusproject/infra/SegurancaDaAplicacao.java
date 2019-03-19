package br.com.pignus.pignusproject.infra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

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
			if (matrizLogin[i][1].equals(senha)) {
				respostaSenha = true;
			}
			/*for (int j = 0; j < matrizLogin[0].length; j++) {
				if (matrizLogin[i][j].equals(senha)) {
					respostaSenha = true;
					break;
				}
			}*/
			if (respostaEmail && respostaSenha) {
				resposta = true;
				break;
			}
		}
		return resposta;
	}

	public static String[][] exibeHistorico(String[][] m) {
		System.out.println("");
		System.out.println("Histórico de acesso: ");
		for (int linha = 0; linha < m.length; linha++) {
			for (int coluna = 0; coluna < m[linha].length; coluna++) {
				System.out.println("");
				System.out.print(m[linha][coluna] + "\t");
			}
			System.out.println("");
		}
		return m;

	}

	public String[][] adicionaMatrizLog(String email) {
		for (int i = 0; i < matrizLog.length; i++) {
			if (matrizLog[i][0] == null) {
				DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
						.withLocale(new Locale("pt", "br"));
				matrizLog[i][0] = email;
				matrizLog[i][1] = LocalDateTime.now().format(formatador);
				break;
				
			} 

		
		}

		return exibeHistorico(matrizLog);
	}

}
