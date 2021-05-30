package sk.dominikvrbovsky.dao;

import java.util.Optional;

/**
 * Interface for Dao classes that are used for working with database
 * @param <T> entity
 */
public interface Dao<T> {

    /**
     * Getting entity with specified identifier from database
     * @return Optional of entity
     */
    Optional<T> get(Long id);

    /**
     * Saving entity to database
     */
    void save(T entity);

    /**
     * Updating entity in database
     */
    void update(T entity);

    /**
     * Deleting entity from database
     */
    void delete(T entity);

}
