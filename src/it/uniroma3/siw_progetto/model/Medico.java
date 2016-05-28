package it.uniroma3.siw_progetto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
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
	@OneToMany(mappedBy="medico")
	private List<EsameEffettuato> esamieffettuati;

	public Medico(){
		this.esamieffettuati= new ArrayList<>();
	}

	public Medico (String nome, String cognome,String specialistica){
		this.nome=nome;
		this.cognome=cognome;
		this.specialistica= specialistica;
	}
}
