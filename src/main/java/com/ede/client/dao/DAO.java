package com.ede.client.dao;

import java.util.List;

public interface DAO<T> {
    void save(T obj);
    List<T> findAll();
    void update(T obj);
    void delete(T obj);


}
