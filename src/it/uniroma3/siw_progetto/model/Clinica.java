package it.uniroma3.siw_progetto.model;

import java.util.*;

public class Clinica {
	private static final String nome = "CIRCE - CLINICA" ;
	private Map<String,Paziente> pazienti;
	private Map<String,Administrator>amministrators;

	public Paziente getPaziente (String CodiceFiscale){
		return this.pazienti.get(CodiceFiscale);
	}

	public Administrator getAmministratore(String codiceid) {
		return this.amministrators.get(codiceid);

	}
}
