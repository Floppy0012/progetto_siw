package it.uniroma3.siw_progetto.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.uniroma3.siw_progetto.persistence.*;

//Clinica Singleton
public class Clinica {

	private static Clinica Instance;
	private PazienteDao pazientidao;
	private AmministratoreDao amministratoridao;
	private MedicoDao medicidao;
	private EsameEffettuatoDao esameeffettuatodao;
	private EsamePrenotatoDao esameprenotatodao;
	private Tipoesamedao tipoesamedao;
	private Risultatodao risultatodao;

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
		this.tipoesamedao = new Tipoesamedao(emf);
		this.risultatodao= new Risultatodao(emf);
	}

	

	public Paziente getPaziente (String CodiceFiscale){
		return this.pazientidao.findById(CodiceFiscale);
	}	
	public void savePazziente(Paziente pazziente) {
		this.pazientidao.save(pazziente);		
	}
	

	public Administrator getAmministratore(String codiceid) {
		return this.amministratoridao.findById(codiceid);
	}
	public void saveAmministratore(Administrator amminstratore) {
		this.amministratoridao.save(amminstratore);		
	}
	
	
	public TipoEsame getTipoEsame(Long id) {
		return this.tipoesamedao.findById(id);
	}
	public void saveTipoEsame(TipoEsame tipoesame) {
		this.tipoesamedao.save(tipoesame);		
	}
	
	
	public Medico getMedico(long id) {
		return this.medicidao.findById(id);
	}
	public void saveMedico(Medico medico) {
		this.medicidao.save(medico);		
	}
	
	
	public EsameEffettuato getEsameEffettuato(long id) {
		return this.esameeffettuatodao.findById(id);
	}
	public void saveEsameEffettuato(EsameEffettuato esameeffettuato) {
		this.esameeffettuatodao.save(esameeffettuato);		
	}
	
	
	public EsamePrenotato getEsamePrenotato(long id) {
		return this.esameprenotatodao.findById(id);
	}
	public void saveEsamePrenoteto(EsamePrenotato esamePronotato) {
		this.esameprenotatodao.save(esamePronotato);		
	}

	public void saveRisultato(Risultato risultato) {
		this.risultatodao.save(risultato);
		
	}
	
	
}
