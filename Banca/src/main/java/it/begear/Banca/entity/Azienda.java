package it.begear.Banca.entity;

public class Azienda extends Cliente{
	
	private String pIVA;
	private String ragioneSociale;
	private int idCliente;
	
	
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


	public int getidCliente() {
		return idCliente;
	}


	public void setidCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	@Override
	public String toString() {
		return "Azienda [pIVA=" + pIVA + ", ragioneSociale=" + ragioneSociale + ", idCliente=" + idCliente + "]";
	}
}
