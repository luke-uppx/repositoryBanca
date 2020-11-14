package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Prelievo;



public interface daoPrelievo {
	void createPrelievo(Prelievo prelievo);
	List<Prelievo> readPrelievo(int idConto);
	public List<Prelievo> readAll();

}
