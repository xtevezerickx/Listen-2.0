package br.com.listen.model;

public class Artista implements Comparable<Artista> {

	private int qtdArtista;
	private String nomeArtista;
	public int getQtdArtista() {
		return qtdArtista;
	}
	public void setQtdArtista(int qtdArtista) {
		this.qtdArtista = qtdArtista;
	}
	public String getNomeArtista() {
		return nomeArtista;
	}
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	@Override
	public String toString() {
		return "Artista [qtdArtista=" + qtdArtista + ", nomeArtista=" + nomeArtista + "]";
	}
	@Override
	public int compareTo(Artista o) {
		return this.nomeArtista.compareTo(o.nomeArtista);
	}
	

	
}
