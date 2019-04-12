package br.com.pignus.pignusproject.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.entities.UsuarioGestor;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository ur;

	// @Test
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

	// @Test
	public void criarNovoUsuarioGestor() {
		UsuarioGestor usuario = new UsuarioGestor();
		usuario.setNome("Guilherme");
		usuario.setEmail("guilherme@guilherme.com");
		usuario.setSenha("1234");
		usuario.setSetor(1);

		ur.save(usuario);

		UsuarioGestor usuarioCriado = (UsuarioGestor) ur.getOne(usuario.getId());
		Assert.assertEquals(usuario, usuarioCriado);

	}

	@Test
	public void loginValido() {
		Assert.assertEquals(true, ur.existsByEmailAndSenha("guilherme@guilherme.com", "1234"));

	}
	
	
	@Test
	public void MassaDeDAdosGestor () {
		
		//CRIACAO DOS USUARIOS GESTORES
		
		Usuario testeGestores1 = new UsuarioGestor();
		
		
		testeGestores1.setEmail("Ariel@Ariel");
		testeGestores1.setNome("Ariel");
		testeGestores1.setSetor(0101);
		testeGestores1.setFuncao("Dev");
		testeGestores1.setSenha("01010101");
		
		
		ur.save(testeGestores1);
		
		Usuario gestorCriado = ur.getOne(testeGestores1.getId());
		
		Assert.assertEquals(testeGestores1,gestorCriado);
		
Usuario testeGestores2 = new UsuarioGestor();
		
		
		testeGestores2.setEmail("Jose@Jose");
		testeGestores2.setNome("Jose");
		testeGestores2.setSetor(02020);
		testeGestores2.setFuncao("Negocios");
		testeGestores2.setSenha("02020202");
		
		
		ur.save(testeGestores2);
		
		Usuario gestorCriado2 = ur.getOne(testeGestores2.getId());
		
		Assert.assertEquals(testeGestores2,gestorCriado2);
		
Usuario testeGestores3 = new UsuarioGestor();
		
		
		testeGestores3.setEmail("Luciano@Luciano");
		testeGestores3.setNome("Luciano");
		testeGestores3.setSetor(0303);
		testeGestores3.setFuncao("Limpeza");
		testeGestores3.setSenha("030303030");
		
		
		ur.save(testeGestores3);
		
		Usuario gestorCriado3 = ur.getOne(testeGestores3.getId());
		
		Assert.assertEquals(testeGestores3,gestorCriado3);
		
Usuario testeGestores4 = new UsuarioGestor();
		
		
		testeGestores4.setEmail("Cristino@Cristino");
		testeGestores4.setNome("Cristino");
		testeGestores4.setSetor(0404);
		testeGestores4.setFuncao("RH");
		testeGestores4.setSenha("04040404");
		
		
		ur.save(testeGestores4);
		
		Usuario gestorCriado4 = ur.getOne(testeGestores4.getId());
		
		Assert.assertEquals(testeGestores4,gestorCriado4);
		
Usuario testeGestores5 = new UsuarioGestor();
		
		
		testeGestores5.setEmail("Santana@Santana");
		testeGestores5.setNome("Santana");
		testeGestores5.setSetor(0505);
		testeGestores5.setFuncao("Financas");
		testeGestores5.setSenha("0505050505");
		
		
		ur.save(testeGestores5);
		
		Usuario gestorCriado5 = ur.getOne(testeGestores1.getId());
		
		Assert.assertEquals(testeGestores1,gestorCriado5);
		
		
	}
	
	//CRIACAO DOS USUARIOSO COMUNS

	  @Test
	public void MassaDeDadosUsuario () {
		Usuario testeUsuarioComum1 = new Usuario();
		
		testeUsuarioComum1.setEmail("Gustavo@Gustavo");
		testeUsuarioComum1.setNome("Gustavo");
		testeUsuarioComum1.setSetor(0606);
		testeUsuarioComum1.setFuncao("Comprador");
		testeUsuarioComum1.setSenha("06060606");
		
		ur.save(testeUsuarioComum1);
		
		
		Usuario usuarioCriado1 = ur.getOne(testeUsuarioComum1.getId());
		
		Assert.assertEquals(testeUsuarioComum1,usuarioCriado1);
		
	Usuario testeUsuarioComum2 = new Usuario();
		
		testeUsuarioComum2.setEmail("Sendy@Sendy");
		testeUsuarioComum2.setNome("Sendy");
		testeUsuarioComum1.setSetor(0707);
		testeUsuarioComum1.setFuncao("UI");
		testeUsuarioComum2.setSenha("07070707");
		
		ur.save(testeUsuarioComum2);
		
		Usuario usuarioCriado2 = ur.getOne(testeUsuarioComum2.getId());
		
		Assert.assertEquals(testeUsuarioComum2,usuarioCriado2);
		
		
	Usuario testeUsuarioComum3 = new Usuario();
		
		testeUsuarioComum3.setEmail("Breno@Breno");
		testeUsuarioComum3.setNome("Breno");
		testeUsuarioComum3.setSetor(8080);
		testeUsuarioComum3.setFuncao("Comercial");
		testeUsuarioComum3.setSenha("8080808080");
		
		ur.save(testeUsuarioComum3);
		
		Usuario usuarioCriado3 = ur.getOne(testeUsuarioComum3.getId());
		
		Assert.assertEquals(testeUsuarioComum3,usuarioCriado3);

	Usuario testeUsuarioComum4 = new Usuario();
		
		testeUsuarioComum4.setEmail("Marcia@Marcia");
		testeUsuarioComum4.setNome("Marcia");
		testeUsuarioComum4.setSetor(9090);
		testeUsuarioComum4.setFuncao("Limpeza");
		testeUsuarioComum4.setSenha("90909090");
		
		ur.save(testeUsuarioComum4);
		
		Usuario usuarioCriado4 = ur.getOne(testeUsuarioComum4.getId());
		
		Assert.assertEquals(testeUsuarioComum4,usuarioCriado4);

		
	Usuario testeUsuarioComum5 = new Usuario();
		
		testeUsuarioComum5.setEmail("Alexandro@Alexandro");
		testeUsuarioComum5.setNome("Alexandro");
		testeUsuarioComum5.setSetor(100100);
		testeUsuarioComum5.setFuncao("Manutencao");
		testeUsuarioComum5.setSenha("100100100100");
		
		ur.save(testeUsuarioComum5);
		
		Usuario usuarioCriado5 = ur.getOne(testeUsuarioComum5.getId());
		
		Assert.assertEquals(testeUsuarioComum5,usuarioCriado5);

	}
	  
/*	@Test
	public String[][] retornaMatrizUsuarios() {
		
		String matrizLogin[][] = new String[5][2];
		
		
		for (int i = 0; i < matrizLogin.length; i++) {
			if (matrizLogin[i][0] == null) {

				matrizLogin[i][0] = MassaDeDAdosGestor();
				matrizLogin[i][1] = Mas
				break;

			}

		}
	}*/
	  

}
