package it.begear.Banca.controller;

import it.begear.Banca.dao.daoAzienda;
import it.begear.Banca.dao.daoAziendaImpl;
import it.begear.Banca.dao.daoConto;
import it.begear.Banca.dao.daoContoImpl;
import it.begear.Banca.dao.daoPersona;
import it.begear.Banca.dao.daoPersonaImpl;
import it.begear.Banca.entity.Persona;

public class Controller {

	public static void main(String[] args) {

		daoConto daoConto = daoContoImpl.getInstance();
		daoPersona daoPersona = daoPersonaImpl.getInstance();
		daoAzienda daoAzienda = daoAziendaImpl.getInstance();

		
		Persona persona;
		
		persona = new Persona("AAAAAAAAAAAAAAAA","Mario","Rossi",1,"01/01/1990");
		//daoPersona.createPersona(persona);
		System.out.println("CREATO");
		persona = daoPersona.readPersona(persona.getCf());
		System.out.println(persona);
		
		/*('AAAAAAAAAAAAAAAB','Guido','Bianchi',STR_TO_DATE("01/01/1993","%d/%m/%Y")),
		('AAAAAAAAAAAAAAAC','Luigi','Verdi',STR_TO_DATE("01/01/1994","%d/%m/%Y")),
		('AAAAAAAAAAAAAAAD','Saverio','Gialli',STR_TO_DATE("01/01/1997","%d/%m/%Y")),
		('AAAAAAAAAAAAAAAE','Giacomo','Bruni',STR_TO_DATE("01/01/1998","%d/%m/%Y"));
		Persona persona = new Persona("AAAa", "gigi", "orefice","vfsd");
		daoPersona.createPersona(persona);


		//variabili di appoggio
		Conto conto;
		Azienda azienda;
		String cf, pIVA;
		int scelta, idConto, idCliente;

		//menu
		while(true) {

			System.out.print("**MENU**\n"
					+ "1)Aprire un conto corrente fisico o sociale\n"
					+ "2)Depositare denaro per un cliente fisico o sociale\n"
					+ "3)Prelevare denaro per un cliente fisico(limite 30% saldo) o sociale\n"
					+ "4)Visualizzare la lista di tutti i clienti con i relativi saldi\n"
					+ "5)Visualizzare la lista di tutti i clienti fisici o sociali\n"
					+ "6)Visualizzare la lista delle operazioni\n"
					+ "7)Esci\n"
					+ "--> ");
			scelta = ScannerClass.readInt();

			switch (scelta) {

			case 1: 


				break;


			case 2: 


				break;


			case 3: 


				break;


			case 4: 


				break;


			case 5:


				break;

			case 6:


				break;
				
			case 7:
				System.exit(0);

			default: 
				System.out.println("Ritenta...");
				break;

			}

		}*/

	}

}
