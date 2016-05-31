package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.listen.jdbc.TabelaCDDB;
import br.com.listen.model.CDs;
import br.com.listen.model.Carrinho;

@Controller
public class CarrinhoController {
	
	@RequestMapping("carrinho")
	public String paginaDoCarrinho(){
		return "carrinho/mostrarCarrinho";
	}
	
	@RequestMapping("adicionarCarrinho")
	public String adicionarCdParaCarinho(int idCd) throws Exception{
		CDs cd = new TabelaCDDB().buscaPeloId(idCd);
		System.out.println(cd);
		Carrinho carrinho = new Carrinho();
		carrinho.adiciona(cd);
		System.out.println("valor total"+carrinho.getValorTotal());
		
		
		return "redirect:index";
	}
	
	
}
