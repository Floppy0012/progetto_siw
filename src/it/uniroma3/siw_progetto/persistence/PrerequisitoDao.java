package it.uniroma3.siw_progetto.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.siw_progetto.model.Prerequisito;

public class PrerequisitoDao extends Dao<Prerequisito> {

	public PrerequisitoDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Prerequisito findById(Object id) {
		String Id = (String)id;
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Prerequisito p = em.find(Prerequisito.class, Id);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prerequisito> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Prerequisito> result = em.createNamedQuery("findAllPrerequisiti").getResultList();
		em.close();
		emf.close();
		return result;
	}

}
