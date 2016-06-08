package it.uniroma3.siw_progetto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@NamedQuery(name="findAllEsamiEffettuati", query="SELECT EF FROM EsameEffetuato EF")
public class EsameEffettuato {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	
	@OneToOne
	private EsamePrenotato EsamePrenotato;
	
	@ManyToOne
	private Medico medico;
	
	@Temporal (TemporalType.DATE)
	private Date DataEffettuazione;
	
	@OneToMany(cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "Risultato_Id")
	private List<Risultato> risultati;
	
	
	public EsameEffettuato(){
		this.risultati = new ArrayList<>();
	}

	public EsameEffettuato(Medico medico, Date data){
		this.medico = medico;
		this.DataEffettuazione = data; //nel mio controller HELPER dovrò implemenatare DateValidator validator = new DateValidator() come SIW-JDC-MVC-Es
	}

	public void creaRisultato(/*elemetni*/) {
		Risultato risultato= new Risultato(/*elementi*/);
		this.AddRisulato(risultato);
	}

	public void AddRisulato (Risultato ris){
		this.risultati.add(ris);
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

	public void setEsamePrenotato(EsamePrenotato esPren) {
		this.EsamePrenotato = esPren;
	}
	
	


}