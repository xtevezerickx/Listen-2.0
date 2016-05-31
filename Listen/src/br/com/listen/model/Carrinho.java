package br.com.listen.model;

import java.util.ArrayList;

public class Carrinho {
	private ArrayList<CDs> listaCd = new ArrayList<>();
	private double valorTotal;
	private Usuario usuario;
	
	public void adiciona(CDs cd){
		listaCd.add(cd);
		valorTotal+=cd.getPreco();
		
	}
	
	public ArrayList<CDs> getListaCd() {
		return listaCd;
	}
	public void setListaCd(ArrayList<CDs> listaCd) {
		this.listaCd = listaCd;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Carrinho [listaCd=" + listaCd + ", valorTotal=" + valorTotal + ", usuario=" + usuario + "]";
	}
	
}
