package it.uniroma3.siw_progetto.model;

import java.util.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ClinicaAccessPoint {

	public ClinicaAccessPoint() {

	}

	public EsamePrenotato CreaPrenotazione (Paziente paziente, TipoEsame tE ){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		EsamePrenotato esamePronotato =  new EsamePrenotato (paziente ,tE);
		clinica.saveEsamePrenotato(esamePronotato);
		emf.close();
		return esamePronotato;
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

	public Paziente creapaziente(String string, String string2, String string3, Date object, String string4) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		Clinica clinica = new Clinica(emf);
		Paziente p= new Paziente(string, string2, string3, object, string4);
		clinica.savePaziente(p);
		emf.close();
		return p;
	}


}
