package org.cmweb.repository.impl;

import org.cmweb.repository.IGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class GenericRepository<T> extends AbstractHibernateRepository implements IGenericRepository<T> {


    private Class<T> entityClass;



    public T save(T obj) {
        return (T) getSession().save(obj);
    }

    public T persist(T obj) {
        getSession().persist(obj);
        return obj;
    }

    public void delete(T obj) {
        getSession().delete(obj);
    }

    public void saveOrUpdate(T o) {
        getSession().update(o);
    }


    public T load(Integer id) {
        return (T) getSession().load(entityClass, id);
    }

    public T get(Integer id) {
        Session session = openSession();
        T result = (T) session.get(entityClass, id);
        session.close();
        return result;
    }

    public List<T> findAll() {
        return getSession().createCriteria(entityClass).list();
    }


    public List<T> findByParamsEquality(HashMap<String, Object> params) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldVal = entry.getValue();
            criteria.add(Restrictions.like(fieldName, "%" + fieldVal + "%"));
        }
        return null;
    }

    public T merge(T o) {
        return (T) getSession().merge(o);
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

}
