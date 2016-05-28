package it.uniroma3.siw_progetto.model;

import javax.persistence.*;

@Entity
public class EsameEffettuato extends EsamePrenotato{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Medico medico;
	//private Risultato risultato;

	public EsameEffettuato(){
		super();
	}

	public EsameEffettuato(Paziente p, TipoEsame tE,Medico medico){
		super(p,tE);
		this.medico=medico;
	}
}
