package com.rp.repository.jpa;

import java.util.List;

import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rp.repository.Repository;
import com.rp.repository.interceptors.EntityInterceptor;

public abstract class BaseRepository<T> implements Repository<T> {

	private Class<T> clazz;

	public BaseRepository(Class<T> clazz) {
		this.clazz = clazz;
	}

	@PersistenceContext(unitName = "aulaPU")
	private EntityManager em;

	@Interceptors({
		EntityInterceptor.class
	})
	public void salvar(T obj) {
		em.persist(obj);
	}

	@Interceptors({
		EntityInterceptor.class
	})
	public void excluir(Long id) {
		T obj = get(id);
		em.remove(obj);
	}

	public T get(Long id) {
		return em.find(clazz, id);
	}

	public List<T> getTodos() {
		TypedQuery<T> tq = em.createQuery(
				"select obj from " + clazz.getSimpleName() + " obj", clazz);
		return tq.getResultList();
	}

}
