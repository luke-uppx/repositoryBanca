package it.begear.Banca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import it.begear.Banca.entity.Conto;

public class daoContoImpl implements daoConto {

	private static daoContoImpl instance;
	private daoContoImpl() {}
	public static daoContoImpl getInstance() {
		if (instance == null)
			instance = new daoContoImpl();
		return instance;
	}

	public void createConto(Conto conto) {
		String sql = "INSERT INTO conto(dataApertura,saldo) VALUES (?,?)";
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setString(1,conto.getDataApertura());
			stm.setInt(2,conto.getSaldo());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Conto readConto(int idConto) {
		String sql = "SELECT * FROM conto WHERE idConto=?";
		Conto conto = null;
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			conto = new Conto();
			stm.setInt(1,idConto);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				conto.setIdConto(result.getInt("id"));
				conto.setDataApertura(result.getString("dataApertura"));
				conto.setSaldo(result.getInt("saldo"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conto;
	}

	public List<Conto> readAll() {
		String sql = "SELECT * FROM conto";
		List<Conto> list = null;
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			list = new ArrayList<>();
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Conto conto = new Conto();
				conto.setIdConto(result.getInt("id"));
				conto.setDataApertura(result.getString("dataApertura"));
				conto.setSaldo(result.getInt("saldo"));
				list.add(conto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
