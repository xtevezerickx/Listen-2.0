package br.com.listen.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.listen.jdbc.ArtistaDB;
import br.com.listen.jdbc.FaixasDB;
import br.com.listen.jdbc.GeneroDB;
import br.com.listen.jdbc.TabelaCDDB;
import br.com.listen.model.Artista;
import br.com.listen.model.CDs;
import br.com.listen.model.Faixas;
import br.com.listen.model.Genero;
import br.com.listen.utils.GenerosType;

@Controller
public class CDController {
	@RequestMapping("cadastrarCD")
	public String formAdicionarCD(Model model) {
		ArrayList<GenerosType> listaGeneros = new ArrayList<GenerosType>(Arrays.asList(GenerosType.values()));
		ArrayList<String> listaGenerosString = new ArrayList<String>();
		for(int i=0;i<listaGeneros.size();i++){
			listaGenerosString.add(i,listaGeneros.get(i).getDescricao());
		}
		model.addAttribute("listaGeneros", listaGenerosString);
		return "cd/cadastrarCD";
	}

	@RequestMapping("removerCD")
	public String removerCD(int cdId) throws Exception {
		new TabelaCDDB().delete(cdId);
		return "redirect:listarCd";
	}

	@RequestMapping("mostrarCD")
	public String alterarCD(int cdId, Model model) throws Exception {
		TabelaCDDB bd = new TabelaCDDB();
		CDs cd = bd.buscaPeloId(cdId);
		ArrayList<GenerosType> listaGeneros = new ArrayList<GenerosType>(Arrays.asList(GenerosType.values()));
		ArrayList<String> listaGenerosString = new ArrayList<String>();
		for(int i=0;i<listaGeneros.size();i++){
			listaGenerosString.add(i,listaGeneros.get(i).getDescricao());
		}
		model.addAttribute("listaGeneros", listaGenerosString);
		ArrayList<Faixas> listaFaixas = new TabelaCDDB().listarFaixasPorId(cdId);
		model.addAttribute("listaFaixas",listaFaixas);
		model.addAttribute("cd", cd);
		return "cd/mostrarCD";
	}
	
	@RequestMapping("alterarCd")
	public String alterarCd(CDs cd,@RequestParam("faixa") ArrayList<String> faixas)throws Exception{
		TabelaCDDB bdCd = new TabelaCDDB();
		System.out.println("O cd para update é"+ cd);
		bdCd.update(cd);
		FaixasDB bdFaixa = new FaixasDB();
		for(int i=0;i<faixas.size();i++){
			bdFaixa.update(faixas.get(i), cd.getIdCD());
		}		
		return "redirect:listarCd";
	}

	@RequestMapping("mostrarFaixa")
	public String formCadastrarFaixa(int cdId, Model model) throws Exception {
		model.addAttribute("cdId", cdId);
		return "cd/mostrarFaixa";
	}

	@RequestMapping("adicionarFaixa")
	public String adicionarFaixa(int cdId, @RequestParam("faixa") String faixa)
			throws SQLException, Exception {
		cadastrarFaixa(cdId, faixa);
		return "redirect:listarCd";
	}

	@RequestMapping("adicionarCd")
	public String adicionarCD(Model model, CDs cd, @RequestParam("faixa") ArrayList<String> faixa,@RequestParam("file") MultipartFile file)	throws SQLException, Exception {
		
		TabelaCDDB db = new TabelaCDDB();
		db.insert(cd);
		int idCd = db.descobreUltimoId();
		
		System.out.println("file" + file.toString());
		if(!file.isEmpty()){
			String caminhoDaCapa = "C:\\Users\\Erick Maia\\git\\Listen-2.0\\Listen\\WebContent\\imagens\\CD"+idCd+".png";
			db.inserirCapa(idCd,caminhoDaCapa);
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File destination = new File(caminhoDaCapa);
			ImageIO.write(src, "PNG", destination);
		}
				
		for(int i = 0; i < faixa.size(); i++)
			cadastrarFaixa(idCd, faixa.get(i));
		model.addAttribute("msg", "Você adicionou um novo CD com sucesso!");
		return "redirect:listarCd";
	}

	private void cadastrarFaixa(int cdId, String dscFaixa) throws SQLException, Exception {
		FaixasDB bd = new FaixasDB();
		Faixas f = new Faixas();
		f.setNumFaixa(bd.descobreUltimaFaixa(cdId));
		f.setDscFaixa(dscFaixa);
		f.setIdCd(cdId);
		if (!(f.getDscFaixa() == "")) {
			try {
				bd.insert(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("listarCd")
	public String lista(String msg, Model model,Integer pag) throws SQLException, Exception {
		System.out.println(pag);
		TabelaCDDB bd = new TabelaCDDB();
		List<CDs> listacd = bd.findAll();
		
		int quantidadePaginas = quantidadeDePaginas(listacd.size());
		ArrayList<Integer> qtdPaginaLista = new ArrayList<Integer>();
		for(int i=0;i<quantidadePaginas;i++){
			qtdPaginaLista.add(i+1);
		}
		
		if(pag!=null){
			model.addAttribute("cds", new TabelaCDDB().listarPaginado(pag));	
		}else{
			model.addAttribute("cds",new TabelaCDDB().listarPaginado(1));
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("paginas",qtdPaginaLista);
		return "cd/listarCD";
	}
	@RequestMapping("index")
	public void index(Model model) throws SQLException, Exception {

		ArrayList<GenerosType> listaGeneros = new ArrayList<GenerosType>(Arrays.asList(GenerosType.values()));	
		
		ArrayList<Genero> listaQuantidadePorGenero = new ArrayList<>();
	
		for(int i=0;i<listaGeneros.size();i++){
			Genero genero = new Genero();
			genero.setQtdGenero(new GeneroDB().buscaQuantidadePorGenero(listaGeneros.get(i).getDescricao()));
			genero.setDscGenero(listaGeneros.get(i).getDescricao());
			listaQuantidadePorGenero.add(genero);
		}
		
		TreeSet<Artista> tree = new TabelaCDDB().listaTodosArtistasOrdem();
		List<Artista> listaArtistas = new ArrayList<Artista>(tree);

		
		for(int i=0;i<listaArtistas.size();i++){
			listaArtistas.get(i).setQtdArtista(new ArtistaDB().buscaQuantidaePorArtista(listaArtistas.get(i).getNomeArtista()));
		}
		

			
		model.addAttribute("cds", new TabelaCDDB().buscaTodosLancamentos());
		model.addAttribute("quantidadePorGenero",listaQuantidadePorGenero);	
		model.addAttribute("listaArtistas",listaArtistas);
		model.addAttribute("listaDeFaixas", new FaixasDB().listarTodasFaixas());

	}
	
	private int quantidadeDePaginas(int numero){
		if(numero%8==0){
			return numero/8;
		}else{
			return Math.round(numero/8)+1;
		}
	}

	
}