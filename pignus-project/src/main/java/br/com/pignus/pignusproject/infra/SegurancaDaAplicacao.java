package br.com.pignus.pignusproject.infra;

import org.springframework.stereotype.Component;

import br.com.pignus.pignusproject.entities.LoginUsuarioComum;

@Component
public class SegurancaDaAplicacao {

	public Boolean permitirAcesso(LoginUsuarioComum usuarioComum) {
		if(usuarioComum.getEmail() == "") {
			return true;
		}
		return false;
	}
	
	public boolean loginValidado(LoginUsuarioComum usuarioComum) {
			if((usuarioComum.getEmail() == "" && usuarioComum.getSenha() == null)
					|| (usuarioComum.getEmail() == null && usuarioComum.getSenha() == "")) {
				return true ;	
			}
			return false;
		}
			
	}
