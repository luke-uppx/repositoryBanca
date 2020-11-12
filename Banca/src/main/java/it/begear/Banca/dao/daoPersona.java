package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Persona;

public interface daoPersona {

	
	void createPersona(Persona persona);
	
	List<Persona> readAllPersona();
	
	Persona readPersona(String cf);
	
	
	
}
