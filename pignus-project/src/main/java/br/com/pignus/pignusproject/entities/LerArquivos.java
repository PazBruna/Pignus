package br.com.pignus.pignusproject.entities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LerArquivos
{
   public static void main( String[] args )
   {
       Scanner sc= null;
        
       /* Abre o arquivo */
       try
       {
          sc = new Scanner(new FileReader("C:\\Users\\Bruno Carvalho\\Desktop\\salve.txt")).useDelimiter(";|\\r\\n");
       }
       catch ( FileNotFoundException fileNotFoundException )
       {
          System.err.println( "Erro ao abrir arquivo." );
          System.exit( 1 );
       }

       Usuario disc= new Usuario();
       
       /* Exibe os titulos das colunas */
       System.out.printf( "%-14s%-30s%-12s%-12s\n", "email","senha","nome","funcao");
      
       /* Tenta ler e exibir os dados do arquivo até encontrar o fim de arquivo */
       
       try // le dados do arquivo usando o Scanner
       {
          while ( sc.hasNext() )
          {
        	  disc.setNome( sc.next()); 
              disc.setSenha( sc.next()); 
              disc.setFuncao( sc.next()); 
              disc.setEmail( sc.next()); 
             
              
              // exibe os dados
        	  System.out.printf( "%-14s%-30s%-12s%-12s\n", disc.getNome(),
             		 disc.getSenha(), disc.getFuncao(), disc.getEmail());
          }
       }
       catch ( NoSuchElementException elementException )
       {
           System.err.println( "Arquivo com problemas." );
           sc.close();
           System.exit( 1 );
       }
       catch ( IllegalStateException stateException )
       {
           System.err.println( "Erro na leitura do arquivo." );
           System.exit( 1 );
       }
 
       /* Fecha o arquivo */
       if ( sc != null )
           sc.close();
   
   }
}

