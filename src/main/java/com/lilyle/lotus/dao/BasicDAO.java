package com.lilyle.lotus.dao;

import java.io.Serializable;
import java.util.List;

public interface BasicDAO<T extends Serializable >{
    public void add(T[] list);
    public void update(T entity);
    public T get();
    public List<T> findAll();
}
