package interfaces.dao;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

@Local
public interface Dao<T, ID extends Serializable> {
	void persist(T entity);
	T merge(T entity);
	T findById(ID id);
	List<T> findAll();
}
