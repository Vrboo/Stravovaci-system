package sk.dominikvrbovsky.dao.impl;

import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.dao.Dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * DAO (Data Access Object) class for User entity (class for working with database)
 */
public class UserDao implements Dao<User> {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Getting user with specified id from database
     * @return Optional of User
     */
    @Override
    public Optional<User> get(Long id) {
        Optional<User> user;

        try {
            entityManager.getTransaction().begin();
            user = Optional.ofNullable(entityManager.find(User.class, id));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return user;
    }

    /**
     * Saving user to database
     */
    @Override
    public void save(User entity) {
        executeInsideTransaction(entityManager -> entityManager.persist(entity));
    }

    /**
     * Updating user in database
     */
    @Override
    public void update(User entity) {
        executeInsideTransaction(entityManager -> entityManager.merge(entity));
    }

    /**
     * Deleting user from database
     */
    @Override
    public void delete(User entity) {
        executeInsideTransaction(entityManager -> entityManager.remove(entity));
    }

    /**
     * Getting user with specified username
     * @param username username of user that I want to get
     */
    public Optional<User> getFromUsername(String username) {
        Optional<User> user = Optional.empty();
        String hql = "FROM User WHERE USERNAME = :usr";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, User.class);
            query.setParameter("usr", username);

            try {
                user = Optional.ofNullable((User) query.getSingleResult());
            } catch (NoResultException e) {
                // nothing
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return user;

    }

    /**
     * Getting all users in database
     * @return List of all users in database
     */
    public List<User> getAll() {
        List<User> users;
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM User", User.class);
            users = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return users;
    }

    /**
     * Wrapper for exception handling
     */
    private void executeInsideTransaction(Consumer<EntityManager> consumer) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            consumer.accept(entityManager);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            throw e;
        }
    }


}
