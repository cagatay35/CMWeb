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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GenericRepository<T> extends AbstractHibernateRepository implements IGenericRepository<T> {

    private Class<T> type;

    public T save(T obj) {
        return (T)getSession().save(obj);
    }

    public T persist(T obj) {
        return null;
    }

    public Boolean delete(T obj) {
        return null;
    }

    public void saveOrUpdate(T o) {

    }

    public T load(Long id) {
        return null;
    }

    public T get(Long id) {
        return null;
    }

    public List<T> findAll() {
        return null;
    }

    public T edit(T obj) {
        return null;
    }

    public T find(Long obj) {
        return null;
    }

    public List<T> findByParamsEquality(HashMap<String, Object> params) {
        Criteria criteria = getSession().createCriteria(type);
       for (Map.Entry<String,Object> entry:params.entrySet()) {
           String fieldName = entry.getKey();
           Object fieldVal = entry.getValue();
           criteria.add(Restrictions.like(fieldName,"%" + fieldVal + "%"));
       }
        return null;
    }

}
