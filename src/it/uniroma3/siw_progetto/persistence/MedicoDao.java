package it.uniroma3.siw_progetto.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import it.uniroma3.siw_progetto.model.Medico;

public class MedicoDao extends Dao<Medico> {

	public MedicoDao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public Medico findById(Object id) {
		long Id = (long)id;
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Medico medico = em.find(Medico.class, Id);
		tx.commit();
		em.close();
		//emf.close();
		return medico;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> findAll() {
		EntityManager em = this.emf.createEntityManager();
		List<Medico> result = em.createNamedQuery("findAllMedici").getResultList();
		em.close();
		//emf.close();
		return result;
	}

}
