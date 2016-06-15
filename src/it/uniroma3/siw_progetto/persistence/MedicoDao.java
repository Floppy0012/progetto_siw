package it.uniroma3.siw_progetto.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.siw_progetto.model.Medico;
import it.uniroma3.siw_progetto.model.TipoEsame;

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
	
	public Medico getMedico(String nome, String cognome) {		
		EntityManager em = this.emf.createEntityManager();
		Query q= em.createQuery("SELECT m FROM Medico m Where m.nome = ? and m.cognome= ?");
		q.setParameter(1, nome);
		q.setParameter(2, cognome);
		Medico t= (Medico) q.getSingleResult();
		em.close();
		return t;
	}

}
