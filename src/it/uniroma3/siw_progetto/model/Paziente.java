package it.uniroma3.siw_progetto.model;

import java.util.*;
import javax.persistence.*;



@Entity
@NamedQuery(name="findAllPazienti", query="SELECT p FROM Paziente p")
public class Paziente {

	@Id
	private String codiceFiscale;
	

	private String nome; 
	
	
	private String cognome;
	
	@Temporal (TemporalType.DATE)
	private Date dataNascita;
	
	private String password; //Come criptare?
	
	@OneToMany(mappedBy= "paziente",fetch=FetchType.EAGER)
	private List<EsamePrenotato> esamiPrenotati;

	

	public Paziente (String cf,String nome,String cognome,Date datanascita,String psw){
		this.codiceFiscale=cf;
		this.cognome=cognome;
		this.dataNascita=datanascita;
		this.nome=nome;
		this.password=psw;
		this.esamiPrenotati = new ArrayList<>();
	}

	public Paziente(){
		this.esamiPrenotati = new ArrayList<>();
	}
	public void AggiungiEsamePrenotato (EsamePrenotato ePrenotato){
		this.esamiPrenotati.add(ePrenotato);
	}

	public boolean CheckPassword(String s){
		return this.password.equals(s);
	}
	
	public void AddEsamePrenotato (EsamePrenotato EsPr){
		this.esamiPrenotati.add(EsPr);
	}
	
	/*
	 * Metodi Set e Get
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEsamiPrenotati(List<EsamePrenotato> esamiPrenotati) {
		this.esamiPrenotati = esamiPrenotati;
	}
	
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<EsamePrenotato> getEsamiPrenotati() {
		return esamiPrenotati;
	}
	
	public Date getDataNascita() {
		return dataNascita;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
}
