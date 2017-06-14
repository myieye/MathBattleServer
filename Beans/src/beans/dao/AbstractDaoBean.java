package beans.dao;

import interfaces.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractDaoBean<T, ID extends Serializable> implements Dao<T, ID> {

	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> entityType;

	@SuppressWarnings("unchecked")
	public AbstractDaoBean() {
		ParameterizedType thisClass = (ParameterizedType)this.getClass().getGenericSuperclass();
		entityType = (Class<T>) thisClass.getActualTypeArguments()[0];
	}

	public Class<T> getEntityType() {
		return entityType;
	}

	@Override
	public void persist(T entity) {
		em.persist(entity);
	}

	@Override
	public T merge(T entity) {
		return em.merge(entity);
	}

	@Override
	public T findById(ID id) {
		return em.find(entityType, id);
	}

	@Override
	public List<T> findAll() {
		return em.createQuery(
				String.format("select entity from %s entity", entityType.getSimpleName()), entityType)
				.getResultList();
	}
}