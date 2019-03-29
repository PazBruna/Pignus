package br.com.pignus.pignusproject.infra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pignus.pignusproject.repository.UsuarioRepository;

@Component
public class SegurancaDaAplicacao {
	String[][] matrizLog = new String[10][2];
	@Autowired
	UsuarioRepository usuarios;

	public boolean permitirAcesso(String email, String senha) {
		
		if (usuarios.existsByEmailAndSenha(email, senha)) {
			return true;
		}
		return false;
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
