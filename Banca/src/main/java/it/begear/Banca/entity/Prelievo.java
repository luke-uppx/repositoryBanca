package it.begear.Banca.entity;

public class Prelievo {

	private int idConto;
	private int quantita;
	private String data;
	private int totale;

	public Prelievo() {
		super();
	}

	public Prelievo(int idConto, int quantita, String data, int totale) {
		super();
		this.idConto = idConto;
		this.quantita = quantita;
		this.data = data;
		this.totale = totale;
	}

	public int getIdConto() {
		return idConto;
	}

	public void setIdConto(int idConto) {
		this.idConto = idConto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getTotale() {
		return totale;
	}

	public void setTotale(int totale) {
		this.totale = totale;
	}

	@Override
	public String toString() {
		return "Prelievo [idConto=" + idConto + ", quantita=" + quantita + ", data=" + data + ", totale=" + totale
				+ "]";
	}
}
