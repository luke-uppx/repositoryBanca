package it.begear.Banca.controller;

import java.util.List;
import it.begear.Banca.dao.*;
import it.begear.Banca.entity.*;

public class Controller {

	public static void main(String[] args) {

		daoConto daoConto = daoContoImpl.getInstance();
		daoPersona daoPersona = daoPersonaImpl.getInstance();
		daoAzienda daoAzienda = daoAziendaImpl.getInstance();
		
		
		Persona persona;
		persona = new Persona("AAAAAAAAAAAAAAAA","Mario","Rossi","01/01/1990");
		daoPersona.createPersona(persona);
		persona = new Persona("AAAAAAAAAAAAAAAB","Guido","Bianchi","01/01/1993");
		daoPersona.createPersona(persona);
		persona = new Persona("AAAAAAAAAAAAAAAC","Luigi","Verdi","01/01/1994");
		daoPersona.createPersona(persona);
		persona = new Persona("AAAAAAAAAAAAAAAD","Saverio","Gialli","01/01/1997");
		daoPersona.createPersona(persona);
		persona = new Persona("AAAAAAAAAAAAAAAE","Giacomo","Bruni","01/01/1998");
		daoPersona.createPersona(persona);
		
		List<Persona> listP = daoPersona.readAllPersona();
		
		
		Conto conto;
		conto = new Conto("01/01/2010",10999, listP.get(0).getIdCliente());
		daoConto.createConto(conto);
		conto = new Conto("01/01/2011",300, listP.get(1).getIdCliente());
		daoConto.createConto(conto);
		conto = new Conto("22/02/2000",1200, listP.get(2).getIdCliente());
		daoConto.createConto(conto);
		conto = new Conto("22/03/2001",1100, listP.get(3).getIdCliente());
		daoConto.createConto(conto);
		conto = new Conto("22/04/2002",1000, listP.get(4).getIdCliente());
		daoConto.createConto(conto);
		
		

		
		

		/*//variabili di appoggio
		Conto conto;
		Azienda azienda;
		String cf, pIVA;
		int scelta, idConto, idCliente;

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
