package it.uniroma3.siw_progetto.model;

import java.util.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ClinicaAccessPoint {

	private Paziente pazienteCorr;
	//	private Administrator aministratoreCorr;
	//private Clinica clinica;


	public ClinicaAccessPoint() {
		//this.clinica = new Clinica();
	}

	public void CreaPrenotazione (String CodiceFiscale, long CodiceTipologia ){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		this.pazienteCorr = clinica.getPaziente(CodiceFiscale);
		TipoEsame tEsame = clinica.getTipoEsame(CodiceTipologia);
		EsamePrenotato esamePronotato =  new EsamePrenotato (this.pazienteCorr,tEsame);
		clinica.saveEsamePrenotato(esamePronotato);
		emf.close();
	}

	public TipoEsame creaTipoesame(String nome, String descrizione, float costo, List<Prerequisito> prerequisiti){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		TipoEsame tipoEsame = new TipoEsame(nome, descrizione,costo, prerequisiti);
		clinica.saveTipoEsame(tipoEsame);
		emf.close();
		return tipoEsame;
	}

	public List<EsameEffettuato> VisualizzaEsamiMedico(Medico medico){
		return medico.mostraesami();
	}

	public void InserimentoRisultatiEsame(long id/*,elementi per il risultato da creare*/) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		EsameEffettuato ef = clinica.getEsameEffettuato(id);
		ef.creaRisultato(clinica/*, elementi del risultato*/);
		emf.close();
	}



	public List<Prerequisito> getTuttiPrerequisiti() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		List<Prerequisito> Tuttiprerequisiti = clinica.getTuttiprerequisiti();
		emf.close();
		return Tuttiprerequisiti;
	}

	public Prerequisito getprerequisito(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		Prerequisito p = clinica.getPrerequisito(nome);
		emf.close();
		return p;
	}

	public TipoEsame getTipoEsame(Long id) {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		TipoEsame tipoEsame = clinica.getTipoEsame(id);
		emf.close();
		return tipoEsame;
	}

	public List<TipoEsame> getTuttiTipoEsame() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		List<TipoEsame> TuttiTipoEsame = clinica.getTuttiTipoEsame();
		emf.close();
		return TuttiTipoEsame;
	}

	public Paziente getPaziente(String username) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		Paziente p = clinica.getPaziente(username);
		emf.close();
		return p;
	}

	public Administrator getAmministratore(String username) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		Administrator a = clinica.getAmministratore(username);
		emf.close();
		return a;
	}


	public void creaPrerequisito(Prerequisito prerequisito) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		clinica.savePrerequisito(prerequisito);
		emf.close();
	}

	public void updateTipoesame(TipoEsame tipoEsame) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		clinica.AggiornaTipoesame(tipoEsame);
		emf.close();
	}

	public Medico getMedico(String nome, String cognome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		Medico m = clinica.getMedico(nome, cognome);
		emf.close();
		return m;
	}

	public void salvaAmministratore(Administrator administrator) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		clinica.saveAmministratore(administrator);
		emf.close();
	}

	public void salvaPaziente(Paziente paziente) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		clinica.savePaziente(paziente);
		emf.close();
	}

	public TipoEsame PrendiTipoesame(String nometipoesame) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		TipoEsame t= clinica.PrendiTipoesame(nometipoesame);
				emf.close();
		return t;
	}
}
