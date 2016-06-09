package it.uniroma3.siw_progetto.model;

import java.util.*;


//DA SISTEMARE
public class ClinicaAccessPoint {

	private Paziente pazienteCorr;
	private Administrator aministratoreCorr;

	
	public void CreaPrenotazione (String CodiceFiscale, long CodiceTipologia ){
		this.pazienteCorr = Clinica.getInstance().getPaziente(CodiceFiscale);
		TipoEsame tEsame = Clinica.getInstance().getTipoEsame(CodiceTipologia);
		EsamePrenotato esamePronotato =  new EsamePrenotato (this.pazienteCorr,tEsame);
		Clinica.getInstance().saveEsamePrenoteto(esamePronotato);
	}

	public void CreaNuovaTipologiaEsame(String nome, String descrizione, float costo, List<Prerequisito> prerequisiti){
		TipoEsame tipoEsame = new TipoEsame(nome, descrizione,costo, prerequisiti);
		Clinica.getInstance().saveTipoEsame(tipoEsame);
	}

	public List<EsameEffettuato> VisualizzaEsamiMedico(long id){
		Medico m = Clinica.getInstance().getMedico(id);
		return m.mostraesami();

	}

	public void InserimentoRisultatiEsame(long id/*,elementi per il risultato da creare*/) {
		EsameEffettuato ef = Clinica.getInstance().getEsameEffettuato(id);
		ef.creaRisultato(/*elementi del risultato*/);
	}
}
