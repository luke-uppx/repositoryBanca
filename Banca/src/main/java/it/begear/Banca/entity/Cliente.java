package it.begear.Banca.entity;

public class Cliente  {

	private int idCliente;

	public Cliente() {}
	
	public Cliente(int idCliente) {
		super();
		this.idCliente = idCliente;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + "]";
	}



}
