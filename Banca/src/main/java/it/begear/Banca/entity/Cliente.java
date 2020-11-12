package it.begear.Banca.entity;

public class Cliente  {

	private int idCliente;
	private int idConto;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdConto() {
		return idConto;
	}

	public void setIdConto(int idConto) {
		this.idConto = idConto;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", idConto=" + idConto + "]";
	}

	public Cliente(int idCliente, int idConto) {
		super();
		this.idCliente = idCliente;
		this.idConto = idConto;
	}

	public Cliente() {

	}


}
