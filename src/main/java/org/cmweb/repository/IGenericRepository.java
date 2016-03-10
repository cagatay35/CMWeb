package org.cmweb.repository;

import java.util.HashMap;
import java.util.List;

public interface IGenericRepository<T> {
    public T save(T obj);
    public T persist(T obj);
    public void delete(T obj);
    public void saveOrUpdate(T o);
    public T load(Integer id);
    public T get(Integer id);
    public List<T> findAll();
    public List<T> findByParamsEquality(HashMap<String,Object> params);
    public T merge(T o);
}
