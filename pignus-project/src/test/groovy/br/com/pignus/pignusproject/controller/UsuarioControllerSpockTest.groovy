package br.com.pignus.pignusproject.controller

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import br.com.pignus.pignusproject.controller.UsuarioController
import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao
import spock.lang.Specification

//use esse import para testar os metodos http GET,POST,PUT,DELETE
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

class UsuarioControllerSpockTest extends Specification{
	
	//geralmente sua aplicação vai ter isso como base
	def UrlBase="http://localhost:8080"
	
	MockMvc mockMvc //quem vai bater na URL 
	SegurancaDaAplicacao seguranca
	
	//mesma coisa do @Before
	def setup(){
		//deve configurar em qual controller executará os testes
		mockMvc = MockMvcBuilders.standaloneSetup(
			new UsuarioController(seguranca)).build()
	}
	
	def "Should return paginaDeLogin when perform GET"(){
		
		given:"url with path /login"
		UrlBase+="/login"
		
		when:"perform GET in http://localhost:8080/login"
		def response =mockMvc.perform(get(UrlBase)).andReturn().getResponse()
		
		then:"Status OK"
		response.status==200
		
	}
	def "Should return NOT FOUND when perform GET in a inexistent Url path"(){
		
		given:"url with inexistent path /qualquerCoisa"
		UrlBase+="/seila"
		
		when:"perform GET in http://localhost:8080/seila"
		def response =mockMvc.perform(get(UrlBase)).andReturn().getResponse()
		
		then:"Status NOT FOUND"
		response.status==404
		
	}
	
}
