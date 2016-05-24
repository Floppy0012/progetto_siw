package it.uniroma3.siw_progetto.model;

import java.util.*;

public class EsamePrenotato {
private Paziente paziente;
private TipoEsame tEsame;
private Date dataPrenotazione;

	public EsamePrenotato(Paziente p, TipoEsame tE, Date dataP){
		this.paziente = p;
		this.tEsame = tE;
		this.dataPrenotazione = dataP;
		this.paziente.AggiungiEsamePrenotato(this);
	}
	
}
