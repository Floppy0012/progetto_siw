package it.uniroma3.siw_progetto.model;

import java.util.*;

public class Clinica {
	private static final String nome = "CIRCE - CLINICA" ;

	private PazienteDao pazientidao;
	private AmministratoreDao amministratoridao;

	public Paziente getPaziente (String CodiceFiscale){
		return this.pazientidao.find(CodiceFiscale);
	}

	public Administrator getAmministratore(String codiceid) {
		return this.amministratoridao.find(codiceid);

	}
}
