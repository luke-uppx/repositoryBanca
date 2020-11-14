package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Deposito;
import it.begear.Banca.entity.Persona;
import it.begear.Banca.entity.Prelievo;

public interface daoOperazioni {
	void printAllPersonaSaldo();
	void printAllAziendaSaldo();
	int deposito(int idCliente, int i);
	Deposito searchIdConto(int idCliente);
	int serachDepositoMedio(int idConto);
	int prelievo(int idCliente, int p);
	Prelievo searchIdConto2(int idCliente);
}
