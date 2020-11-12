package it.begear.Banca.entity;

public class Azienda extends Cliente{
	
	private String pIVA;
	private String ragioneSociale;
	private int idClienete;
	
	



	public String getpIVA() {
		return pIVA;
	}


	public void setpIVA(String pIVA) {
		this.pIVA = pIVA;
	}


	public String getRagioneSociale() {
		return ragioneSociale;
	}


	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}


	public int getIdClienete() {
		return idClienete;
	}


	public void setIdClienete(int idClienete) {
		this.idClienete = idClienete;
	}


	@Override
	public String toString() {
		return "Azienda [pIVA=" + pIVA + ", ragioneSociale=" + ragioneSociale + ", idClienete=" + idClienete + "]";
	}
}
