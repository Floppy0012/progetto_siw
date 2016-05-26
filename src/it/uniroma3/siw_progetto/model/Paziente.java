package it.uniroma3.siw_progetto.model;

import java.util.*;
import javax.persistence.*;



@Entity
public class Paziente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(unique=true)
	private String codiceFiscale;
	@Column(nullable=false)
	private String nome; 
	@Column(nullable=false)
	private String cognome;
    @Temporal (TemporalType.DATE)
	private Date dataNascita;
    //da vedere come rendere criptato nella base di dati
	private String password;
	@OneToMany(mappedBy="paziente")
	private List<EsamePrenotato> esamiPrenotati;//POLIMORFISMO???
	@OneToMany(mappedBy="paziente")
	private List<EsameEffettuato> esamiEffettuati;//POLIMORFISMO???

	
	public Paziente (String cf,String nome,String cognome,Date datanascita,String psw){
		this.codiceFiscale=cf;
		this.cognome=cognome;
		this.dataNascita=datanascita;
		this.nome=nome;
		this.password=psw;
	}
	
	public Paziente(){
		this.esamiEffettuati= new ArrayList<>();
		this.esamiPrenotati=new ArrayList<>();
	}
	public void AggiungiEsamePrenotato (EsamePrenotato ePrenotato){
		this.esamiPrenotati.add(ePrenotato);
	}

	public boolean CheckPassword(String s){
		return this.password.equals(s);
	}
}
