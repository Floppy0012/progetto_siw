package it.uniroma3.siw_progetto.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import it.uniroma3.siw_progetto.model.Administrator;

public class AmministratoreDao extends Dao<Administrator> {

	public AmministratoreDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Administrator findById(Object id) {
		String Id = (String)id;
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Administrator a = em.find(Administrator.class, Id);
		tx.commit();
		em.close();
		//emf.close();
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrator> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Administrator> result = em.createNamedQuery("findAllAdmin").getResultList();
		em.close();
		//emf.close();
		return result;
	}
	
}
