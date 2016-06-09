package it.uniroma3.siw_progetto.persistence;
import it.uniroma3.siw_progetto.model.Risultato;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Risultatodao extends Dao<Risultato> {

	public Risultatodao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Risultato findById(Object id) {
		long Id = (long)id;
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Risultato risultato = em.find(Risultato.class, Id);
		tx.commit();
		em.close();
		return risultato;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Risultato> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Risultato> result = em.createNamedQuery("findAllRisultati").getResultList();
		em.close();
		return result;
	}

}
