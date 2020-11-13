package it.begear.Banca.dao;

import java.util.List;

import it.begear.Banca.entity.Persona;

public interface daoPersona {
	public void createPersona(Persona persona);
	public List<Persona> readAllPersona();
	public Persona readPersona(String cf);
}
