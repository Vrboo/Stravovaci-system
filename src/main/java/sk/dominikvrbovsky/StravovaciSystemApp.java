package sk.dominikvrbovsky;



import sk.dominikvrbovsky.gui.Login;
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

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored) {
            ignored.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               JFrame jFrame = new Login(entityManager);
               jFrame.setVisible(true);
            }
        });
    }

}
