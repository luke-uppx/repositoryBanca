package it.begear.Banca.controller;

import java.util.ArrayList;
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
		daoDeposito daoDeposito = daoDepositoImpl.getInstance();
		daoPrelievo daoPrelievo = daoPrelievoImpl.getInstance();

		Conto conto;
		Azienda azienda;
		Persona persona;
		Deposito deposito;
		Prelievo prelievo;
		int x, y, z;
		List<Persona> listP = daoPersona.readAllPersona();
		List<Azienda> listA = daoAzienda.readAllAzienda();
		int scelta;
		while (true) {
			System.out.print("**MENU**\n" + "1)Aprire un conto corrente fisico\n"
					+ "2)Aprire un conto corrente sociale\n" + "3)Depositare denaro per un cliente fisico\n"
					+ "4)Depositare denaro per un cliente sociale\n"
					+ "5)Prelevare denaro per un cliente fisico(limite 30% deposito medio)\n"
					+ "6)Prelevare denaro per un cliente sociale\n"
					+ "7)Visualizzare la lista di tutti i clienti con i relativi saldi\n"
					+ "8)Visualizzare la lista di tutti i clienti fisici sociali\n"
					+ "9)Visualizzare la lista di tutti i clienti sociali\n"
					+ "10)Visualizzare la lista delle operazioni di un cliente fisico\n"
					+ "11)Visualizzare la lista delle operazioni di un cliente sociale\n" + 
					"12)Esci\n" + "--> ");
			scelta = ScannerClass.readInt();
			switch (scelta) {
			case 1:
				System.out.println("inserisci cf : ");
				String cf = ScannerClass.readString();
				System.out.println("inserisci nome : ");
				String nome = ScannerClass.readString();
				System.out.println("inserisci cognome : ");
				String cognome = ScannerClass.readString();
				System.out.println("inserisci data nascita : ");
				String datanascita = ScannerClass.readString();
				persona = new Persona(cf, nome, cognome, datanascita);
				daoPersona.createPersona(persona);
				Persona p = daoPersona.readPersona(cf);
				System.out.println("inserisci data apertura : ");
				String da = ScannerClass.readString();
				System.out.println("inserisci saldo : ");
				int saldo = ScannerClass.readInt();
				conto = new Conto(da, saldo, p.getIdCliente());
				daoConto.createConto(conto);
				break;
			case 2:
				System.out.println("inserisci PV : ");
				String pv = ScannerClass.readString();
				System.out.println("inserisci ragione sociale : ");
				String rs = ScannerClass.readString();
				azienda = new Azienda(pv, rs);
				daoAzienda.createAzienda(azienda);
				Azienda a = daoAzienda.readAzienda(pv);
				System.out.println("inserisci data apertura : ");
				da = ScannerClass.readString();
				System.out.println("inserisci saldo : ");
				saldo = ScannerClass.readInt();
				conto = new Conto(da, saldo, a.getIdCliente());
				daoConto.createConto(conto);
				break;
			case 3:
				listP = daoPersona.readAllPersona();
				for (Persona persona2 : listP) {
					System.out.println(persona2);
				}
				System.out.println("inserisci cf della persona che vuole depositare: ");
				cf = ScannerClass.readString();
				System.out.println("inserisci quanto vuoi depositare");
				x = ScannerClass.readInt();
				persona = new Persona();
				persona = daoPersona.readPersona(cf);
				y = daoOperazioni.deposito(persona.getIdCliente(), x);
				deposito = new Deposito();
				deposito = daoOperazioni.searchIdConto(persona.getIdCliente());
				deposito.setQuantita(x);
				deposito.setData(" "); 
				deposito.setTotale(y);
				daoDeposito.createDeposito(deposito);
				System.out.println("il deposito effettuato è:");
				System.out.println(deposito);
				break;
			case 4:
				listA = daoAzienda.readAllAzienda();
				for (Azienda azienda2 : listA) {
					System.out.println(azienda2);
				}
				System.out.println("inserisci partita iva dell'azienda che vuole depositare");
				pv = ScannerClass.readString();
				System.out.println("inserisci quanto vuoi depositare");
				x = ScannerClass.readInt();
				azienda = new Azienda();
				azienda = daoAzienda.readAzienda(pv);
				y = daoOperazioni.deposito(azienda.getIdCliente(), x);
				deposito = new Deposito();
				deposito = daoOperazioni.searchIdConto(azienda.getIdCliente());
				deposito.setQuantita(x);
				deposito.setData(" "); 
				deposito.setTotale(y);
				daoDeposito.createDeposito(deposito);
				System.out.println("il deposito effettuato è:");
				System.out.println(deposito);
				break;
			case 5:
				listP = daoPersona.readAllPersona();
				for (Persona persona2 : listP) {
					System.out.println(persona2);
				}
				System.out.println("inserisci cf della persona che vuole prelevare: ");
				cf = ScannerClass.readString();
				persona = new Persona();
				persona = daoPersona.readPersona(cf);
				deposito = daoOperazioni.searchIdConto(persona.getIdCliente()); 
				z = daoOperazioni.serachDepositoMedio(deposito.getIdConto());
				System.out.println(
						"inserisci quanto vuoi prelevare massimo il 30% dei depositi medi cioè " + (z * 30) / 100);
				x = ScannerClass.readInt(); 
				y = daoOperazioni.prelievo(persona.getIdCliente(), x);
				prelievo = new Prelievo();
				prelievo.setIdConto(deposito.getIdConto()); 
				prelievo.setQuantita(x);
				prelievo.setData(" "); 
				prelievo.setTotale(y);
				daoPrelievo.createPrelievo(prelievo);
				System.out.println("il prelievo effettuato effettuato è:");
				System.out.println(prelievo);
				break;
			case 6:
				listA = daoAzienda.readAllAzienda();
				for (Azienda azienda2 : listA) {
					System.out.println(azienda2);
				}
				System.out.println("inserisci partita iva dell'azienda che vuole prelevare");
				pv = ScannerClass.readString();
				azienda = new Azienda();
				azienda = daoAzienda.readAzienda(pv);
				prelievo = new Prelievo();
				prelievo = daoOperazioni.searchIdConto2(azienda.getIdCliente());
				System.out.println("inserisci quanto vuoi prelevare " + prelievo.getTotale());
				x = ScannerClass.readInt(); 
				y = daoOperazioni.prelievo(azienda.getIdCliente(), x);
				prelievo.setQuantita(x);
				prelievo.setData(" "); 
				prelievo.setTotale(y);
				daoPrelievo.createPrelievo(prelievo);
				System.out.println("il prelievo effettuato è:");
				System.out.println(prelievo);
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
				break;
			case 9:
				listA = daoAzienda.readAllAzienda();
				for (Azienda azienda2 : listA) {
					System.out.println(azienda2);
				}
				break;
			case 10:
				listP = daoPersona.readAllPersona();
				for (Persona persona2 : listP) {
					System.out.println(persona2);
				}
				System.out.println("inserisci cf della persona per vesualizzare le sue operazioni ");
				cf = ScannerClass.readString();
				persona = daoPersona.readPersona(cf);
				deposito = new Deposito();
				deposito = daoOperazioni.searchIdConto(persona.getIdCliente());
				List<Deposito> list = new ArrayList<Deposito>();
				list = daoDeposito.readDeposito(deposito.getIdConto());
				for (Deposito d : list) {
					System.out.println(d);
				}
				List<Prelievo> list2 = new ArrayList<Prelievo>();
				list2 = daoPrelievo.readPrelievo(deposito.getIdConto());
				for (Prelievo pr : list2) {
					System.out.println(pr);
				}
				break;
			case 11:
				listA = daoAzienda.readAllAzienda();
				for (Azienda azienda2 : listA) {
					System.out.println(azienda2);
				}
				System.out.println("inserisci partita iva dell'azienda per visualizzare le sue operazioni");
				pv = ScannerClass.readString();
				azienda = daoAzienda.readAzienda(pv);
				deposito = new Deposito();
				deposito = daoOperazioni.searchIdConto(azienda.getIdCliente());
				List<Deposito> list3 = new ArrayList<Deposito>();
				list3 = daoDeposito.readDeposito(deposito.getIdConto());
				for (Deposito d : list3) {
					System.out.println(d);
				}
				List<Prelievo> list4 = new ArrayList<Prelievo>();
				list4 = daoPrelievo.readPrelievo(deposito.getIdConto());
				for (Prelievo pr : list4) {
					System.out.println(pr);
				}
				break;
			case 12:
				System.exit(0);
			default:
				System.out.println("Ritenta...");
				break;

			}

		}

	}

}
