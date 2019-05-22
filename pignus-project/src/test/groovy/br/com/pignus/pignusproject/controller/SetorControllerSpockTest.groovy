package br.com.pignus.pignusproject.controller

import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao
import spock.lang.Specification

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

class SetorControllerSpockTest extends Specification{
	
	def UrlBase="http://localhost:8080"
	
	MockMvc mockMvc
	SegurancaDaAplicacao seguranca
	
	def setup() {
		mockMvc = MockMvcBuilder.standaloneSetup(
			new SetorController(seguranca)).build()
	}
	
	def "Should return paginaDeCadastroSetor when perform GET"(){
		
		given:"url with path /setores"
		UrlBase+="/setores"
		
		when:"perform GET in http://localhost:8080/setores"
		def response =mockMvc.perform(get(UrlBase)).andReturn().getResponse()
		
		then:"Status OK"
		response.status==200
		
	}
	def "Should return NOT FOUND when perform GET in a inexistent Url path"(){
		
		given:"url with inexistent path /qualquerCoisa"
		UrlBase+="/cadastroSetor"
		
		when:"perform GET in http://localhost:8080/cadastroSetor"
		def response =mockMvc.perform(get(urlBase)).andReturn().getResponse()
		
		then:"Status NOT FOUND"
		response.status==404
		
	}
}
