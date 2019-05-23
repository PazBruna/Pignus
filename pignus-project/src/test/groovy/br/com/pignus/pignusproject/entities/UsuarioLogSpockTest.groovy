package br.com.pignus.pignusproject.entities

import org.spockframework.mock.MockUtil
import org.springframework.test.web.servlet.MockMvc

import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao
import spock.lang.Specification

class UsuarioLogSpockTest extends Specification {
	
	
	def setup() {
		
	}
	
	def "validation of ID" (){
		
		given: "Dado que o usuario foi instanciado" //chamar a classe como se fosse um metodo 
	    def usuario = new UsuarioLog() //construtor
		
		when: "Quando chamar o metodo getLogId"
		int IdRetornado = usuario.getLogId()  //IdRetornado e colocado para receber o getLogId, pra retornar 0
		 
		then: "Id retornado e igual a 0"
		IdRetornado == 0
	}
	
	def "O que set deve fazer"(){
		
		given: "Dado que o usuario foi instaciado"
		def usuarioLog = new UsuarioLog()
		
		when:"quando colocar o log id como 10"
		usuarioLog.setLogId(10) 
		
		then:"o log id do objeto sera 10"
		usuarioLog.getLogId() == 10 
	}
	def "O que set Usuario deve fazer"(){
		
		given: "Dado que o usuario foi instaciado"
		def usuarioLog = new UsuarioLog()
		
		when: "quando inserir um usuario"
		Usuario usuarioFalso
		usuarioLog.setUsuario(usuarioFalso)
		
		then: "usuario inserido sera igual ao que usuarioLog retornar"
		usuarioLog.getUsuario() == usuarioFalso
	}
	
	
}
