package sk.dominikvrbovsky;


import sk.dominikvrbovsky.dao.impl.MealDao;
import sk.dominikvrbovsky.dao.impl.OrderDao;
import sk.dominikvrbovsky.dao.impl.UserDao;
import sk.dominikvrbovsky.gui.AdministratorInterface;
import sk.dominikvrbovsky.gui.Login;
import sk.dominikvrbovsky.gui.Registration;
import sk.dominikvrbovsky.gui.UserInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

/**
 * Main class of project
 */
public class StravovaciSystemApp {

    /**
     * Main method of project
     */
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("sk.dominikvrbovsky.stravovaci-system");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //User user = new UserDao(entityManager).getFromUsername("vrboo").get();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored) {
            ignored.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //JFrame jFrame = new Registration(entityManager);
                //JFrame jFrame = new UserInterface(entityManager, user);
                //JFrame jFrame = new AdministratorInterface(entityManager, user);
               JFrame jFrame = new Login(entityManager);
                jFrame.setVisible(true);
            }
        });
    }

}
