package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Deposito;

public interface daoDeposito {
	void createDeposito(Deposito deposito);
	List<Deposito> readDeposito(int idConto);
	List<Deposito> readAll();

}
