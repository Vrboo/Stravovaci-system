package sk.dominikvrbovsky;


import sk.dominikvrbovsky.gui.Login;
import sk.dominikvrbovsky.gui.Registration1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class StravovaciSystemApp {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("sk.dominikvrbovsky.stravovaci-system");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        entityManager.getTransaction().begin();
//
//        entityManager.find(User.class, 24L);
//
//
//        entityManager.getTransaction().commit();
//        entityManager.close();

        //User user = new UserDao(entityManager).getFromUsername("vrboo").get();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored) {
            ignored.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new Registration1(entityManager);
                //JFrame jFrame = new UserInterface(entityManager, user);
                //JFrame jFrame = new AdministratorInterface(entityManager, user);
                jFrame.setVisible(true);
            }
        });







    }




//    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory =
//                Persistence.createEntityManagerFactory("sk.dominikvrbovsky.stravovaci-system");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        Meal breakfast1 = new Breakfast("Palacinky",5.2,70,Drink.COLA);
//        Meal breakfast2 = new Breakfast("Ovsene vlocky",7.3,80,Drink.MINERAL_WATER);
//        Meal breakfast3 = new Breakfast("Parky",3.33,100,Drink.JUICE);
//
//        Meal lunch1 = new Lunch("Gulas",3.0,100,true);
//        Meal lunch2 = new Lunch("Rezen",4.20,120,false);
//        Meal lunch3 = new Lunch("Cestoviny",6.2,80, true);
//
//        User user1 = new User("vrboo", "Dominik Vrbovsky", "0000", 0.0);
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(lunch1);
//        entityManager.persist(lunch2);
//        entityManager.persist(lunch3);
//        entityManager.persist(breakfast1);
//        entityManager.persist(breakfast2);
//        entityManager.persist(breakfast3);
//
//        entityManager.persist(user1);
//
//
//
//
//
//        entityManager.getTransaction().commit();
//
//        user1.putMoneyOnAccount(5.30);
//        user1.makeOrder(breakfast1);
//        user1.setFullName("Zmena");
//
//        entityManager.getTransaction().begin();
//
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//
//
//
//    }

}
