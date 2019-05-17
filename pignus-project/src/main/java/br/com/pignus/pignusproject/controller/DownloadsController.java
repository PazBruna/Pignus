package br.com.pignus.pignusproject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.pignus.pignusproject.entities.Download;
import br.com.pignus.pignusproject.entities.LerArquivos;
import br.com.pignus.pignusproject.repository.DownloadRepository;

@Controller
public class DownloadsController {
	
	public static final String PAGINA_DE_DOWNLOADS = "paginaMeusDownloads";
	
	@Autowired
	private DownloadRepository meusDownloads;

	@PostMapping("/meusDownloads")
	public String salvandoDownloads (){
		return PAGINA_DE_DOWNLOADS;
	}
	
	@RequestMapping(value = "/meusDownloads", method=RequestMethod.GET)
	public String pegandoArquivoLista (@ModelAttribute Download download, Model model) {
		LerArquivos ler = new LerArquivos();
		if(ler.listaDownloads() == null) {
			System.out.println("Deu ruim");
		}
		meusDownloads.saveAll(ler.listaDownloads());
		List<Download> listaArqv = meusDownloads.findAll();
		model.addAttribute("listaArqv", listaArqv).toString();	
		return PAGINA_DE_DOWNLOADS;
	}
	

}
