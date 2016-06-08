package it.uniroma3.siw_progetto.model;

import java.util.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.siw_progetto.persistence.AmministratoreDao;
import it.uniroma3.siw_progetto.persistence.EsameEffettuatoDao;
import it.uniroma3.siw_progetto.persistence.EsamePrenotatoDao;
import it.uniroma3.siw_progetto.persistence.MedicoDao;
import it.uniroma3.siw_progetto.persistence.PazienteDao;

//Clinica Singleton
public class Clinica {
	private static final String nome = "CIRCE - CLINICA" ;

	private static Clinica Instance;
	private PazienteDao pazientidao;
	private AmministratoreDao amministratoridao;
	private MedicoDao medicidao;
	private EsameEffettuatoDao esameeffettuatodao;
	private EsamePrenotatoDao esameprenotatodao;

	//metodo statico
	public static synchronized Clinica getInstance(){
		if(Instance == null){
			Instance = new Clinica();
		}
		return Instance;
	}
	
	private Clinica(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		this.pazientidao = new PazienteDao(emf);
		this.amministratoridao = new AmministratoreDao(emf);
		this.medicidao = new MedicoDao(emf);
		this.esameeffettuatodao = new EsameEffettuatoDao(emf);
		this.esameprenotatodao = new EsamePrenotatoDao(emf);
	}

	

	public Paziente getPaziente (String CodiceFiscale){
		return this.pazientidao.findById(CodiceFiscale);
	}

	public Administrator getAmministratore(String codiceid) {
		return this.amministratoridao.findById(codiceid);

	}

	public Medico getMedico(long id) {
		return this.medicidao.findById(id);
	}

	public EsameEffettuato getEsameEffettuato(long id) {
		return null;
	}
}
