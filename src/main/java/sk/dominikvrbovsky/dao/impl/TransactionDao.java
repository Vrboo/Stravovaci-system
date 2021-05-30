package sk.dominikvrbovsky.dao.impl;

import sk.dominikvrbovsky.Transaction;
import sk.dominikvrbovsky.dao.Dao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * DAO (Data Access Object) class for Transaction entity (class for working with database)
 */
public class TransactionDao implements Dao<Transaction> {

    private final EntityManager entityManager;

    public TransactionDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Getting transaction with specified id from database
     * @return Optional of Transaction
     */
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

    /**
     * Saving transaction to database
     */
    @Override
    public void save(Transaction entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.persist(entity));
    }

    /**
     * Updating transaction in database
     */
    @Override
    public void update(Transaction entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.merge(entity));
    }

    /**
     * Deleting transaction from database
     */
    @Override
    public void delete(Transaction entity) {
        executeInsideTransaction(entityManager1 -> entityManager1.remove(entity));
    }

    /**
     * Getting all transactions (in database) with specified user id.
     * Resulting List of transactions is in descending or ascending order.
     * @param descending true - ordering from latest transactions; false - ordering from oldest transactions
     */
    public List<Transaction> getTransactionsOfUserByParameters(long idOfUser, boolean descending) {
        List<Transaction> transactions;
        String hql = "FROM Transaction WHERE USER_ID = :idOfUser ORDER BY DateTime";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Transaction.class);
            query.setParameter("idOfUser", idOfUser);
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

    /**
     * Getting all transactions (in database) with specified user id and type of transaction.
     * Resulting List of transactions is in descending or ascending order.
     * @param descending true - ordering from latest transactions; false - ordering from oldest transactions
     * @param transactionType type of transaction - INPUT or OUTPUT (vklad alebo výber)
     */
    public List<Transaction> getTransactionsOfUserByParameters(long idOfUser , boolean descending, String transactionType) {
        List<Transaction> transactions;
        String hql = "FROM Transaction WHERE USER_ID = :id AND TransactionType = :type ORDER BY DateTime";

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql, Transaction.class);
            query.setParameter("id", idOfUser);
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

    /**
     * Getting all transactions in database.
     * Resulting List of transactions is in descending or ascending order.
     * @param descending true - ordering from latest transactions; false - ordering from oldest transactions
     */
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

    /**
     * Getting all transactions (in database) with specified type.
     * Resulting List of transactions is in descending or ascending order.
     * @param descending true - ordering from latest transactions; false - ordering from oldest transactions
     * @param transactionType type of transaction - INPUT or OUTPUT (vklad alebo výber)
     */
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
