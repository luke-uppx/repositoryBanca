package it.begear.Banca.entity;

public class Conto {
	
	private int idConto;
	private String dataApertura;
	private int saldo;
	private int idCliente;

	public Conto() {}

	public Conto(String dataApertura, int saldo, int idCliente) {
		this.dataApertura = dataApertura;
		this.saldo = saldo;
		this.idCliente = idCliente;
	}
	
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Conto [idConto=" + idConto + ", dataApertura=" + dataApertura + ", saldo=" + saldo + "]";
	}


}
