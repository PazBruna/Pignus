package br.com.pignus.pignusproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.entities.UsuarioAdmin;
import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;
import br.com.pignus.pignusproject.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	public static final String PAGINA_DE_LOGIN = "paginaDeLogin";
	public static final String PAGINA_LOGIN_ERRO = "paginaLoginErro";
	public static final String PAGINA_PRINCIPAL = "paginaPrincipal";
	private SegurancaDaAplicacao seguranca;
	@Autowired
	private UsuarioRepository usuarios;

	public UsuarioController(SegurancaDaAplicacao seguranca) {
		this.seguranca = seguranca;
	}

	@PostMapping("/login")
	public String loginEfetuado(@ModelAttribute Usuario usuario) {
		if (seguranca.permitirAcesso(usuario.getEmail(), usuario.getSenha())) {
			seguranca.adicionaMatrizLog(usuario.getEmail());
			return PAGINA_PRINCIPAL;
		}
		return PAGINA_LOGIN_ERRO;
	}

	@GetMapping("/login")
	public String acessarLogin(@ModelAttribute Usuario usuario) {
		return PAGINA_DE_LOGIN;
	}

	@RequestMapping(value = "/usuarioAdmin", method = RequestMethod.POST)
	public String cadastrarUsuarioAdmin(@ModelAttribute UsuarioAdmin usuario) {
		usuarios.save(usuario);
		return "redirect:login";
	}
}
