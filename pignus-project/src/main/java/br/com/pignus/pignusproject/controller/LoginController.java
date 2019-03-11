package br.com.pignus.pignusproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;


@Controller 
public class LoginController {
	public static final String PAGINA_LOGIN_EFETUADO = "loginEfetuado";
	public static final String PAGINA_LOGIN_ERRO = "loginErro";

	@SuppressWarnings("unused")
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
