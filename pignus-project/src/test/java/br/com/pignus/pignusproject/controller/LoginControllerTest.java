package br.com.pignus.pignusproject.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;

public class LoginControllerTest {

	Usuario usuarioComum;

	private LoginController controller;
	private SegurancaDaAplicacao seguranca = Mockito.mock(SegurancaDaAplicacao.class);

	@Before
	public void iniciar() {
		controller = new LoginController(seguranca);
		usuarioComum = new Usuario();
		usuarioComum.setEmail("email");
		usuarioComum.setSenha("senha");
	}

	// TESTE DO EMAIL VALIDO
	@Test
	public void emailValido() {
		Mockito.when(seguranca.permitirAcesso(usuarioComum.getEmail(),usuarioComum.getSenha())).thenReturn(true);
		Assert.assertEquals("paginaPrincipal", controller.loginEfetuado(usuarioComum));

	}

	// TESTE DO EMAIL INVALIDO
	@Test
	public void emailInvalido() {
		Mockito.when(seguranca.permitirAcesso(usuarioComum.getEmail(),usuarioComum.getSenha())).thenReturn(false);
		Assert.assertEquals("paginaLoginErro", controller.loginEfetuado(usuarioComum));

	}

	// TESTE EMAIL E SENHA NULA  
	@Test
	public void senhaNula() {
		Mockito.when(seguranca.permitirAcesso(usuarioComum.getEmail(),usuarioComum.getSenha())).thenReturn(false);
		Assert.assertEquals("paginaLoginErro", controller.loginEfetuado(usuarioComum));
	}
	

	// TESTE EMAIL NULA E SENHA VALIDA

	@Test
	public void emailNula() {
		Mockito.when(seguranca.permitirAcesso(usuarioComum.getEmail(),usuarioComum.getSenha())).thenReturn(false);
		Assert.assertEquals("paginaLoginErro", controller.loginEfetuado(usuarioComum));
	}
	

}
