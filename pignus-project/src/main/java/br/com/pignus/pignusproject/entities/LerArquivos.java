package br.com.pignus.pignusproject.entities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pignus.pignusproject.repository.FuncaoRepository;

@Component
public class LerArquivos {
	@Autowired
	private FuncaoRepository fc;
	Funcoes funcao = new Funcoes();
	
	
	public List<Download> listaDownloads() {
		{
			Scanner sc = null;
			List<Download> lista = new ArrayList<>();
			
			/* Abre o arquivo */
			try {
				sc = new Scanner(new FileReader("download.csv")).useDelimiter(";|\\r\\n");
			} catch (FileNotFoundException fileNotFoundException) {
				System.err.println("Erro ao abrir arquivo.");
				System.exit(1);
			}

			/* Exibe os titulos das colunas */
			System.out.printf("%-14s%-30s%-12s%-12s\n", "nomePrograma", "categoria", "link","id");

			/* Tenta ler e exibir os dados do arquivo até encontrar o fim de arquivo */

			try // le dados do arquivo usando o Scanner
			{
				
				while (sc.hasNext()) {
					Download disc = new Download();
					disc.setNomePrograma(sc.next());
					disc.setLink(sc.next());
					funcao.setId(sc.nextInt());
					Funcoes novaFuncao =fc.getOne(funcao.getId());
				
					disc.setFuncaoDownload(novaFuncao);
					lista.add(disc);
					
					
				}
				return lista;

			} catch (NoSuchElementException elementException) {
				System.err.println("Arquivo com problemas.");
				sc.close();
				System.exit(1);
			} catch (IllegalStateException stateException) {
				System.err.println("Erro na leitura do arquivo.");
				System.exit(1);
			}

			/* Fecha o arquivo */
			if (sc != null) {
				sc.close();
			}
			
		}
		return null;
	}
}