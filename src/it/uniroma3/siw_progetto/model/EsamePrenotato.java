package it.uniroma3.siw_progetto.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.*;

@Entity
@NamedQuery(name="findAllEsamiPrenotati", query="SELECT EP FROM EsamePrenotato EP")
public class EsamePrenotato {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Paziente paziente;

	@ManyToOne
	private TipoEsame tipoEsame;

	@OneToOne(mappedBy = "EsamePrenotato", fetch = FetchType.LAZY)
	private EsameEffettuato EsameEffettuato;

	@Temporal (TemporalType.TIMESTAMP)
	private Date dataPrenotazione;

	public EsamePrenotato(){
		this.dataPrenotazione = new Date();
	}

	public EsamePrenotato(Paziente p, TipoEsame tE){
		this.paziente = p;
		this.tipoEsame = tE;
		this.dataPrenotazione = new Date();

		this.paziente.AggiungiEsamePrenotato(this);
	}

	public void setTipoEsame(TipoEsame tipoEsame) {
		this.tipoEsame = tipoEsame;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public TipoEsame getTipoEsame() {
		return tipoEsame;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public long getId() {
		return id; 
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setEsameEffettuato(EsameEffettuato esEff) {
		this.EsameEffettuato = esEff;
	}
	
	@Override
	public String toString(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		String s = "Codice fiscale del Paziente= "+this.paziente.getCodiceFiscale()+" Nome dell'esame= "+this.tipoEsame.getNome()
				+" Data prenotazione esame= "+ df.format(this.dataPrenotazione);
		return s;
	}



}
