package br.com.pignus.pignusproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pignus.pignusproject.entities.Empresa;
import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;
import br.com.pignus.pignusproject.repository.EmpresaRepository;


@Controller
public class EmpresaController {
	public static final String PAGINA_DE_LOGIN = "login";
	public static final String PAGINA_LOGIN_ERRO = "paginaLoginErro";
	public static final String PAGINA_PRINCIPAL = "dashboard/dashboard";
	@Autowired
	private SegurancaDaAplicacao seguranca;
	@Autowired
	private EmpresaRepository empresas;

	public EmpresaController(SegurancaDaAplicacao seguranca) {
		this.seguranca = seguranca;
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String acessarCadastro(@ModelAttribute Empresa empresa) {
		return "cadastro";
	}

	@PostMapping("/cadastro")
	public String cadastrarUsuarioEmpresa(@ModelAttribute Empresa empresa) {
		empresas.save(empresa);
		return "redirect:login";
	}

	@PostMapping("/loginEmpresa")
	public String loginEmpresaEfetuado(@ModelAttribute Empresa empresa) {
		/* Empresa novaEmpresa = new Empresa(); */
		Empresa novaEmpresa = seguranca.permitirAcessoEmpresa(empresa.getEmail(), empresa.getSenha());
		if (novaEmpresa == null) {
			System.out.println(empresa.getEmail());
			/* seguranca.historicoAcesso((empresa.getEmail()); */ 
			return "redirect:login";
		}

		return "redirect:home";
	}

}
