package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Persona;

public interface daoOperazioni {
	void printAllPersonaSaldo();
	void printAllAziendaSaldo();
	void deposito(int idCliente, int i);

}
