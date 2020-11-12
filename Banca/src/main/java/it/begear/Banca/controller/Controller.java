package it.begear.Banca.controller;

import it.begear.Banca.dao.daoPersona;
import it.begear.Banca.dao.daoPersonaImpl;
import it.begear.Banca.entity.Persona;

public class Controller {

	public static void main(String[] args) {


		
		
		Persona persona = new Persona("a1", "gigi", "orefice","vfsd");
		daoPersona daoPersona = daoPersonaImpl.getInstance();
		daoPersona.createPersona(persona);
	

	}

}
