package it.begear.Banca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.begear.Banca.entity.Conto;
import it.begear.Banca.entity.Deposito;

public class daoDepositoImpl implements daoDeposito{
	
	private static daoDepositoImpl instance;
	private daoDepositoImpl() {}
	public static daoDepositoImpl getInstance() {
		if (instance == null)
			instance = new daoDepositoImpl();
		return instance;
	}
	
	@Override
	public void createDeposito(Deposito deposito) {
		String sql = "INSERT INTO deposito(idConto,quantita,data,totale) VALUES (?,?,?,?)";
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setInt(1,deposito.getIdConto());
			stm.setInt(2,deposito.getQuantita());
			stm.setString(3,deposito.getData());
			stm.setInt(4,deposito.getTotale());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Deposito> readDeposito(int idConto) {
		String sql = "SELECT * FROM deposito WHERE idConto=?";
		List<Deposito> list = null;
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			list = new ArrayList<>();
			stm.setInt(1,idConto);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Deposito deposito = new Deposito();
				deposito.setIdConto(result.getInt("idConto"));
				deposito.setQuantita(result.getInt("quantita"));
				deposito.setData(result.getString("data"));
				deposito.setTotale(result.getInt("totale"));
				list.add(deposito);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public List<Deposito> readAll() {
		String sql = "SELECT * FROM deposito";
		List<Deposito> list = null;
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			list = new ArrayList<>();
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Deposito deposito = new Deposito();
				deposito.setIdConto(result.getInt("idConto"));
				deposito.setQuantita(result.getInt("quantita"));
				deposito.setData(result.getString("data"));
				deposito.setTotale(result.getInt("totale"));
				list.add(deposito);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}