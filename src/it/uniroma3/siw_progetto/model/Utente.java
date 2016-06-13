package it.uniroma3.siw_progetto.model;

public class Utente {
	private String username;
	private String ruolo;
	
	public Utente(String username, String ruolo){
		this.username = username;
		this.ruolo = ruolo;
	}

	public String getRuolo() {
		return ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setRuolo(String password) {
		this.ruolo = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
