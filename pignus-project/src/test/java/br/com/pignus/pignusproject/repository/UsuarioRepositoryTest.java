package br.com.pignus.pignusproject.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.entities.UsuarioAdmin;
import br.com.pignus.pignusproject.entities.UsuarioGestor;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository ur;

	//@Test
	public void criarNovoUsuarioComum() {
		Usuario usuario = new Usuario();
		usuario.setNome("Guilherme");
		usuario.setEmail("guilherme@guilherme.com");
		usuario.setSenha("1234");
		usuario.setSetor(1);

		ur.save(usuario);

		Usuario usuarioCriado = ur.getOne(usuario.getId());
		Assert.assertEquals(usuario, usuarioCriado);

	}
	
	//@Test
	public void criarNovoUsuarioAdmin() {
		UsuarioAdmin usuario = new UsuarioAdmin();
		usuario.setNome("Guilherme");
		usuario.setEmail("guilherme@guilherme.com");
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

		ur.save(usuario);

		UsuarioAdmin usuarioCriado = (UsuarioAdmin) ur.getOne(usuario.getId());
		Assert.assertEquals(usuario, usuarioCriado);

	}
	
	//@Test
	public void criarNovoUsuarioGestor() {
		UsuarioGestor usuario = new UsuarioGestor();
		usuario.setNome("Guilherme");
		usuario.setEmail("guilherme@guilherme.com");
		usuario.setSenha("1234");
		usuario.setSetor(1);
		usuario.setAreaGerenciada(1);

		ur.save(usuario);

		UsuarioGestor usuarioCriado = (UsuarioGestor) ur.getOne(usuario.getId());
		Assert.assertEquals(usuario, usuarioCriado);

	}
	@Test
	public void loginValido() {
		Assert.assertEquals(true ,ur.existsByEmailAndSenha("guilherme@guilherme.com", "1234"));
		
	}

}
