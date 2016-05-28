package it.uniroma3.siw_progetto.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class EsamePrenotato {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Paziente paziente;
	@ManyToOne
	private TipoEsame tipoEsame;
	@Temporal (TemporalType.TIMESTAMP)
	private Date dataPrenotazione;

	public EsamePrenotato(){
		this.dataPrenotazione=new Date();
	}
	
	public EsamePrenotato(Paziente p, TipoEsame tE){
		this.paziente = p;
		this.tipoEsame = tE;
		this.dataPrenotazione = new Date();

		this.paziente.AggiungiEsamePrenotato(this);
	}

}
