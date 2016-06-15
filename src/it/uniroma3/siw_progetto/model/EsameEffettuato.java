package it.uniroma3.siw_progetto.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@NamedQuery(name= "findAllEsamiEffettuati", query="SELECT EF FROM EsameEffettuato EF")
public class EsameEffettuato {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	
	@OneToOne (fetch=FetchType.EAGER)
	private EsamePrenotato EsamePrenotato;
	
	@ManyToOne
	private Medico medico;
	
	@Temporal (TemporalType.DATE)
	private Date DataEffettuazione;
	
	@OneToMany(cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "EsameEffettuato_id")
	private List<Risultato> risultati;
	
	
	public EsameEffettuato(){
		this.risultati = new ArrayList<>();
	}

	public EsameEffettuato(Medico medico, Date data){
		this.medico = medico;
		this.DataEffettuazione = data; //nel mio controller HELPER dovrò implemenatare DateValidator validator = new DateValidator() come SIW-JDC-MVC-Es
	}


	public void setRisultato(List<Risultato> res2) {
		this.risultati = res2;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Risultato> getRisultato() {
		return this.risultati;
	}
	public Medico getMedico() {
		return medico;
	}

	public EsamePrenotato getEsamePrenotato(){
		return this.EsamePrenotato;
	}
	
	public void setEsamePrenotato(EsamePrenotato esPren) {
		this.EsamePrenotato = esPren;
	}
	
	@Override
	public String toString(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		String s = "Data Effettuazione = "+df.format(this.DataEffettuazione)+" "+
				  EsamePrenotato.toString()+"\n";
		return s; 
	}
	


}