package br.com.pignus.pignusproject.controller

import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao
import spock.lang.Specification

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

class EmpresaControllerSpockTest extends Specification {
	
	def UrlBase="http://localhost:8080"
	
	MockMvc mockMvc
	SegurancaDaAplicacao seguranca
	
	
	def setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(
			new EmpresaController(seguranca)).build()
	}
	
	def "Should return HttpStatus as OK(200) when GET"(){
		
		given: "url with /cadastro"
		UrlBase+="/cadastro"
		
		when: "perform GET in http://localhost:8080/login"
		def response =mockMvc.perform(get(UrlBase)).andReturn().getResponse()
		
		then: "Status OK"
		response.status==200
		
	}
	
	def "Should return HttpStatus as NOT FOUND(404) when GET"(){
		
		given:"url with inexistent path /xxx"
		UrlBase+="/yyy"
		
		
		when: "perform GET in http://localhost:8080/xxx"
		def response =mockMvc.perform(get(UrlBase)).andReturn().getResponse()
		
		then: "Status NOT FOUND"
		response.status==404
	}
}
