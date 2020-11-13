package it.begear.Banca.controller;

import java.util.List;
import it.begear.Banca.dao.*;
import it.begear.Banca.entity.*;
import it.begear.Banca.util.ScannerClass;

public class Controller {

	public static void main(String[] args) {

		daoConto daoConto = daoContoImpl.getInstance();
		daoPersona daoPersona = daoPersonaImpl.getInstance();
		daoAzienda daoAzienda = daoAziendaImpl.getInstance();
		daoOperazioni daoOperazioni = daoOperazioniImpl.getInstance();
		
		Conto conto;
		Azienda azienda;
		Persona persona;
		List<Persona> listP = daoPersona.readAllPersona();
		List<Azienda> listA = daoAzienda.readAllAzienda();

		int scelta;
		while(true) {
			System.out.print("**MENU**\n"
					+ "1)Aprire un conto corrente fisico\n"
					+ "2)Aprire un conto corrente sociale\n"
					+ "3)Depositare denaro per un cliente fisico\n"
					+ "4)Depositare denaro per un cliente sociale\n"
					+ "5)Prelevare denaro per un cliente fisico(limite 30% saldo)\n"
					+ "6)Prelevare denaro per un cliente sociale\n"
					+ "7)Visualizzare la lista di tutti i clienti con i relativi saldi\n"
					+ "8)Visualizzare la lista di tutti i clienti fisici o sociali\n"
					+ "9)Esci\n"
					+ "--> ");
			scelta = ScannerClass.readInt();

			switch (scelta) {

			case 1: 
				System.out.println("inserisci cf : ");
				String cf= ScannerClass.readString();
				System.out.println("inserisci nome : ");
				String nome= ScannerClass.readString();
				System.out.println("inserisci cognome : ");
				String cognome= ScannerClass.readString();
				System.out.println("inserisci data nascita : ");
				String datanascita= ScannerClass.readString();
				persona= new Persona(cf,nome,cognome,datanascita);
				daoPersona.createPersona(persona);
				Persona p = daoPersona.readPersona(cf);
				System.out.println("inserisci data apertura : ");
				String da= ScannerClass.readString();
				System.out.println("inserisci saldo : ");
				int saldo= ScannerClass.readInt();
				conto = new Conto(da,saldo, p.getIdCliente());
				daoConto.createConto(conto);

				
				break;

			case 2: 
				System.out.println("inserisci PV : ");
				String pv= ScannerClass.readString();
				System.out.println("inserisci ragione sociale : ");
				String rs= ScannerClass.readString();
				azienda = new Azienda (pv,rs);
				daoAzienda.createAzienda(azienda);
				Azienda a = daoAzienda.readAzienda(pv);
				System.out.println("inserisci data apertura : ");
				da= ScannerClass.readString();
				System.out.println("inserisci saldo : ");
				saldo= ScannerClass.readInt();
				conto = new Conto(da,saldo, a.getIdCliente());
				daoConto.createConto(conto);
				
				
				break;

			case 3: 
				listP = daoPersona.readAllPersona();
				for (Persona persona2 : listP) {
					System.out.println(persona2);
				}
				System.out.println("inserisci cf della persona che vuole depositare: ");
				cf= ScannerClass.readString();
				System.out.println("inserisci quanto vuoi depositare");
				int x=ScannerClass.readInt();
				Persona p2=daoPersona.readPersona(cf);
				daoOperazioni.deposito(p2.getIdCliente(),x);
				break;
			case 4: 
				listA = daoAzienda.readAllAzienda();
				for (Azienda azienda2 : listA) {
					System.out.println(azienda2);
				}
				System.out.println("inserisci partita iva dell'azienda che vuole depositare");
				pv= ScannerClass.readString();
				System.out.println("inserisci quanto vuoi depositare");
				x=ScannerClass.readInt();
				Azienda a2=daoAzienda.readAzienda(pv);
				daoOperazioni.deposito(a2.getIdCliente(),x);
				break;
			case 5:


				break;

			case 6:


				break;

			case 7:
				daoOperazioni.printAllPersonaSaldo();
				daoOperazioni.printAllAziendaSaldo();
				break;
			case 8:
				listP = daoPersona.readAllPersona();
				for (Persona persona2 : listP) {
					System.out.println(persona2);
				}
				listA = daoAzienda.readAllAzienda();
				for (Azienda azienda2 : listA) {
					System.out.println(azienda2);
				}
				break;
			case 9:
				System.exit(0);


			default: 
				System.out.println("Ritenta...");
				break;

			}

		}

	}

}

