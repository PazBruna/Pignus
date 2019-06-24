package br.com.pignus.pignusproject.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.pignus.pignusproject.entities.Funcoes;
import br.com.pignus.pignusproject.repository.FuncaoRepository;

@Controller 
public class GerenciamentoRotasPaginas {
	
	@Autowired
	FuncaoRepository fc;
	
	
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
	
	@GetMapping("/index")
	public String paginaPrincipalIndex(HttpSession session) {
		
		return "index";
	}
	@GetMapping("/nossaSolucao")
	public String paginaPrincipalNossaSolucao(HttpSession session) {
		
		return "nossa-solucao";
	}
	@GetMapping("/quemSomos")
	public String paginaPrincipalQuemSomos(HttpSession session) {
		
		return "quem-somos";
	}
	
	
}


