//package it.uniroma3.siw_progetto.model;
//
//import java.util.*;
//
//import javassist.compiler.ast.NewExpr;
//
//public class ClinicaAccessPoint {
//
//	private Paziente pazienteCorr;
//	private Clinica clinica;
//	private Tipoesamedao tipoesamedao; // voglio provare ad insereire non i dao ma un repository globale con i comandi crud oppure una facade della persistenza
//	private Administrator aministratoreCorr;
//
//	public void CreaPrenotazione (String CodiceFiscale, String CodiceTipologia ){ //DA CAMBIARE IL TIPO DI CODICETIPOLOGIA IN INT!!
//		this.pazienteCorr = this.clinica.getPaziente(CodiceFiscale);
//		TipoEsame tEsame = this.tipoesamedao.find(CodiceTipologia);
//		Date dataCorr = new Date();
//		EsamePrenotato esamePronotato =  new EsamePrenotato (this.pazienteCorr,tEsame,dataCorr);		
//	}
//
//	public void CreaNuovaTipologiaEsame(String nome, String descrizione, float costo, List<Prerequisito> prerequisiti){
//		TipoEsame tipoEsame= new TipoEsame(nome, descrizione,costo, prerequisiti);
//		this.tipoesamedao.save(tipoEsame);
//	}
//
//	public List<EsameEffettuato> VisualizzaEsamiMedico(long id){
//		Medico m= clinica.getMedico(id);
//		return m.mostraesami();
//
//	}
//
//	public void InserimentoRisultatiEsame(long id/*,elementi per il risultato da creare*/) {
//		EsameEffettuato ef/*= non so a chi chiederlo*/;
//		ef.creaRisultato(/*elementi del risultato*/);
//	}
//}
