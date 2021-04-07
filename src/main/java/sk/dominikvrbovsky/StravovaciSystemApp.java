package sk.dominikvrbovsky;


import sk.dominikvrbovsky.enums.Drink;
import sk.dominikvrbovsky.enums.TransactionType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StravovaciSystemApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("sk.dominikvrbovsky.stravovaci-system");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Meal breakfast1 = new Breakfast("Palacinky",5.2,70,Drink.COLA);
        Meal breakfast2 = new Breakfast("Ovsene vlocky",7.3,80,Drink.MINERAL_WATER);
        Meal breakfast3 = new Breakfast("Parky",3.33,100,Drink.JUICE);

        Meal lunch1 = new Lunch("Gulas",3.0,100,true);
        Meal lunch2 = new Lunch("Rezen",4.20,120,false);
        Meal lunch3 = new Lunch("Cestoviny",6.2,80, true);

        User user1 = new User("vrboo", "Dominik Vrbovsky", "0000", 20.30);

        Transaction transaction1 = new Transaction(user1, TransactionType.INPUT, 12.30);

        Order order1 = new Order(user1, lunch1);

        user1.addTransaciton(transaction1);


        entityManager.getTransaction().begin();

        entityManager.persist(lunch1);
        entityManager.persist(user1);
        entityManager.persist(order1);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
