package beans.util;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;

/**
 * @author Tim Haasdyk on 13-Jun-17.
 */
public class QueryBuilder<T> {

    private TypedQuery<T> qry;

    public QueryBuilder(EntityManager em, String qry) {
        ParameterizedType thisClass = (ParameterizedType)this.getClass().getGenericSuperclass();
        Class<T> entityType = (Class<T>) thisClass.getActualTypeArguments()[0];
        this.qry = em.createQuery(qry, entityType);
    }

    public QueryBuilder<T> setParamater(String name, String value) {
        qry.setParameter(name, value);
        return this;
    }

    public TypedQuery<T> build() {
        return qry;
    }
}
