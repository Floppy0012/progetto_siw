package it.uniroma3.siw_progetto.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import it.uniroma3.siw_progetto.model.EsameEffettuato;

public class EsameEffettuatoDao extends Dao<EsameEffettuato>{

	public EsameEffettuatoDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public EsameEffettuato findById(Object id) {
		long Id = (long)id;
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		EsameEffettuato esameEffettuato = em.find(EsameEffettuato.class, Id);
		tx.commit();
		em.close();
		return esameEffettuato;
	}

	@Override
	public List<EsameEffettuato> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<EsameEffettuato> result = em.createNamedQuery("findAllEsamiEffettuati").getResultList();
		em.close();
		return result;
	}

}
