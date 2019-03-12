package br.com.pignus.pignusproject.infra;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pignus.pignusproject.entities.Usuario;


public class SegurancaDaAplicacaoTest {
	Usuario usuario;
	SegurancaDaAplicacao seguranca;
	String matriz[][] ;

	@Before
	public void iniciar() {
		usuario = new Usuario();
		seguranca = new SegurancaDaAplicacao();

	}

	@Test
	public void loginCorreto() {
		usuario.setEmail("teste@teste");
		usuario.setSenha("1234");
		
		Assert.assertEquals(true,seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha()));
	}
	
	@Test
	public void loginErrado() {
		usuario.setEmail("");
		usuario.setSenha("");
		
		Assert.assertEquals(false,seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha()));
	}
	
	@Test
	public void emailErrado() {
		usuario.setEmail("teste@teste");
		usuario.setSenha("12341");
		
		Assert.assertEquals(false,seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha()));
	}
	
	@Test
	public void senhaErrada() {
		usuario.setEmail("teste1@teste");
		usuario.setSenha("1234");
		
		Assert.assertEquals(false,seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha()));
	}
	
	@Test
	public void gerarLog() {
		usuario.setEmail("bbb@gmail.com");
		matriz = seguranca.adicionaMatrizLog(usuario.getEmail());
	}
	

}
