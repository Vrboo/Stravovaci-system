package sk.dominikvrbovsky.dao.impl;

import sk.dominikvrbovsky.Meal;
import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.dao.Dao;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.function.Consumer;

public class MealDao implements Dao<Meal> {

    private final EntityManager entityManager;

    public MealDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Meal> get(Long id) {
        Optional<Meal> meal;

        try {
            entityManager.getTransaction().begin();
            meal = Optional.ofNullable(entityManager.find(Meal.class, id));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return meal;
    }

    @Override
    public void save(Meal entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.persist(entity));
    }

    @Override
    public void update(Meal entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.merge(entity));
    }

    @Override
    public void delete(Meal entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.remove(entity));
    }

    private void executeInsideTransaction(Consumer<EntityManager> consumer) {
        try {
            entityManager.getTransaction().begin();
            consumer.accept(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
