package it.uniroma3.siw_progetto.model;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import it.uniroma3.siw_progetto.persistence.*;

public class Clinica {

	private PazienteDao pazientidao;
	private AmministratoreDao amministratoridao;
	private MedicoDao medicidao;
	private EsameEffettuatoDao esameeffettuatodao;
	private EsamePrenotatoDao esameprenotatodao;
	private Tipoesamedao tipoesamedao;
	private Risultatodao risultatodao;
	private PrerequisitoDao prerequisitodao;
	private EntityManagerFactory emf;

	public Clinica(EntityManagerFactory emf){
		this.pazientidao = new PazienteDao(emf);
		this.amministratoridao = new AmministratoreDao(emf);
		this.medicidao = new MedicoDao(emf);
		this.esameeffettuatodao = new EsameEffettuatoDao(emf);
		this.esameprenotatodao = new EsamePrenotatoDao(emf);
		this.tipoesamedao = new Tipoesamedao(emf);
		this.risultatodao= new Risultatodao(emf);
		this.prerequisitodao = new PrerequisitoDao(emf);
	}

	

	public Paziente getPaziente (String CodiceFiscale){
		return this.pazientidao.findById(CodiceFiscale);
	}	
	
	public void savePaziente(Paziente pazziente) {
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
	
	public void saveEsamePrenotato(EsamePrenotato esamePronotato) {
		this.esameprenotatodao.save(esamePronotato);		
	}
	
	public Risultato getRisultato (long id){
		return this.risultatodao.findById(id);
	}
	
	public void saveRisultato(Risultato risultato) {
		this.risultatodao.save(risultato);
	}
	
	public Prerequisito getPrerequisito(String nome){
		return this.prerequisitodao.findById(nome);
	}
	
	public void savePrerequisito (Prerequisito prerequisito){
		this.prerequisitodao.save(prerequisito);
	}



	public List<Prerequisito> getTuttiprerequisiti() {
		return this.prerequisitodao.findAll();
	}



	public List<TipoEsame> getTuttiTipoEsame() {
		return this.tipoesamedao.findAll();
	}
	
	public void closeEntityManagerFactory(){
		this.emf.close();
	}



	public void AggiornaTipoesame(TipoEsame tipoEsame) {
		this.tipoesamedao.update(tipoEsame);
		
	}



	public Medico getMedico(String nome, String cognome) {	
		return this.medicidao.getMedico(nome,cognome);
	}



	public TipoEsame PrendiTipoesame(String nometipoesame) {		
		return this.tipoesamedao.getTipoesame(nometipoesame);
	}
	
	
}
