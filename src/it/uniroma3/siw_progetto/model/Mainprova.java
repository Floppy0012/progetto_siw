package it.uniroma3.siw_progetto.model;


import java.util.Date;

import javax.persistence.*;

public class Mainprova {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		
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
		Paziente Paz = new Paziente("CCTF", "FlorianO", "CEcati",data, "CICCIO");
		
		Paz.AddEsamePrenotato(EsPren);
		
		EsPren.setPaziente(Paz);
		
		Medico med = new Medico();
		
		EsameEffettuato EsEff = new EsameEffettuato();
		med.AddEsameEffettuato(EsEff);
		EsEff.setMedico(med);
		EsEff.AddRisulato(r);
		

		

		EntityTransaction tx = em.getTransaction();
		tx.begin();	
	
		em.persist(a);	
		em.persist(p);
		em.persist(r);
		em.persist(Tesame);
		em.persist(Paz);
		em.persist(EsPren);
		em.persist(med);
		em.persist(EsEff);


		tx.commit();
		em.close();
		emf.close();

	}

}