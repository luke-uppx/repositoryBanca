package it.begear.Banca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.begear.Banca.entity.Persona;

public class daoPersonaImpl implements daoPersona {
	// esempio del pattern singleton
	private static daoPersonaImpl instance = null;

	// costruttore
	private daoPersonaImpl() {
		// TODO Auto-generated constructor stub
	}

	public static daoPersonaImpl getInstance() {
		if (instance == null) {
			instance = new daoPersonaImpl();
		}
		return instance;
	}

	public void createPersona(Persona persona) {
		String sql = "INSERT INTO persona(cf,nome,cognome,idCliente,dataNascita) VALUES (?,?,?,?,?)";

		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {

			stm.setString(1, persona.getCf());
			stm.setString(2, persona.getNome());
			stm.setString(3, persona.getCognome());
			stm.setInt(4, persona.getIdCliente());
			stm.setString(5, persona.getDataNascita());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
				persona.setIdCliente(result.getInt("idCliente"));
				persona.setDataNascita(result.getString("data_Nascita"));
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
				persona.setIdCliente(result.getInt("idCliente"));
				persona.setDataNascita(result.getString("dataNascita"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persona;
	}
}
