package it.uniroma3.siw_progetto.model;

public class Medico {
	private String nome;
	private String cognome;
	private String specialistica;
	
	public Medico(){}
	
	public Medico (String nome, String cognome,String specialistica){
		this.nome=nome;
		this.cognome=cognome;
		this.specialistica= specialistica;
	}
}
