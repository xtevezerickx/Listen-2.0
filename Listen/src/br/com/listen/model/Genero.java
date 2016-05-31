package br.com.listen.model;

public class Genero {
	private int qtdGenero;
	private String dscGenero;
	public int getQtdGenero() {
		return qtdGenero;
	}
	public void setQtdGenero(int qtdGenero) {
		this.qtdGenero = qtdGenero;
	}
	public String getDscGenero() {
		return dscGenero;
	}
	public void setDscGenero(String dscGenero) {
		this.dscGenero = dscGenero;
	}
	@Override
	public String toString() {
		return "Genero [qtdGenero=" + qtdGenero + ", dscGenero=" + dscGenero + "]";
	}
	
	
	

}
