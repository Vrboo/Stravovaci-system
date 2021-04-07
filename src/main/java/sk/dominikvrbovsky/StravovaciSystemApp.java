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

        Meal breakfast1 = new Breakfast("Palacinky",5.2,70,Drink.COLA);
        Meal breakfast2 = new Breakfast("Ovsene vlocky",7.3,80,Drink.MINERAL_WATER);
        Meal breakfast3 = new Breakfast("Parky",3.33,100,Drink.JUICE);

        Meal lunch1 = new Lunch("Gulas",3.0,100,true);
        Meal lunch2 = new Lunch("Rezen",4.20,120,false);
        Meal lunch3 = new Lunch("Cestoviny",6.2,80, true);




        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
