package br.com.pignus.pignusproject.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.server.RestartServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.pignus.pignusproject.entities.Empresa;
import br.com.pignus.pignusproject.entities.Funcoes;
import br.com.pignus.pignusproject.entities.Setor;
import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.entities.UsuarioGestor;

@Transactional
@Commit
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private EmpresaRepository er;
	@Autowired
	private SetorRepository sr;
	@Autowired
	private FuncaoRepository fc;
	private Empresa empresa;
	
	Funcoes funcao = new Funcoes();
	Funcoes funcao1 = new Funcoes();
	Funcoes funcao2 = new Funcoes();
	Funcoes funcao3 = new Funcoes();

	//@Test
	public void criarNovoSetor() {
		Setor setor = new Setor();
		Empresa empresa = er.getOne(1);
	
		setor.setNomeSetor("IBM");
		setor.setEmpresa(empresa);
		
		sr.save(setor);
	}

	//@Test
	public void criarNovoUsuarioGestor() {
		Setor setor = sr.getOne(2);
		UsuarioGestor usuario = new UsuarioGestor();
		usuario.setNome("Guilherme");
		usuario.setEmail("guilherme@guilherme.com");
		usuario.setSenha("1234");
		usuario.setSetor(setor);

		ur.save(usuario);

		UsuarioGestor usuarioCriado = (UsuarioGestor) ur.getOne(usuario.getId());
		Assert.assertEquals(usuario, usuarioCriado);

	}

	//@Test
	public void loginValido() {
		Assert.assertEquals(true, ur.existsByEmailAndSenha("guilherme@guilherme.com", "1234"));

	}
	
	
	//@Test
	public void MassaDeDadosGestor () {
		funcao = fc.getOne(5);
		empresa = er.getOne(1);
		
		//CRIACAO DOS USUARIOS GESTORES
		
		Usuario testeGestores1 = new UsuarioGestor();
		Setor setor = sr.getOne(2);
		
		
		testeGestores1.setEmail("Ariel@Ariel");
		testeGestores1.setNome("Ariel");
		testeGestores1.setFuncaoUsuario(funcao);
		testeGestores1.setEmpresa(empresa);
		testeGestores1.setSenha("01010101");
		
		
		ur.save(testeGestores1);
		
		Usuario gestorCriado = ur.getOne(testeGestores1.getId());
		
		Assert.assertEquals(testeGestores1,gestorCriado);
		
Usuario testeGestores2 = new UsuarioGestor();

		
		testeGestores2.setEmail("Jose@Jose");
		testeGestores2.setNome("Jose");
		testeGestores2.setFuncaoUsuario(funcao);
		testeGestores2.setEmpresa(empresa);
		testeGestores2.setSenha("02020202");
		
		
		ur.save(testeGestores2);
		
		Usuario gestorCriado2 = ur.getOne(testeGestores2.getId());
		
		Assert.assertEquals(testeGestores2,gestorCriado2);
		
Usuario testeGestores3 = new UsuarioGestor();
		
		
		testeGestores3.setEmail("Luciano@Luciano");
		testeGestores3.setNome("Luciano");
		testeGestores3.setFuncaoUsuario(funcao);
		testeGestores3.setEmpresa(empresa);
		testeGestores3.setSenha("testeLuciano");
		
		ur.save(testeGestores3);
		
		Usuario gestorCriado3 = ur.getOne(testeGestores3.getId());
		
		Assert.assertEquals(testeGestores3,gestorCriado3);
		
Usuario testeGestores4 = new UsuarioGestor();
		
		
		testeGestores4.setEmail("Cristino@Cristino");
		testeGestores4.setNome("Cristino");
		testeGestores4.setFuncaoUsuario(funcao);
		testeGestores4.setEmpresa(empresa);
		testeGestores4.setSenha("04040404");
		
		
		ur.save(testeGestores4);
		
		Usuario gestorCriado4 = ur.getOne(testeGestores4.getId());
		
		Assert.assertEquals(testeGestores4,gestorCriado4);
		
Usuario testeGestores5 = new UsuarioGestor();
			
		
		testeGestores5.setEmail("Santana@Santana");
		testeGestores5.setNome("Santana");
		testeGestores5.setFuncaoUsuario(funcao);
		testeGestores5.setEmpresa(empresa);
		testeGestores5.setSenha("0505050505");
		
		
		ur.save(testeGestores5);
		
		Usuario gestorCriado5 = ur.getOne(testeGestores1.getId());
		
		Assert.assertEquals(testeGestores1,gestorCriado5);
		
		
	}
	
	//CRIACAO DOS USUARIOSO COMUNS

	  @Test
	public void MassaDeDadosUsuario () {
		Usuario testeUsuarioComum1 = new Usuario();
		Setor setor = sr.getOne(11);
		Setor setor2 = sr.getOne(12);
		funcao1 = fc.getOne(2);
		funcao2 = fc.getOne(3);
		funcao3 = fc.getOne(4);
		empresa = er.getOne(1);
		
		testeUsuarioComum1.setEmail("gustavo@gmail.com");
		testeUsuarioComum1.setNome("Gustavo");
		testeUsuarioComum1.setSetor(setor);
		testeUsuarioComum1.setSenha("gustavo123");
		testeUsuarioComum1.setFuncaoUsuario(funcao1);
		testeUsuarioComum1.setEmpresa(empresa);
		
		ur.save(testeUsuarioComum1);
		
		
//		Usuario usuarioCriado1 = ur.getOne(testeUsuarioComum1.getId());
//		
//		Assert.assertEquals(testeUsuarioComum1,usuarioCriado1);
		
	Usuario testeUsuarioComum2 = new Usuario();
		
		testeUsuarioComum2.setEmail("sendy@gmail.com");
		testeUsuarioComum2.setNome("Sendy");
		testeUsuarioComum2.setSetor(setor2);
		testeUsuarioComum2.setSenha("sendy123");
		testeUsuarioComum2.setFuncaoUsuario(funcao2);
		testeUsuarioComum2.setEmpresa(empresa);
		
		ur.save(testeUsuarioComum2);
		
//		Usuario usuarioCriado2 = ur.getOne(testeUsuarioComum2.getId());
//		
//		Assert.assertEquals(testeUsuarioComum2,usuarioCriado2);
		
		
	Usuario testeUsuarioComum3 = new Usuario();
		
		testeUsuarioComum3.setEmail("breno@gmail.com");
		testeUsuarioComum3.setNome("Breno");
		testeUsuarioComum3.setSetor(setor);
		testeUsuarioComum3.setSenha("breno123");
		testeUsuarioComum3.setEmpresa(empresa);
		testeUsuarioComum3.setFuncaoUsuario(funcao3);
		
		ur.save(testeUsuarioComum3);
		
//		Usuario usuarioCriado3 = ur.getOne(testeUsuarioComum3.getId());
//		
//		Assert.assertEquals(testeUsuarioComum3,usuarioCriado3);

	Usuario testeUsuarioComum4 = new Usuario();
		
		testeUsuarioComum4.setEmail("marcia@gmail.com");
		testeUsuarioComum4.setNome("Marcia");
		testeUsuarioComum4.setSetor(setor2);
		testeUsuarioComum4.setSenha("marcia123");
		testeUsuarioComum4.setEmpresa(empresa);
		testeUsuarioComum4.setFuncaoUsuario(funcao1);
		
		ur.save(testeUsuarioComum4);
		
//		Usuario usuarioCriado4 = ur.getOne(testeUsuarioComum4.getId());
//		
//		Assert.assertEquals(testeUsuarioComum4,usuarioCriado4);

		
	Usuario testeUsuarioComum5 = new Usuario();
		
		testeUsuarioComum5.setEmail("alexandro@gmail.com");
		testeUsuarioComum5.setNome("Alexandro");
		testeUsuarioComum5.setSetor(setor);
		testeUsuarioComum5.setSenha("alexandro123");
		testeUsuarioComum5.setEmpresa(empresa);
		testeUsuarioComum5.setFuncaoUsuario(funcao2);
		
		ur.save(testeUsuarioComum5);
		
//		Usuario usuarioCriado5 = ur.getOne(testeUsuarioComum5.getId());
//		
//		Assert.assertEquals(testeUsuarioComum5,usuarioCriado5);

	}
	  
	  //@Test
	  public void criandoFuncao() {
		  
		  Funcoes funcao1 = new Funcoes();
		  Funcoes funcao2 = new Funcoes();
		  Funcoes funcao3 = new Funcoes();
		  Funcoes funcaoPadrao = new Funcoes();
		  
		  funcao1.setNomeFuncao("Desenvolvedor");
		  fc.save(funcao1);
		  Funcoes funcaoCriada1 = fc.getOne(funcao1.getId());
		  Assert.assertEquals(funcao1,funcaoCriada1);
		  
		  funcao2.setNomeFuncao("Arquiteto");
		  fc.save(funcao2);
		  Funcoes funcaoCriada2 = fc.getOne(funcao2.getId());
		  Assert.assertEquals(funcao2,funcaoCriada2);
		  
		  funcao3.setNomeFuncao("Designer");
		  fc.save(funcao3);
		  Funcoes funcaoCriada3 = fc.getOne(funcao3.getId());
		  Assert.assertEquals(funcao3,funcaoCriada3);
		  
		  funcaoPadrao.setNomeFuncao("Padrão");
		  fc.save(funcaoPadrao);
		  Funcoes funcaoPadraoCriada = fc.getOne(funcaoPadrao.getId());
		  Assert.assertEquals(funcaoPadrao,funcaoPadraoCriada);
		  
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
