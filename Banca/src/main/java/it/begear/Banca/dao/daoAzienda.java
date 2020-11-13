package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Azienda;

public interface daoAzienda {
	public void createAzienda(Azienda azienda);
	public Azienda readAzienda(int id);
	public List<Azienda> readAllAzienda();
}
