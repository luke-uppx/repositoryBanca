package it.begear.Banca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.begear.Banca.entity.Conto;
import it.begear.Banca.entity.Deposito;
import it.begear.Banca.entity.Persona;
import it.begear.Banca.entity.Prelievo;
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
	public int deposito(int idCliente, int d) {
		daoConto daoConto = daoContoImpl.getInstance();
		Conto c=daoConto.readConto(idCliente);
		int saldo=c.getSaldo()+d;
		String sql = "UPDATE conto SET saldo = ? WHERE idCliente = ? ";
		try(PreparedStatement stm=ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setInt(1, saldo);
			stm.setInt(2, idCliente);
			stm.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return saldo;
	}
	
	@Override
	public Deposito searchIdConto(int idCliente) {
		String sql = "SELECT idConto FROM conto WHERE idCliente = ? ";
		Deposito deposito=null;
		try(PreparedStatement stm=ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setInt(1, idCliente);
			deposito=new Deposito();
			ResultSet result = stm.executeQuery();
			while (result.next()) 
				deposito.setIdConto(result.getInt("idConto"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return deposito;
	}
	
	
	
	@Override
	public int serachDepositoMedio(int idConto) {
		String sql = "SELECT AVG(quantita) FROM deposito WHERE idConto =? ";
		float media=0;
		try(PreparedStatement stm=ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setInt(1, idConto);
			ResultSet result = stm.executeQuery();
			while (result.next()) 
				media=result.getFloat(1);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		int val = Math.round(media);
		return val;
	}
	
	@Override
	public int prelievo(int idCliente, int p) {
		daoConto daoConto = daoContoImpl.getInstance();
		Conto c=daoConto.readConto(idCliente);
		int saldo=c.getSaldo()-p;
		String sql = "UPDATE conto SET saldo = ? WHERE idCliente = ? ";
		try(PreparedStatement stm=ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setInt(1, saldo);
			stm.setInt(2, idCliente);
			stm.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return saldo;
	}
	
	@Override                
	public Prelievo searchIdConto2(int idCliente) {
		String sql = "SELECT idConto,saldo FROM conto WHERE idCliente = ? ";
		Prelievo prelievo=null;
		try(PreparedStatement stm=ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setInt(1, idCliente);
			prelievo=new Prelievo();
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				prelievo.setIdConto(result.getInt("idConto"));
			    prelievo.setTotale(result.getInt("saldo"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return prelievo;
	}
	
	
	
	
	
	
	



}
