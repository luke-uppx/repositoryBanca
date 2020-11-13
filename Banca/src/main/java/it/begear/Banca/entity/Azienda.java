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
