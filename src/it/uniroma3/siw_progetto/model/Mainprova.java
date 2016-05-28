package it.uniroma3.siw_progetto.model;


import javax.persistence.*;

public class Mainprova {

	public static void main(String[] args) {

		Administrator a = new Administrator();
		Paziente p=new Paziente();
		TipoEsame tp=new TipoEsame();
		EsameEffettuato ee =new EsameEffettuato();
		EsamePrenotato ep= new EsamePrenotato();
		Medico m = new Medico();

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("clinica-unit");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		em.persist(ee);		
		em.persist(ep);	
		em.persist(p);	
		em.persist(a);		
		em.persist(tp);		
		em.persist(m);

		tx.commit();
		em.close();
		emf.close();

	}

}
