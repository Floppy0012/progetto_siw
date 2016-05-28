package it.uniroma3.siw_progetto.model;

import java.util.*;

public class ClinicaAccessPoint {

	private Paziente pazienteCorr;
	private Clinica clinica;
	private Tipoesamedao tipoesamedao; 
	private Administrator aministratoreCorr;

	public void CreaPrenotazione (String CodiceFiscale, String CodiceTipologia ){ //DA CAMBIARE IL TIPO DI CODICETIPOLOGIA IN INT!!
		this.pazienteCorr = this.clinica.getPaziente(CodiceFiscale);
		TipoEsame tEsame = this.tipoesamedao.find(CodiceTipologia);
		Date dataCorr = new Date();
		EsamePrenotato esamePronotato =  new EsamePrenotato (this.pazienteCorr,tEsame,dataCorr);		
	}

/*	public void EffettuaconnessionePaziente(String codicefiscale, String password){
		Paziente p=this.clinica.getPaziente(codicefiscale);
		if(p.CheckPassword(password)){
			this.pazienteCorr=p;
		}
		else{//chiamata errore 

		}

	}
	public void EffettuaconnessioneAmministratore(String codiceid, String password){
		Administrator admin=this.clinica.getAmministratore(codiceid);
		if(admin.CheckPassword(password)){
			this.aministratoreCorr=admin;
		}
		else{//chiamata errore 

		}}

	public void logoutPaziente(){this.pazienteCorr=null;
	}

	public void logoutAmministratore(){this.aministratoreCorr=null;
	}*/
}
