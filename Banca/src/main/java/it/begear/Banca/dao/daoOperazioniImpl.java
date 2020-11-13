package it.begear.Banca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.begear.Banca.entity.Conto;
import it.begear.Banca.entity.Persona;
import it.begear.Banca.util.ScannerClass;

public class daoOperazioniImpl implements daoOperazioni {
	
	

	private static daoOperazioniImpl instance;
	private daoOperazioniImpl() {}
	public static daoOperazioniImpl getInstance() {
		if (instance == null)
			instance = new daoOperazioniImpl();
		return instance;
	}

	@Override
	public void printAllPersonaSaldo() {
		String sql = "SELECT p.cf,p.nome,p.cognome,p.dataNascita,p.idCliente,c.saldo FROM persona p INNER JOIN conto c ON p.idCliente=c.idCliente";
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			ResultSet result = stm.executeQuery();
			while (result.next()) 
				System.out.println("id cliente "+result.getString("idCliente")+" codice fiscale: "+result.getString("cf")+" nome: "+result.getString("nome")+" cognome: "+result.getString("cognome")+" data di nascita: "+result.getString("dataNascita")+" saldo:"+result.getString("saldo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printAllAziendaSaldo() {
		String sql = "SELECT a.pIVA,a.ragioneSociale,a.idCliente,c.saldo FROM azienda a INNER JOIN conto c ON a.idCliente=c.idCliente";
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			ResultSet result = stm.executeQuery();
			while (result.next()) 
				System.out.println("id azienda "+result.getString("idCliente")+" partita Iva: "+result.getString("pIVA")+" ragione sociale: "+result.getString("ragioneSociale")+" saldo:"+result.getString("saldo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	@Override
	public void deposito(int idCliente, int d) {
		daoConto daoConto = daoContoImpl.getInstance();
		Conto c=daoConto.readConto(idCliente);
		int saldo=c.getSaldo();
		String sql = "UPDATE conto SET saldo = ? WHERE idCliente = ? ";
		try(PreparedStatement stm=ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setInt(1, saldo+d);
			stm.setInt(2, idCliente);
			stm.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	



}
