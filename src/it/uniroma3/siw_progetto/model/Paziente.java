package it.uniroma3.siw_progetto.model;

import java.util.*;

/*
 * Paziente registrato, pronto per la prentazione
 */
public class Paziente {
	private String codiceFiscale;
	private String nome; 
	private String cognome;
	private Date dataNascita;
	private String password;
	private List<EsamePrenotato> esamiPrenotati;//POLIMORFISMO???
	private List<EsameEffettuato> esamiEffettuati;//POLIMORFISMO???

	public void AggiungiEsamePrenotato (EsamePrenotato ePrenotato){
		this.esamiPrenotati.add(ePrenotato);
	}

}
