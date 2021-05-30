package sk.dominikvrbovsky.dao.impl;

import sk.dominikvrbovsky.Order;
import sk.dominikvrbovsky.dao.Dao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * DAO (Data Access Object) class for Order entity (class for working with database)
 */
public class OrderDao implements Dao<Order> {

    private final EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Getting order with specified id from database
     * @return Optional of Order
     */
    @Override
    public Optional<Order> get(Long id) {
        Optional<Order> order;

        try {
            entityManager.getTransaction().begin();
            order = Optional.ofNullable(entityManager.find(Order.class, id));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return order;
    }

    /**
     * Saving order to database
     */
    @Override
    public void save(Order entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.persist(entity));
    }

    /**
     * Updating order in database
     */
    @Override
    public void update(Order entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.merge(entity));
    }

    /**
     * Deleting order from database
     */
    @Override
    public void delete(Order entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.remove(entity));
    }

    /**
     * Getting order with specified meal id that was the soonest in burza
     */
    public Optional<Order> getFirstOrderInBurzaByMealId(long mealId) {
        Optional<Order> order;
        String hql = "FROM Order WHERE MEAL_ID = :id ORDER BY DateTimeAdditionToBurza ASC";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Order.class).setMaxResults(1);
            query.setParameter("id", mealId);
            order = Optional.ofNullable((Order) query.getSingleResult());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return order;
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
