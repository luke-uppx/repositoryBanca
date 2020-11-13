package it.begear.Banca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.begear.Banca.entity.Cliente;
import it.begear.Banca.entity.Persona;

public class daoPersonaImpl implements daoPersona {
	
	private static daoPersonaImpl instance = null;

	private daoPersonaImpl() {}

	public static daoPersonaImpl getInstance() {
		if (instance == null) {
			instance = new daoPersonaImpl();
		}
		return instance;
	}

	@Override
	public void createPersona(Persona persona) {
		
		daoCliente daoCliente = daoClienteImpl.getInstance();
		daoCliente.createCliente();
		Cliente cliente = daoCliente.readLastCliente();
		
		String sql = "INSERT INTO persona(cf,nome,cognome,dataNascita,idCliente) VALUES (?,?,?,?,?)";
		
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			
			stm.setString(1, persona.getCf());
			stm.setString(2, persona.getNome());
			stm.setString(3, persona.getCognome());
			stm.setString(4, persona.getDataNascita());
			stm.setInt(5, cliente.getIdCliente());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Persona> readAllPersona() {
		String sql = "SELECT * FROM persona";
		List<Persona> list = null;
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			list = new ArrayList<Persona>();
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Persona persona = new Persona();
				persona.setCf(result.getString("cf"));
				persona.setNome(result.getString("nome"));
				persona.setCognome(result.getString("cognome"));
				persona.setDataNascita(result.getString("dataNascita"));
				persona.setIdCliente(result.getInt("idCliente"));
				list.add(persona);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Persona readPersona(String cf) {
		String sql = "SELECT * FROM persona WHERE cf = ?";
		Persona persona = null;

		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			persona = new Persona();
			stm.setString(1, cf);
			ResultSet result = stm.executeQuery();

			while (result.next()) {
				persona.setCf(result.getString("cf"));
				persona.setNome(result.getString("nome"));
				persona.setCognome(result.getString("cognome"));
				persona.setDataNascita(result.getString("dataNascita"));
				persona.setIdCliente(result.getInt("idCliente"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persona;
	}
}
