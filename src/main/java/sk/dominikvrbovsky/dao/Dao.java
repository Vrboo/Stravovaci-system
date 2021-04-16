package sk.dominikvrbovsky.dao;

import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(Long id);

    void save(T entity);

    void update(T entity);

    void delete(T entity);

}
