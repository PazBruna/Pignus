package br.com.pignus.pignusproject.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.pignus.pignusproject.entities.Download;
import br.com.pignus.pignusproject.entities.LerArquivos;
import br.com.pignus.pignusproject.entities.Usuario;
import br.com.pignus.pignusproject.repository.DownloadRepository;
import br.com.pignus.pignusproject.repository.FuncaoRepository;
import br.com.pignus.pignusproject.repository.UsuarioRepository;

@Controller
public class DownloadsController {
	
	public static final String PAGINA_DE_DOWNLOADS = "paginaMeusDownloads";
	
	@Autowired
	private DownloadRepository meusDownloads;
	@Autowired
	private FuncaoRepository funcoes;
	@Autowired
	UsuarioRepository us;


	@PostMapping("/downloads")
	public String salvarDownloads() {
		LerArquivos ler = new LerArquivos();
		if(ler.listaDownloads()== null) {
			System.out.println("Deu ruim");
		}
		meusDownloads.saveAll(ler.listaDownloads());
		return "redirect:meusDownloads";
	}
	
	@RequestMapping(value = "/meusDownloads/funcao", method=RequestMethod.GET)
	public String pegandoArquivoLista (@ModelAttribute Download download, Model model,HttpSession session,@ModelAttribute Usuario usuario) {
		session.getAttribute("usuarioLogado");
		List<Download> listaArqv = meusDownloads.findByFuncaoAndSetor(usuario.getFuncaoUsuario(), usuario.getSetor());

		model.addAttribute("listaArqv", listaArqv);	
		return "dashboard/meus-downloads";
	}
	

}
