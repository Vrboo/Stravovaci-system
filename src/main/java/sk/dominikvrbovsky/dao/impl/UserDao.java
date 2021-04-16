package sk.dominikvrbovsky.dao.impl;

import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class UserDao implements Dao<User> {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.ofNullable(entityManager.find(User.class,id));
    }

    @Override
    public void save(User entity) {
        executeInsideTransaction(entityManager -> entityManager.persist(entity));
    }

    @Override
    public void update(User entity) {
        executeInsideTransaction(entityManager -> entityManager.merge(entity));
    }

    @Override
    public void delete(User entity) {
        executeInsideTransaction(entityManager -> entityManager.remove(entity));
    }

    public User getFromUsername(String username) {
        User user;
        try {
            String hql = "FROM user WHERE USERNAME = :usr";
            Query query = entityManager.createQuery(hql, User.class);
            query.setParameter("usr", username);
            user = (User)query.getSingleResult();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }


    }

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
