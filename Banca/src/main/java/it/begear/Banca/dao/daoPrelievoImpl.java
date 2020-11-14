package it.begear.Banca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.begear.Banca.entity.Conto;
import it.begear.Banca.entity.Deposito;
import it.begear.Banca.entity.Prelievo;

public class daoPrelievoImpl implements daoPrelievo{
	
	private static daoPrelievoImpl instance;
	private daoPrelievoImpl() {}
	public static daoPrelievoImpl getInstance() {
		if (instance == null)
			instance = new daoPrelievoImpl();
		return instance;
	}
	
	@Override
	public void createPrelievo(Prelievo prelievo) {
		String sql = "INSERT INTO prelievo(idConto,quantita,data,totale) VALUES (?,?,?,?)";
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setInt(1,prelievo.getIdConto());
			stm.setInt(2,prelievo.getQuantita());
			stm.setString(3,prelievo.getData());
			stm.setInt(4,prelievo.getTotale());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Prelievo> readPrelievo(int idConto) {
		String sql = "SELECT * FROM prelievo WHERE idConto=?";
		List<Prelievo> list = null;
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			list = new ArrayList<>();
			stm.setInt(1,idConto);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Prelievo prelievo = new Prelievo();
				prelievo.setIdConto(result.getInt("idConto"));
				prelievo.setQuantita(result.getInt("quantita"));
				prelievo.setData(result.getString("data"));
				prelievo.setTotale(result.getInt("totale"));
				list.add(prelievo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Prelievo> readAll() {
		String sql = "SELECT * FROM prelievo";
		List<Prelievo> list = null;
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			list = new ArrayList<>();
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Prelievo prelievo = new Prelievo();
				prelievo.setIdConto(result.getInt("idConto"));
				prelievo.setQuantita(result.getInt("quantita"));
				prelievo.setData(result.getString("data"));
				prelievo.setTotale(result.getInt("totale"));
				list.add(prelievo);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
