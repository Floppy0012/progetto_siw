package it.uniroma3.siw_progetto.model;


import java.util.Date;


public class Mainprova {

	public static void main(String[] args) {

		
		Administrator a = new Administrator();	
		a.setId("id");
		a.setNome("a");
		
		Prerequisito p = new Prerequisito();
		p.setNome("No Incinta");
		
		Risultato r = new Risultato();
		r.setNome("Emob");
		r.setDescrizione("Cee");
		
		TipoEsame Tesame = new TipoEsame();
		Tesame.setNome("AnalisiDelSangue");
		Tesame.AddPrerequisiti(p);
		
		EsamePrenotato EsPren = new EsamePrenotato();
		
		@SuppressWarnings("deprecation")
		Date data = new Date(94, 8, 13);
		Paziente Paz = new Paziente("CCTF", "FlorianO", "Cecati", data, "CICCIO");
		
		Paz.AddEsamePrenotato(EsPren);
		
		EsPren.setPaziente(Paz);
		EsPren.setTipoEsame(Tesame);
		
		Medico med = new Medico();
		
		EsameEffettuato EsEff = new EsameEffettuato();
		med.AddEsameEffettuato(EsEff);
		EsEff.setMedico(med);
		EsEff.AddRisulato(r);
		EsEff.setEsamePrenotato(EsPren);
		EsPren.setEsameEffettuato(EsEff);
		
		r.setEsameEffettuato(EsEff);
		Clinica.getInstance().saveAmministratore(a);
		Clinica.getInstance().savePaziente(Paz);
		Clinica.getInstance().saveMedico(med);
//		Clinica.getInstance().savePrerequisito(p);
//		Clinica.getInstance().saveTipoEsame(Tesame);
//		Clinica.getInstance().saveEsamePrenotato(EsPren);
//		Clinica.getInstance().saveEsameEffettuato(EsEff);
//		Clinica.getInstance().saveRisultato(r);
	
		

	}

}