package it.begear.Banca.entity;

public class Conto {
	private int idConto;
	private String dataApertura;
	private int saldo;

	public int getIdConto() {
		return idConto;
	}

	public void setIdConto(int idConto) {
		this.idConto = idConto;
	}

	public String getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(String dataApertura) {
		this.dataApertura = dataApertura;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Conto [idConto=" + idConto + ", dataApertura=" + dataApertura + ", saldo=" + saldo + "]";
	}

	public Conto(int idConto, String dataApertura, int saldo) {
		this.idConto = idConto;
		this.dataApertura = dataApertura;
		this.saldo = saldo;
	}

	public Conto() {
	}

}
