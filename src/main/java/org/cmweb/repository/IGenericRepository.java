package org.cmweb.repository;

import java.util.HashMap;
import java.util.List;

public interface IGenericRepository<T> {
    public T save(T obj);
    public T persist(T obj);
    public Boolean delete(T obj);
    public void saveOrUpdate(T o);
    public T load(Long id);
    public T get(Long id);
    public List<T> findAll();
    public T edit(T obj);
    public T find(Long obj);
    public List<T> findByParamsEquality(HashMap<String,Object> params);
}
