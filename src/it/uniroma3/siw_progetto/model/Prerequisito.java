package it.uniroma3.siw_progetto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findAllPrerequisiti", query="SELECT p FROM Prerequisito p")
public class Prerequisito {

	@Id
	private String nome;
	
	@Column(length=500)
	private String descrizione;

	public Prerequisito(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public Prerequisito() {

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
		Prerequisito prerequisito= (Prerequisito) obj;
		return this.nome.equals(prerequisito.nome);
	}

	@Override
	public String toString() {
		return "Prerequisito [nome=" + nome + ", descrizione=" + descrizione + "]";
	}




}