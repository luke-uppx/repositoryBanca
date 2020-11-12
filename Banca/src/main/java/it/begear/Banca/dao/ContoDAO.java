package it.begear.Banca.dao;

import java.util.List;
import it.begear.Banca.entity.Conto;

public interface ContoDAO {
	public void createConto(Conto conto);
	public Conto readConto(int idConto);
	public List<Conto> readAll();
}
