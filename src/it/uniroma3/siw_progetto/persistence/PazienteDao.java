package it.uniroma3.siw_progetto.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import it.uniroma3.siw_progetto.model.Paziente;

public class PazienteDao extends Dao<Paziente> {

	public PazienteDao(EntityManagerFactory emf) {
		super(emf);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Paziente> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Paziente> result = em.createNamedQuery("findAllPazienti").getResultList();
		em.close();
		emf.close();
		return result;
	}

	
	@Override
	public Paziente findById(Object id) {
		String Id = (String)id;
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Paziente p = em.find(Paziente.class, Id);
		tx.commit();
		em.close();
		emf.close();
		return p;

	}
}
