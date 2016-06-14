package it.uniroma3.siw_progetto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="findmedico", query="SELECT m FROM Medico m Where m.nome = ? and m.cognome= ?")
public class Medico {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column//(nullable= false)
	private String nome;
	
	@Column//(nullable= false)
	private String cognome;
	
	@Column //(nullable= false)
	private String specialistica;
	
	@OneToMany(mappedBy="medico",fetch= FetchType.EAGER)
	private List<EsameEffettuato> esamieffettuati;

	public Medico(){
		this.esamieffettuati= new ArrayList<>();
	}

	public Medico (String nome, String cognome,String specialistica){
		this.nome=nome;
		this.cognome=cognome;
		this.specialistica= specialistica;
	}

	public List<EsameEffettuato> mostraesami() {
		return this.esamieffettuati;
	}
	
	public void AddEsameEffettuato (EsameEffettuato esEffettuato){
		this.esamieffettuati.add(esEffettuato);
	}
	
	public void setSpecialistica(String specialistica) {
		this.specialistica = specialistica;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setEsamieffettuati(List<EsameEffettuato> esamieffettuati) {
		this.esamieffettuati = esamieffettuati;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getSpecialistica() {
		return specialistica;
	}
	
	public String getNome() {
		return nome;
	}
	
	public long getId() {
		return id;
	}
	
	public List<EsameEffettuato> getEsamieffettuati() {
		return esamieffettuati;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String stampaLista(){
		String s = null; 
		for(EsameEffettuato esEff : this.esamieffettuati){
			s+= esEff.toString();
		}
		return s;
	}
	
	
}
