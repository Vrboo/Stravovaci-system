package sk.dominikvrbovsky.dao.impl;

import sk.dominikvrbovsky.*;
import sk.dominikvrbovsky.dao.Dao;
import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * DAO (Data Access Object) class for Meal entity (class for working with database)
 */
public class MealDao implements Dao<Meal> {

    private final EntityManager entityManager;

    public MealDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Getting meal with specified id from database
     * @return Optional of meal
     */
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

    /**
     * Saving meal to database
     */
    @Override
    public void save(Meal entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.persist(entity));
    }

    /**
     * Updating meal in database
     */
    @Override
    public void update(Meal entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.merge(entity));
    }

    /**
     * Deleting meal from datbase
     */
    @Override
    public void delete(Meal entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.remove(entity));
    }

    /**
     * Getting meal with specified name from database
     * @param nameOfMeal name of meal
     * @return Optional of meal
     */
    public Optional<Meal> getFromName(String nameOfMeal) throws Exception {
        Optional<Meal> meal = Optional.empty();
        String hql = "FROM Meal WHERE NAME = :meal";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Meal.class);
            query.setParameter("meal", nameOfMeal);
            meal = Optional.ofNullable((Meal) query.getSingleResult());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Objednávanie neprebehlo úspešne. Skúste to znovu.");
        }

        return meal;
    }

    /**
     * Saving all meal in specified List
     * @param entities meals I want to save to database
     */
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

    /**
     * Getting all meals in database
     * @return List of all meals in database
     */
    public List<Meal> getAll() {
        List<Meal> meals = null;

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM Meal", Meal.class);
            meals = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
        return meals;
    }

    /**
     * Getting all breakfasts in database
     * @return List of all breakfasts in database
     */
    public List<Breakfast> getAllBreakfast() {
        List<Breakfast> breakfasts = null;

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM Breakfast", Breakfast.class);
            breakfasts = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
        return breakfasts;

    }

    /**
     * Getting all lunches in database
     * @return List of all lunches in database
     */
    public List<Lunch> getAllLunch() {
        List<Lunch> lunches = null;

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM Lunch", Lunch.class);
            lunches = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
        return lunches;
    }

    /**
     * Deleting all meals and orders in database
     */
    public void deleteAllMealAndOrder() {
        String hql1 = "DELETE FROM Meal";

        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery(hql1).executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

    }

    /**
     * Wrapper for exception handling
     */
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
