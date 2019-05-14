package br.com.pignus.pignusproject.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
		Funcoes funcao = new Funcoes();
		
		//CRIACAO DOS USUARIOS GESTORES
		
		Usuario testeGestores1 = new UsuarioGestor();
		Setor setor = sr.getOne(2);
		
		
		testeGestores1.setEmail("Ariel@Ariel");
		testeGestores1.setNome("Ariel");
		testeGestores1.setFuncao(5);
		testeGestores1.setEmpresa(empresa);
		//testeGestores1.setSetor(setor);
		testeGestores1.setSenha("01010101");
		
		
		ur.save(testeGestores1);
		
		Usuario gestorCriado = ur.getOne(testeGestores1.getId());
		
		Assert.assertEquals(testeGestores1,gestorCriado);
		
Usuario testeGestores2 = new UsuarioGestor();

		
		testeGestores2.setEmail("Jose@Jose");
		testeGestores2.setNome("Jose");
		testeGestores2.setFuncao(5);
		testeGestores2.setEmpresa(empresa);
		//testeGestores2.setSetor(setor);
		testeGestores2.setSenha("02020202");
		
		
		ur.save(testeGestores2);
		
		Usuario gestorCriado2 = ur.getOne(testeGestores2.getId());
		
		Assert.assertEquals(testeGestores2,gestorCriado2);
		
Usuario testeGestores3 = new UsuarioGestor();
		
		
		testeGestores3.setEmail("Luciano@Luciano");
		testeGestores3.setNome("Luciano");
		testeGestores3.setFuncao(5);
		testeGestores3.setEmpresa(empresa);
		//testeGestores3.setSetor(setor);
		testeGestores3.setSenha("testeLuciano");
		
		ur.save(testeGestores3);
		
		Usuario gestorCriado3 = ur.getOne(testeGestores3.getId());
		
		Assert.assertEquals(testeGestores3,gestorCriado3);
		
Usuario testeGestores4 = new UsuarioGestor();
		
		
		testeGestores4.setEmail("Cristino@Cristino");
		testeGestores4.setNome("Cristino");
		testeGestores4.setFuncao(5);
		testeGestores4.setEmpresa(empresa);
		//testeGestores4.setSetor(setor);
		testeGestores4.setSenha("04040404");
		
		
		ur.save(testeGestores4);
		
		Usuario gestorCriado4 = ur.getOne(testeGestores4.getId());
		
		Assert.assertEquals(testeGestores4,gestorCriado4);
		
Usuario testeGestores5 = new UsuarioGestor();
		
		
		testeGestores5.setEmail("Santana@Santana");
		testeGestores5.setNome("Santana");
		testeGestores5.setFuncao(5);
		testeGestores5.setEmpresa(empresa);
		//testeGestores5.setSetor(setor);
		testeGestores5.setSenha("0505050505");
		
		
		ur.save(testeGestores5);
		
		Usuario gestorCriado5 = ur.getOne(testeGestores1.getId());
		
		Assert.assertEquals(testeGestores1,gestorCriado5);
		
		
	}
	
	//CRIACAO DOS USUARIOSO COMUNS

	  //@Test
	public void MassaDeDadosUsuario () {
		Usuario testeUsuarioComum1 = new Usuario();
		Setor setor = sr.getOne(13);
		
		testeUsuarioComum1.setEmail("Gustavo@Gustavo");
		testeUsuarioComum1.setNome("Gustavo");
		testeUsuarioComum1.setSetor(setor);
		testeUsuarioComum1.setSenha("06060606");
		
		ur.save(testeUsuarioComum1);
		
		
		Usuario usuarioCriado1 = ur.getOne(testeUsuarioComum1.getId());
		
		Assert.assertEquals(testeUsuarioComum1,usuarioCriado1);
		
	Usuario testeUsuarioComum2 = new Usuario();
		
		testeUsuarioComum2.setEmail("Sendy@Sendy");
		testeUsuarioComum2.setNome("Sendy");
		testeUsuarioComum1.setSetor(setor);
		testeUsuarioComum2.setSenha("07070707");
		
		ur.save(testeUsuarioComum2);
		
		Usuario usuarioCriado2 = ur.getOne(testeUsuarioComum2.getId());
		
		Assert.assertEquals(testeUsuarioComum2,usuarioCriado2);
		
		
	Usuario testeUsuarioComum3 = new Usuario();
		
		testeUsuarioComum3.setEmail("Breno@Breno");
		testeUsuarioComum3.setNome("Breno");
		testeUsuarioComum3.setSetor(setor);
		testeUsuarioComum3.setSenha("8080808080");
		
		ur.save(testeUsuarioComum3);
		
		Usuario usuarioCriado3 = ur.getOne(testeUsuarioComum3.getId());
		
		Assert.assertEquals(testeUsuarioComum3,usuarioCriado3);

	Usuario testeUsuarioComum4 = new Usuario();
		
		testeUsuarioComum4.setEmail("Marcia@Marcia");
		testeUsuarioComum4.setNome("Marcia");
		testeUsuarioComum4.setSetor(setor);
		testeUsuarioComum4.setSenha("90909090");
		
		ur.save(testeUsuarioComum4);
		
		Usuario usuarioCriado4 = ur.getOne(testeUsuarioComum4.getId());
		
		Assert.assertEquals(testeUsuarioComum4,usuarioCriado4);

		
	Usuario testeUsuarioComum5 = new Usuario();
		
		testeUsuarioComum5.setEmail("Alexandro@Alexandro");
		testeUsuarioComum5.setNome("Alexandro");
		testeUsuarioComum5.setSetor(setor);
		testeUsuarioComum5.setSenha("100100100100");
		
		ur.save(testeUsuarioComum5);
		
		Usuario usuarioCriado5 = ur.getOne(testeUsuarioComum5.getId());
		
		Assert.assertEquals(testeUsuarioComum5,usuarioCriado5);

	}
	  
	 // @Test
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
