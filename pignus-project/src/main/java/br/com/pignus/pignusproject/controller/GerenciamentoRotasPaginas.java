package br.com.pignus.pignusproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class GerenciamentoRotasPaginas {
	@GetMapping("/home")
	public String paginaPrincipal(HttpSession session) {
		session.getAttribute("usuarioLogado");
		
		return "paginaPrincipal";
	}

}
