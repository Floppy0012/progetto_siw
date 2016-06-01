package it.uniroma3.siw_progetto.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

@Entity
public class TipoEsame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable= false)
	private String nome;

	private String descrizione;

	private float costo;

	@ManyToMany
	private List<Prerequisito> prerequisiti; 

	public TipoEsame(){
		this.prerequisiti= new ArrayList<>();
	}

	public TipoEsame(String nome, String descrizione, float costo, List<Prerequisito> prerequisiti){
		this.costo=costo;
		this.descrizione= descrizione;
		this.nome=nome;
		this.prerequisiti = prerequisiti;
	}

	public void AddPrerequisiti (Prerequisito prerequisito){
		this.prerequisiti.add(prerequisito);
	}
	
	public float getCosto() {
		return costo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setPrerequisiti(List<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	} 

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public List<Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}

	public String getNome() {
		return nome;
	}


}
