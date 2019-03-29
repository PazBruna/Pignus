package br.com.pignus.pignusproject.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UsuarioLog {
	
	@Id
	@GeneratedValue
	private int logId;
	@ManyToOne
	private Usuario usuario;
	
	/* @Temporal(TemporalType.TIMESTAMP) */
	private String usuarioData;
	
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getUsuarioData() {
		return usuarioData;
	}
	public void setUsuarioData(String usuarioData) {
		this.usuarioData = usuarioData;
	}
	
	
	
	
}
