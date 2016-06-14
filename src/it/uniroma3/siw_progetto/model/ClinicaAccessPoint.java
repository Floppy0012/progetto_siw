package it.uniroma3.siw_progetto.model;

import java.util.*;


public class ClinicaAccessPoint {

	private Paziente pazienteCorr;
//	private Administrator aministratoreCorr;
	private Clinica clinica;
	
	
	 public ClinicaAccessPoint() {
		this.clinica= new Clinica();
	}
	
	public void CreaPrenotazione (String CodiceFiscale, long CodiceTipologia ){
		this.pazienteCorr = this.clinica.getPaziente(CodiceFiscale);
		TipoEsame tEsame = this.clinica.getTipoEsame(CodiceTipologia);
		EsamePrenotato esamePronotato =  new EsamePrenotato (this.pazienteCorr,tEsame);
		this.clinica.saveEsamePrenotato(esamePronotato);
	}

	public TipoEsame creaTipoesame(String nome, String descrizione, float costo, List<Prerequisito> prerequisiti){
		TipoEsame tipoEsame = new TipoEsame(nome, descrizione,costo, prerequisiti);
		this.clinica.saveTipoEsame(tipoEsame);		
		return tipoEsame;
	}

	public List<EsameEffettuato> VisualizzaEsamiMedico(Medico medico){
		return medico.mostraesami();
	}

	public void InserimentoRisultatiEsame(long id/*,elementi per il risultato da creare*/) {
		EsameEffettuato ef = this.clinica.getEsameEffettuato(id);
		ef.creaRisultato(this.clinica/*, elementi del risultato*/);
		this.clinica.closeEntityManagerFactory();
	}

	public List<Prerequisito> getTuttiPrerequisiti() {
		return clinica.getTuttiprerequisiti();
	}

	public Prerequisito getprerequisito(String nome) {
		return clinica.getPrerequisito(nome);
	}

	public TipoEsame getTipoEsame(Long id) {		
		return this.clinica.getTipoEsame(id);
	}

	public List<TipoEsame> getTuttiTipoEsame() {
		return clinica.getTuttiTipoEsame();
	}

	public Paziente getPaziente(String username) {
		return clinica.getPaziente(username);
	}

	public Administrator getAmministratore(String username) {
		return clinica.getAmministratore(username);
	}

	public void closeEntityManagerFactory() {
		this.clinica.closeEntityManagerFactory();
	}

	public void creaPrerequisito(Prerequisito prerequisito) {
		this.clinica.savePrerequisito(prerequisito);
		
	}

	public void updateTipoesame(TipoEsame tipoEsame) {
		this.clinica.AggiornaTipoesame(tipoEsame);
	}

	public Medico getMedico(String nome, String cognome) {
		return this.clinica.getMedico(nome, cognome);
	}

	public void salvaAmministratore(Administrator administrator) {
		this.clinica.saveAmministratore(administrator);	
	}
}
