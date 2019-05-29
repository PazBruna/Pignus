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
import org.springframework.web.bind.annotation.RequestParam;

import br.com.pignus.pignusproject.entities.Download;
import br.com.pignus.pignusproject.entities.Funcoes;
import br.com.pignus.pignusproject.entities.LerArquivos;
import br.com.pignus.pignusproject.entities.Setor;
import br.com.pignus.pignusproject.entities.UsuarioGestor;
import br.com.pignus.pignusproject.repository.DownloadRepository;
import br.com.pignus.pignusproject.repository.FuncaoRepository;
import br.com.pignus.pignusproject.repository.SetorRepository;
import br.com.pignus.pignusproject.repository.UsuarioRepository;

@Controller
public class DownloadsController {

	public static final String PAGINA_DE_DOWNLOADS = "paginaMeusDownloads";

	@Autowired
	private DownloadRepository meusDownloads;
	@Autowired
	private FuncaoRepository fc;
	@Autowired
	UsuarioRepository us;
	@Autowired
	SetorRepository st;
	

	@PostMapping("/downloads")
	public String salvarDownloads() {
		LerArquivos ler = new LerArquivos();
		if (ler.listaDownloads() == null) {
			System.out.println("Deu ruim");
		}
		meusDownloads.saveAll(ler.listaDownloads());
		return "redirect:home";
	}

	@RequestMapping(value = "/meusDownloads", method = RequestMethod.GET)
	public String pegandoArquivoLista(@ModelAttribute Funcoes funcao, Model model,
			@RequestParam("funcaoId") String funcaoId, HttpSession session) {
		
		if(session.getAttribute("usuarioLogado") == null) {
			return "redirect:login";
		}
		List<Download> listaArqv;
		int idFuncao = Integer.parseInt(funcaoId);
		funcao.setId(idFuncao);
		if(funcao.getId() == 5) {
			listaArqv = meusDownloads.findAll();
			model.addAttribute("listaArqv", listaArqv);
			return "dashboard/meus-downloads";
		}
		listaArqv = meusDownloads.findAllByFuncaoDownload(funcao);

		model.addAttribute("listaArqv", listaArqv);
		return "dashboard/meus-downloads";
	}
	
	@GetMapping("/novoPrograma")
	public String novoPrograma(HttpSession session,@ModelAttribute Funcoes funcoes, Model model,@ModelAttribute Setor setor) {
		if(session.getAttribute("usuarioLogado") == null) {
			return "redirect:login";
		}
		List<Setor> listaSetor = st.findByNome(setor.getNomeSetor());
		List<Funcoes> listaFuncao = fc.findAllByNome(funcoes.getNomeFuncao());
		session.getAttribute("usuarioLogado");
		model.addAttribute("listaFuncao", listaFuncao);
		model.addAttribute("listaSetor",listaSetor);
		return "dashboard/novo-programa";
	}
	
//	   @RequestMapping(value = "/novoPrograma", method = RequestMethod.POST)
//		public String cadastraSetor(@ModelAttribute Download download, @ModelAttribute Funcoes funcao,@ModelAttribute Setor setor) {
//	    	
//		  List<Setor> novosetor = st.findAllById(setor.getId());
//		   Funcoes novafuncao = fc.getOne(funcao.getId());
//		   download.setFuncaoDownload(funcao);
//	    	download.setFuncaoDownload(novafuncao);
//	    	download.setSetores(novosetor);
//	    	
//	    	meusDownloads.save(download);
//	    	
//			return "redirect:setores";
//		}

}
