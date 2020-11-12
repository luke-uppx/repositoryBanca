package it.begear.Banca.entity;

public class Persona {
	
	
	private String cf;
	private String nome;
	private String cognome;
	private int idCliente;
	
	
	public Persona() {}

	public Persona(String cf, String nome, String cognome, int idCliente) {
		super();
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.idCliente = idCliente;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Persona [cf=" + cf + ", nome=" + nome + ", cognome=" + cognome + ", idCliente=" + idCliente + "]";
	}
	

}
