package br.com.listen.model;

public class Faixas {
	String dscFaixa;
	int idCd;
	int numFaixa;

	

	public int getNumFaixa() {
		return numFaixa;
	}

	public void setNumFaixa(int numFaixa) {
		this.numFaixa = numFaixa;
	}

	public String getDscFaixa() {
		return dscFaixa;
	}

	public int setDscFaixa(String dscFaixa) {
		this.dscFaixa = dscFaixa;
		return 1;
	}


	public int getIdCd() {
		return idCd;
	}
	
	public void setIdCd(int idCd) {
		this.idCd = idCd;
	}

	@Override
	public String toString() {
		return "Faixas [dscFaixa=" + dscFaixa + ", idCd=" + idCd + ", numFaixa=" + numFaixa + "]";
	}

}
