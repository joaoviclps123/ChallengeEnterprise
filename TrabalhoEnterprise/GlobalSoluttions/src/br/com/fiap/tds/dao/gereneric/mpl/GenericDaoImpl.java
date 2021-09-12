package br.com.fiap.tds.dao.gereneric.mpl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.generic.dao.GenericDao;

public abstract class GenericDaoImpl<E,K> implements GenericDao<E, K>{

	private EntityManager em;
	
	private Class<E> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType) 
				getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void create(E entidade) {
		em.persist(entidade);
	}

	@Override
	public E read(K id) throws EntityNotFoundException {
		E entidade = em.find(clazz, id);
		if (entidade == null)
			throw new EntityNotFoundException();
		return entidade;
	}

	@Override
	public void update(E entidade) {
		em.merge(entidade);
	}

	@Override
	public void remove(K id) throws EntityNotFoundException {
		E entidade = read(id);
		em.remove(entidade);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}

}
