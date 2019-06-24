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
	
	def "Retornar paginaDeCadastroSetor quando chamar GET"(){
		
		given:"url with path /setores"
		UrlBase+="/setores"
		
		when:"perform GET no http://localhost:8080/setores"
		def response =mockMvc.perform(get(UrlBase)).andReturn().getResponse()
		
		then:"Status OK"
		response.status==200
		
	}
	def "Retornar NOT FOUND quando perform GET numa URL inexistente"(){
		
		given:"com uma url inexistente /qualquerCoisa"
		UrlBase+="/cadastroSetor"
		
		when:"perform GET no http://localhost:8080/cadastroSetor"
		def response =mockMvc.perform(get(urlBase)).andReturn().getResponse()
		
		then:"Status NOT FOUND"
		response.status==404
		
	}
}
