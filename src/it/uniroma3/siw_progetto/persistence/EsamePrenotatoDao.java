package it.uniroma3.siw_progetto.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import it.uniroma3.siw_progetto.model.EsamePrenotato;

public class EsamePrenotatoDao extends Dao<EsamePrenotato> {

	public EsamePrenotatoDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public EsamePrenotato findById(Object id) {
		long Id = (long)id;
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		EsamePrenotato esamePrenotato = em.find(EsamePrenotato.class, Id);
		tx.commit();
		em.close();
	//	emf.close();
		return esamePrenotato;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EsamePrenotato> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<EsamePrenotato> result = em.createNamedQuery("findAllEsamiPrenotati").getResultList();
		em.close();
	//	emf.close();
		return result;
	}

}
