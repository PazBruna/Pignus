package br.com.pignus.pignusproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;

@Controller
public class UsuarioController {
	public static final String PAGINA_DE_LOGIN = "paginaDeLogin";
	public static final String PAGINA_LOGIN_ERRO = "paginaLoginErro";
	public static final String PAGINA_PRINCIPAL = "paginaPrincipal";
	@Autowired
	private SegurancaDaAplicacao seguranca;

	public UsuarioController(SegurancaDaAplicacao seguranca) {
		this.seguranca = seguranca;
	}

	@PostMapping("/login")
	public String loginEfetuado(@ModelAttribute Usuario usuarioComum) {
		if (seguranca.permitirAcesso(usuarioComum.getEmail(), usuarioComum.getSenha())) {
			seguranca.adicionaMatrizLog(usuarioComum.getEmail());
			return PAGINA_PRINCIPAL;
		}
		return PAGINA_LOGIN_ERRO;
	}

	@GetMapping("/login")
	public String acessarLogin(@ModelAttribute Usuario usuarioComum) {
		return PAGINA_DE_LOGIN;
	}
}
