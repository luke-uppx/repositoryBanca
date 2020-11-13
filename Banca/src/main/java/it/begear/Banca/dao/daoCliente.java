package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Cliente;

public interface daoCliente {
	public void createCliente();
	public Cliente readLastCliente();
}
