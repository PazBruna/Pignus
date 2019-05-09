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
          sc = new Scanner(new FileReader("testeCsv.csv")).useDelimiter(";|\\r\\n");
       }
       catch ( FileNotFoundException fileNotFoundException )
       {
          System.err.println( "Erro ao abrir arquivo." );
          System.exit( 1 );
       }

       Download disc= new Download();
       
       /* Exibe os titulos das colunas */
       System.out.printf( "%-14s%-30s%-12s\n", "nomePrograma","categoria","link");
      
       /* Tenta ler e exibir os dados do arquivo até encontrar o fim de arquivo */
       
       try // le dados do arquivo usando o Scanner
       {
          while ( sc.hasNext() )
          {
        	  disc.setNomePrograma( sc.next()); 
              disc.setCategoria( sc.next()); 
              disc.setLink( sc.next()); 
             
              // exibe os dados
        	  System.out.printf( "%-14s%-30s%-12s\n", disc.getNomePrograma(),
             		 disc.getCategoria(), disc.getLink());
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
       
