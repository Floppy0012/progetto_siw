package it.uniroma3.siw_progetto.model;

import java.util.*;

public class ClinicaAccessPoint {
	
	private Paziente pazienteCorr;
	private Clinica clinica;
	private Map <String,TipoEsame> tipologieEsami; //CAMBIARE LA CHIAVE DA STRING A INT

	public void effettuaPrenotazione (String CodiceFiscale, String CodiceTipologia ){ //DA CAMBIARE IL TIPO DI CODICETIPOLOGIA IN INT!!
		this.pazienteCorr = this.clinica.FindPazienteByCodiceFiscale(CodiceFiscale);
		TipoEsame tEsame = this.tipologieEsami.get(CodiceTipologia);
		Date dataCorr = new Date();
		EsamePrenotato esamePronotato =  new EsamePrenotato (this.pazienteCorr,tEsame,dataCorr);
		
	}
}
