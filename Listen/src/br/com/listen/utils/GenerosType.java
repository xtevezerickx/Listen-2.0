package br.com.listen.utils;

public enum GenerosType implements Comparable<GenerosType>{
	ELETRONICA("Eletronica"),
	HIPHOP("Hip-Hop"),
	INDIE("Indie"),
	MPB("MPB"),
	POP("Pop"),
	RAP("Rap"),
	ROCK("Rock"),
	SAMBA("Samba"),
	SERTANEJO("Sertanejo");

	String descricao;

	private GenerosType(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	

}
