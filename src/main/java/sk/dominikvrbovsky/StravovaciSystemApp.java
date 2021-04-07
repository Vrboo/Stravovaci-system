package sk.dominikvrbovsky;


import sk.dominikvrbovsky.enums.Drink;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StravovaciSystemApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("sk.dominikvrbovsky.stravovaci-system");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Meal breakfast1 = new Breakfast("Palacinky", 12.50, 70, Drink.COLA);

        entityManager.getTransaction().begin();

        entityManager.persist(breakfast1);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
