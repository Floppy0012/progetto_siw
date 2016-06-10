package it.uniroma3.siw_progetto.persistence;

import java.util.List;

import javax.persistence.*;

public abstract class Dao<T> {
	
	public EntityManagerFactory emf;

	public Dao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void save(T entity) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(entity);
		tx.commit();
		em.close();
		emf.close();
	}

	public void update(T entity) {
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(entity);
		tx.commit();
		em.close();
		emf.close();
	}

	public void delete(T entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		T toRemove = em.merge(entity);
		em.remove(toRemove);
		tx.commit();
		em.close();
		emf.close();
	}

	public abstract T findById(Object id);

	public abstract List<T> findAll();

}