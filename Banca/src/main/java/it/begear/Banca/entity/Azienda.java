package it.begear.Banca.entity;

public class Azienda extends Cliente{
	
	private String idIVA;
	private String ragioneSociale;
	private int idClienete;
	
	
	public Azienda() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Azienda(String idIVA, String ragioneSociale, int idClienete) {
		super();
		this.idIVA = idIVA;
		this.ragioneSociale = ragioneSociale;
		this.idClienete = idClienete;
	}


	public String getIdIVA() {
		return idIVA;
	}


	public void setIdIVA(String idIVA) {
		this.idIVA = idIVA;
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
		return "Azienda [idIVA=" + idIVA + ", ragioneSociale=" + ragioneSociale + ", idClienete=" + idClienete + "]";
	}
}
