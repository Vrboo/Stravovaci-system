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

//        Meal breakfast1 = new Breakfast("Palacinky", 12.50, 70, Drink.COLA);
//        Meal breakfast2 = new Breakfast("Prazenica", 45, 30, Drink.TEA);
//        Meal breakfast3 = new Breakfast("Parky", 5, 100, Drink.JUICE);
//        Meal breakfast4 = new Breakfast("Croasant", 10.37, 5, Drink.MINERAL_WATER);
//
//        Meal lunch1 = new Lunch("Rezen", 12.30, 150, true);
//        Meal lunch2 = new Lunch("Spagety", 5.21, 65, false);
//        Meal lunch3 = new Lunch("Cestoviny", 4.21, 54, false);
        Meal lunch4 = new Lunch("Pizza", 8.45, 87, true);

        entityManager.getTransaction().begin();

//        entityManager.persist(lunch1);
//        entityManager.persist(breakfast1);
//        entityManager.persist(lunch4);
//        entityManager.persist(breakfast2);
//        entityManager.persist(breakfast3);
//        entityManager.persist(lunch2);
//        entityManager.persist(breakfast4);
//        entityManager.persist(lunch3);

        Meal lunchch = entityManager.find(Lunch.class, 5L);
        System.out.println(lunchch.toStringMealMenu());

        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
