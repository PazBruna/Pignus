package br.com.pignus.pignusproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class GerenciamentoRotasPaginas {
	
	
	@GetMapping("/home")
	public String paginaPrincipal(HttpSession session) {
		if(session.getAttribute("usuarioLogado") == null) {
			return "redirect:login";
		}
		session.getAttribute("usuarioLogado");
		
		return "dashboard/dashboard";
	}
	
	@GetMapping("/meusProjetos")
	public String meusProjetos(HttpSession session) {
		if(session.getAttribute("usuarioLogado") == null) {
			return "redirect:login";
		}
		session.getAttribute("usuarioLogado");
		
		return "dashboard/meus-projetos";
	}
	
	@GetMapping("/novoPrograma")
	public String novoPrograma(HttpSession session) {
		if(session.getAttribute("usuarioLogado") == null) {
			return "redirect:login";
		}
		session.getAttribute("usuarioLogado");
		
		return "dashboard/novo-programa";
	}
	
	@GetMapping("/novoProjeto")
	public String novoprojeto(HttpSession session) {
		if(session.getAttribute("usuarioLogado") == null) {
			return "redirect:login";
		}
		session.getAttribute("usuarioLogado");
		
		return "dashboard/novo-projeto";
	}
	
	@GetMapping("/novoSetor")
	public String novoSetor(HttpSession session) {
		if(session.getAttribute("usuarioLogado") == null) {
			return "redirect:login";
		}
		session.getAttribute("usuarioLogado");
		
		return "dashboard/novo-setor";
	}
	
	@GetMapping("/configuracoesUsuario")
	public String configuracoesUsuario(HttpSession session) {
		if(session.getAttribute("usuarioLogado") == null) {
			return "redirect:login";
		}
		session.getAttribute("usuarioLogado");
		
		return "dashboard/configuracoes-usuario";
	}
	
	
}


