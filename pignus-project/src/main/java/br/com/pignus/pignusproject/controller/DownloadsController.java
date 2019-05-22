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

@Controller
public class DownloadsController {
	
	public static final String PAGINA_DE_DOWNLOADS = "paginaMeusDownloads";
	
	@Autowired
	private DownloadRepository meusDownloads;
	@Autowired
	private FuncaoRepository funcoes;


	@PostMapping("/downloads")
	public String salvarDownloads() {
		LerArquivos ler = new LerArquivos();
		if(ler.listaDownloads()== null) {
			System.out.println("Deu ruim");
		}
		meusDownloads.saveAll(ler.listaDownloads());
		return "redirect:meusDownloads";
	}
	
	@RequestMapping(value = "/meusDownloads", method=RequestMethod.GET)
	public String pegandoArquivoLista (@ModelAttribute Download download, Model model,HttpSession session) {
		
		
		
		List<Download> listaArqv = meusDownloads.findAll();
		for (Download downloadLista : listaArqv) {
			Usuario usuario = null;
			if (usuario.getFuncaoUsuario() != download.getFuncaoDownload()) {
				listaArqv.remove(downloadLista);
			}
		}
		model.addAttribute("listaArqv", listaArqv).toString();	
		return "dashboard/meus-downloads";
	}
	

}
