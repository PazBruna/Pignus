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
	
	
	
	public class SegurancaDaAPlicacao {
		
		
		public Boolean permitirAcesso(LoginUsuarioComum usuarioComum) {
			if((usuarioComum.getSenha() == null && usuarioComum.getEmail() == "") || 
					(usuarioComum.getSenha() == "" && usuarioComum.getEmail()== null)) {
				return true;
			}
			return false;
			
		}
	}
	
	
	
	
	
			
	}
