package it.begear.Banca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.begear.Banca.entity.Cliente;
import it.begear.Banca.entity.Persona;

public class daoClienteImpl implements daoCliente {

	private static daoClienteImpl instance;
	private daoClienteImpl() {}
	public static daoClienteImpl getInstance() {
		if (instance == null)
			instance = new daoClienteImpl();
		return instance;
	}
	
	@Override
	public void createCliente() {
		String sql = "INSERT INTO cliente VALUES (NULL)";
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cliente readLastCliente() {
		String sql = "SELECT * FROM cliente ORDER BY cliente.idCliente DESC LIMIT 1";
		Cliente cliente = null;
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			cliente = new Cliente();
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				cliente.setIdCliente(result.getInt("idCliente"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	
}
