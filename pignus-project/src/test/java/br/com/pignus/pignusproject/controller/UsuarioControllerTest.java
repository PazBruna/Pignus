package br.com.pignus.pignusproject.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.entities.UsuarioAdmin;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioControllerTest {

	private Usuario usuarioComum;
	@Autowired
	private UsuarioController controller;

	@Before
	public void iniciar() {
		usuarioComum = new Usuario();

	}

	// TESTE DO EMAIL VALIDO
	@Test
	public void emailValido() {
		usuarioComum.setEmail("guilherme@guilherme.com");
		usuarioComum.setSenha("1234");
		Assert.assertEquals("paginaPrincipal", controller.loginEfetuado(usuarioComum));
	}

	// TESTE DO EMAIL INVALIDO
	@Test
	public void emailInvalido() {
		usuarioComum.setEmail("guilherm@guilherme.com");
		usuarioComum.setSenha("1234");
		Assert.assertEquals("paginaLoginErro", controller.loginEfetuado(usuarioComum));

	}

	// TESTE EMAIL E SENHA NULA
	@Test
	public void senhaNula() {
		usuarioComum.setEmail("guilherme@guilherme.com");
		usuarioComum.setSenha("");
		Assert.assertEquals("paginaLoginErro", controller.loginEfetuado(usuarioComum));
	}

	// TESTE EMAIL NULA E SENHA VALIDA

	@Test
	public void emailNula() {
		usuarioComum.setEmail("");
		usuarioComum.setSenha("1234");
		Assert.assertEquals("paginaLoginErro", controller.loginEfetuado(usuarioComum));
	}

	@Test
	public void cadastrarUsuario() {
		UsuarioAdmin usuario = new UsuarioAdmin();
		usuario.setNome("Guilherme Faria");
		usuario.setEmail("guilherme.faria@gui.com");
		usuario.setSenha("1234");
		usuario.setSetor(1);
		usuario.setBairro("Jd. N sei");
		usuario.setCep("14525412422");
		usuario.setCnpj("15454454");
		usuario.setComplemento("sasdsa");
		usuario.setNomeFantasia("dasd");
		usuario.setNumero("23-b");
		usuario.setRua("Rua dos alfeneiros");
		usuario.setEstado("Eu");

		Assert.assertEquals("redirect:login", controller.cadastrarUsuarioAdmin(usuario));

	}

}
