package sk.dominikvrbovsky.dao.impl;

import sk.dominikvrbovsky.Breakfast;
import sk.dominikvrbovsky.Lunch;
import sk.dominikvrbovsky.Meal;
import sk.dominikvrbovsky.User;
import sk.dominikvrbovsky.dao.Dao;

import javax.persistence.*;
import java.util.List;
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

    public Optional<Meal> getFromName(String nameOfMeal) {
        Optional<Meal> meal = Optional.empty();
        String hql = "FROM Meal WHERE NAME = :meal";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Meal.class);
            query.setParameter("meal", nameOfMeal);

            try {
                meal = Optional.ofNullable((Meal) query.getSingleResult());
            } catch (NoResultException e) {
                // nothing
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return meal;
    }

    public void saveAll(List<Meal> entities) {
        try {
            entityManager.getTransaction().begin();
            entities.forEach(entityManager::persist);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public List<Meal> getAll() {
        Query query = entityManager.createQuery("FROM Meal", Meal.class);
        return query.getResultList();
    }


    public List<Breakfast> getAllBreakfast() {
        Query query = entityManager.createQuery("FROM Breakfast", Breakfast.class);
        return query.getResultList();
    }

    public List<Lunch> getAllLunch() {
        Query query = entityManager.createQuery("FROM Lunch", Lunch.class);
        return query.getResultList();
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
