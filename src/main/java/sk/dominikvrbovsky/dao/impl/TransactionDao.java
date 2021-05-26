package sk.dominikvrbovsky.dao.impl;


import sk.dominikvrbovsky.Transaction;
import sk.dominikvrbovsky.dao.Dao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class TransactionDao implements Dao<Transaction> {

    private final EntityManager entityManager;

    public TransactionDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Transaction> get(Long id) {
        Optional<Transaction> transaction;

        try {
            entityManager.getTransaction().begin();
            transaction = Optional.ofNullable(entityManager.find(Transaction.class, id));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return transaction;
    }

    @Override
    public void save(Transaction entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.persist(entity));
    }

    @Override
    public void update(Transaction entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.merge(entity));
    }

    @Override
    public void delete(Transaction entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.remove(entity));
    }

    public List<Transaction> getTransactionsOfUserByParameters(long id, boolean descending) {
        List<Transaction> transactions;
        String hql = "FROM Transaction WHERE USER_ID = :id ORDER BY DateTime";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Transaction.class);
            query.setParameter("id", id);
            transactions = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
        if (descending) {
            transactions.sort(Comparator.comparing(Transaction::getDateTime).reversed());
        } else {
            transactions.sort(Comparator.comparing(Transaction::getDateTime));
        }

        return transactions;
    }

    public List<Transaction> getTransactionsOfUserByParameters( long id , boolean descending, String transactionType) {
        List<Transaction> transactions;
        String hql = "FROM Transaction WHERE USER_ID = :id AND TransactionType = :type ORDER BY DateTime";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Transaction.class);
            query.setParameter("id", id);
            query.setParameter("type", transactionType);
            transactions = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        if (descending) {
            transactions.sort(Comparator.comparing(Transaction::getDateTime).reversed());
        } else {
            transactions.sort(Comparator.comparing(Transaction::getDateTime));
        }

        return transactions;
    }

    public List<Transaction> getAllTransactionsByParameters(boolean descending) {
        List<Transaction> transactions;
        String hql = "FROM Transaction ORDER BY DateTime";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Transaction.class);
            transactions = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
        if (descending) {
            transactions.sort(Comparator.comparing(Transaction::getDateTime).reversed());
        } else {
            transactions.sort(Comparator.comparing(Transaction::getDateTime));
        }

        return transactions;
    }

    public List<Transaction> getAllTransactionsByParameters(boolean descending, String transactionType) {
        List<Transaction> transactions;
        String hql = "FROM Transaction WHERE TransactionType = :type ORDER BY DateTime";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Transaction.class);
            query.setParameter("type", transactionType);
            transactions = query.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        if (descending) {
            transactions.sort(Comparator.comparing(Transaction::getDateTime).reversed());
        } else {
            transactions.sort(Comparator.comparing(Transaction::getDateTime));
        }

        return transactions;
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
