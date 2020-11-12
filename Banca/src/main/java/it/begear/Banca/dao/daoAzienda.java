package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Azienda;

public interface daoAzienda {
	
	
		void createAzienda(Azienda azienda);
		Azienda readAzienda(int id);
		List<Azienda> readAllAzienda();
	


}
