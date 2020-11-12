package it.begear.Banca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.begear.Banca.entity.Azienda;

public class daoAziendaImpl implements daoAzienda{
	
	private static daoAziendaImpl instance=null;
	
	private daoAziendaImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static daoAziendaImpl getInstance() {
		if(instance== null) {
			instance= new daoAziendaImpl();
		}
		return instance;
	}

	public void createAzienda(Azienda azienda) {
		String sql = "INSERT INTO azienda(pIVA,ragioneSociale,idCliente) VALUES (?,?,?)";
		try (PreparedStatement stm = ConnectionManager.getConnection().prepareStatement(sql)) {
			stm.setString(1, azienda.getpIVA());
			stm.setString(2, azienda.getRagioneSociale());
			stm.setInt(3, azienda.getidCliente());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	public Azienda readAzienda(int id) {
		String sql="SELECT * FROM azienda WHERE pIVA=?";
		Azienda azienda=null;
		try(PreparedStatement stm= ConnectionManager.getConnection().prepareStatement(sql)) {
			azienda=new Azienda();
			stm.setInt(1, id);
			ResultSet result=stm.executeQuery();
			
			while(result.next()) {
				azienda.setpIVA(result.getString("pIVA"));
				azienda.setRagioneSociale(result.getString("ragioneSociale"));
				azienda.setidCliente(result.getInt("idCliente"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return azienda;
	}

	public List<Azienda> readAllAzienda() {
			String sql="SELECT * FROM azienda";
			List<Azienda> list=null;
			Azienda azienda=null;
			try(PreparedStatement stm= ConnectionManager.getConnection().prepareStatement(sql)) {
				list=new ArrayList<Azienda>();
				azienda=new Azienda();
				ResultSet result=stm.executeQuery();
				while(result.next()) {
					azienda.setpIVA(result.getString("id"));
					azienda.setRagioneSociale(result.getString("ragioneSociale"));
					azienda.setidCliente(result.getInt("idCliente"));
					list.add(azienda);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	}


