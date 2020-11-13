package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Azienda;

public interface daoAzienda {
	public void createAzienda(Azienda azienda);
	public Azienda readAzienda(String pIVA);
	public List<Azienda> readAllAzienda();
}
