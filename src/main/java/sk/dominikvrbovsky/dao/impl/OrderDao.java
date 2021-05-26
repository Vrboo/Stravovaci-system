package sk.dominikvrbovsky.dao.impl;


import sk.dominikvrbovsky.Order;
import sk.dominikvrbovsky.dao.Dao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;
import java.util.function.Consumer;

public class OrderDao implements Dao<Order> {

    private final EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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

    @Override
    public void save(Order entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.persist(entity));
    }

    @Override
    public void update(Order entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.merge(entity));
    }

    @Override
    public void delete(Order entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.remove(entity));
    }

    public Optional<Order> getFirstOrderInBurzaByMealId(long id) {
        Optional<Order> order;
        String hql = "FROM Order WHERE MEAL_ID = :id ORDER BY DateTimeAdditionToBurza ASC";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Order.class).setMaxResults(1);
            query.setParameter("id", id);
            order = Optional.ofNullable((Order) query.getSingleResult());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return order;
    }

//    public void deleteAll() {
//        String hql = "DELETE FROM Order";
//
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.createQuery(hql).executeUpdate();
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            throw e;
//        }
//    }

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
