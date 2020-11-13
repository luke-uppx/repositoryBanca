package it.begear.Banca.entity;

public class Azienda {
	
	private String pIVA;
	private String ragioneSociale;
	private int idCliente;
	
	public Azienda() {}

	public Azienda(String pIVA, String ragioneSociale, int idCliente) {
		super();
		this.pIVA = pIVA;
		this.ragioneSociale = ragioneSociale;
		this.idCliente = idCliente;
	}
	
	public Azienda(String pIVA, String ragioneSociale) {
		super();
		this.pIVA = pIVA;
		this.ragioneSociale = ragioneSociale;
	}


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

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Azienda [pIVA=" + pIVA + ", ragioneSociale=" + ragioneSociale + ", idCliente=" + idCliente + "]";
	}
}
