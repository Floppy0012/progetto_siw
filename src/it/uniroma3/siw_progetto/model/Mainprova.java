package it.uniroma3.siw_progetto.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
public class Mainprova {
	
	
	public static void main(String[] args) {
		
		Prerequisito prerequisito = new Prerequisito("NO IN CINTA","le donne gravide non devono fare questo test");
		Prerequisito prerequisito1 = new Prerequisito("DIGIUNO","chi si presenta deve stare a digiuno per 12 ore");
		Administrator administrator = new Administrator("Floriano","codice2","password");
		Paziente paziente = new Paziente("CODICEFISCALE","Daniele","Rossi",null,"password");
		List<Prerequisito> prerequisiti = new ArrayList<>();
		prerequisiti.add(prerequisito);
		prerequisiti.add(prerequisito1);
		
		Medico medico = new Medico("Mario", "Rossi", "Ematologo");
		TipoEsame tE = new TipoEsame("Analisi Sangue", "Prelievo ematico per controlli di routine", 200, prerequisiti);
		EsamePrenotato EsamePren = new EsamePrenotato(paziente, tE);
		Date Data  = new Date();
		
		EsameEffettuato effettuato = new EsameEffettuato(medico, Data);
		effettuato.setEsamePrenotato(EsamePren);
		EsameEffettuato EsameEff = new EsameEffettuato(medico, Data);
		EsameEff.setEsamePrenotato(EsamePren);
		medico.AddEsameEffettuato(EsameEff);
		medico.AddEsameEffettuato(effettuato);
//		ClinicaAccessPoint accessPoint = new ClinicaAccessPoint();
//		accessPoint.CreaPrenotazione(paziente, tE);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(prerequisito);
		em.persist(prerequisito1);
		em.persist(administrator);
		em.persist(paziente);
		em.persist(medico);
		em.persist(tE);
		em.persist(EsamePren);
		em.persist(EsameEff);
		tx.commit();
		em.close();
		emf.close();
	}

}