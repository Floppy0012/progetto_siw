package it.uniroma3.siw_progetto.model;

import java.util.*;

public class Clinica {
private static final String nome = "CIRCE - CLINICA" ;
private Map<String,Paziente> pazienti;

	public Paziente FindPazienteByCodiceFiscale (String CodiceFiscale){
		Paziente p = this.pazienti.get(CodiceFiscale);
		return p;
	}
}
