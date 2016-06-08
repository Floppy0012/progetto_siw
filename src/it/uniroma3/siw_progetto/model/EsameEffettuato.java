package it.uniroma3.siw_progetto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class EsameEffettuato extends EsamePrenotato{

	@ManyToOne
	private Medico medico;
	
	@ManyToMany
	private List<Risultato> risultati;

	public EsameEffettuato(){
		//super();
		this.risultati = new ArrayList<>();
	}

	public EsameEffettuato(Medico medico){
		this.medico = medico;
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


}