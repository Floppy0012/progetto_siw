package it.uniroma3.siw_progetto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Risultato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long IdRisulato;
	
	@Column(length=500)
	private String descrizione;
	
	@Column(nullable=false)
	private String nome;
	
	@ManyToOne
	private EsameEffettuato esameEffettuato;

	public Risultato(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public Risultato() {

	}
	
	
	public long getIdRisulato() {
		return IdRisulato;
	}
	
	public void setIdRisulato(long idRisulato) {
		IdRisulato = idRisulato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Risultato risultato= (Risultato) obj;
		return this.nome.equals(risultato.nome);
	}

	@Override
	public String toString() {
		return "Prerequisito [nome=" + nome + ", descrizione=" + descrizione + "]";
	}




}