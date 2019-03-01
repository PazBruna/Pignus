package br.com.pignus.pignusproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;


@Controller 
public class LoginController {
	public static final String PAGINA_LOGIN_EFETUADO = "loginEfetuado";
	public static final String PAGINA_LOGIN_ERRO = "loginErro";

	private SegurancaDaAplicacao seguranca;

	public LoginController(SegurancaDaAplicacao seguranca) {
		this.seguranca = seguranca;
	}
	@RequestMapping("/loginEfetuado")
	public String loginEfetuado () {
		return PAGINA_LOGIN_EFETUADO;
	}
	
	@RequestMapping("/loginErro")
	public String loginInvalido() {
		return PAGINA_LOGIN_ERRO;
	}

}
