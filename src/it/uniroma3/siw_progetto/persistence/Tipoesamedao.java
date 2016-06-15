package it.uniroma3.siw_progetto.persistence;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.uniroma3.siw_progetto.model.TipoEsame;

public class Tipoesamedao extends Dao<TipoEsame>{

	public Tipoesamedao(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public TipoEsame findById(Object id) {
		long Id = (long)id;
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TipoEsame tipoesame = em.find(TipoEsame.class, Id);
		tx.commit();
		em.close();
	//	emf.close();
		return tipoesame;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoEsame> findAll() {
		EntityManager em = this.emf.createEntityManager();		
		List<TipoEsame> result = em.createNamedQuery("findAllTipiEsami").getResultList();
		em.close();
	//	emf.close();
		return result;
	}

	public TipoEsame getTipoesame(String nometipoesame) {
		EntityManager em = this.emf.createEntityManager();
		Query q= em.createQuery("SELECT t FROM TipoEsame t Where t.nome = ?");
		q.setParameter(1, nometipoesame);
		TipoEsame t= (TipoEsame) q.getSingleResult();
		em.close();
		return t;
	}

}
