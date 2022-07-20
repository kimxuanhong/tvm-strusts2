package com.xhk.travinhmotel.auth.dao.base;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T, ID> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    void deleteById(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
}
