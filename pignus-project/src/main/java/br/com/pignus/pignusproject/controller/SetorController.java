package br.com.pignus.pignusproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.pignus.pignusproject.entities.Setor;
import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.entities.UsuarioGestor;
import br.com.pignus.pignusproject.infra.SegurancaDaAplicacao;
import br.com.pignus.pignusproject.repository.SetorRepository;
import br.com.pignus.pignusproject.repository.UsuarioRepository;

@Controller
public class SetorController{
	


    public static final String PAGINA_PRINCIPAL_SETORES = "paginaPrincipalSetores";

	@Autowired
	SetorRepository setores;
	@Autowired
	public SegurancaDaAplicacao seguranca;
    public SetorController(){};
    @Autowired
    private UsuarioRepository usuario;
    
    
    
    @RequestMapping(value = "/setores", method=RequestMethod.GET)
    public String acessarSetores(@ModelAttribute Setor setor){
        return PAGINA_PRINCIPAL_SETORES;
    }

    @RequestMapping(value = "/cadastroSetor", method=RequestMethod.GET)
    public String cadastrarSetor(@ModelAttribute Setor setor, Model model){
    	List<Usuario> listaGestor = usuario.findAllByTipo("G");
    	List<Usuario> listaFuncionario = usuario.findAllByTipo("C");
    	model.addAttribute("listaGestor", listaGestor).toString();
    	model.addAttribute("listaFuncionario", listaFuncionario).toString();
    	for (Usuario usuario : listaGestor) {    		
			System.out.println(usuario.getNome());
		}
    	
    	for (Usuario usuario : listaFuncionario) {			
    		System.out.println(usuario.getNome());
		}
    	
        return "paginaCadastroSetor";
    }
    
  
    
    @PostMapping("/cadastroSetor")
	public String retornaPaginaSetor(@ModelAttribute Setor setor) {
    	UsuarioGestor gestor = setor.getGestor();
    	if(seguranca.procuraGestor(gestor) == null) {
    		System.out.println("Esta nulo");
    		return "redirect:cadastroSetor";
    	}
    	setor.setGestor(seguranca.procuraGestor(gestor));
    	setores.save(setor);
		return "redirect:setores";
	}
    
    


}