package it.begear.Banca.dao;

import java.util.List;
import it.begear.Banca.entity.Conto;

public interface daoConto {
	public void createConto(Conto conto);
	public Conto readConto(int idConto);
	public List<Conto> readAll();
}
