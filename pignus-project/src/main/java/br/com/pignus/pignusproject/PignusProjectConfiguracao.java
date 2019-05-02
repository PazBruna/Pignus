package br.com.pignus.pignusproject;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.pignus.pignusproject.entities.Empresa;
import br.com.pignus.pignusproject.entities.Setor;
import br.com.pignus.pignusproject.entities.UsuarioGestor;
import br.com.pignus.pignusproject.repository.EmpresaRepository;
import br.com.pignus.pignusproject.repository.SetorRepository;
import br.com.pignus.pignusproject.repository.UsuarioRepository;

//@Component
public class PignusProjectConfiguracao {

	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private EmpresaRepository er;
	@Autowired
	private SetorRepository sr;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.criarNovoSetor();
		this.criarNovoUsuarioGestor();
	}

	@Transactional
	private void criarNovoSetor() {
		if (sr.count() == 0) {
			Setor setor = new Setor();
			setor.setId(1);
			Empresa empresa = null;// er.getOne(1);

			setor.setNomeSetor("IBM");
			setor.setEmpresa(empresa);

			sr.save(setor);

		}
	}

	@Transactional
	private void criarNovoUsuarioGestor() {
		if (ur.count() == 0) {
			Setor setor = sr.getOne(1);
			UsuarioGestor usuario = new UsuarioGestor();
			usuario.setId(1);
			usuario.setNome("Guilherme");
			usuario.setEmail("guilherme@guilherme.com");
			usuario.setSenha("1234");
			usuario.setSetor(setor);

			ur.save(usuario);
		}

	}

}
