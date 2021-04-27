package sk.dominikvrbovsky.utilities;

import sk.dominikvrbovsky.Breakfast;
import sk.dominikvrbovsky.Meal;
import sk.dominikvrbovsky.dao.impl.MealDao;
import sk.dominikvrbovsky.enums.Drink;

import javax.persistence.EntityManager;
import java.io.*;
import java.nio.file.Path;

public class FileUtilities {

    private static final Path pathRanajky = Path.of("src/main/resources/food-menu/Ranajky.txt");
    private static final Path pathObed = Path.of("src/main/resources/food-menu/Obed.txt");

    public static File createDefaultContentForRanajakyFile() throws IOException {

        PrintWriter printWriter = new PrintWriter(new FileWriter(pathRanajky.toString()));

        printWriter.println("VZOR: \n");
        for (int i = 0; i < 5; i++) {
            printWriter.println("jedlo;nápoj;kapacita;cena");
        }

        printWriter.print("\nPRÍKLAD: ");
        printWriter.println(" Volské oko;Čaj;80;2.25");

        printWriter.println("\nJedálny lístok môže obsahovať maximálne 5 jedál!");

        printWriter.println("\nPred uložením súboru prosím vymažte celý jeho obsah tak, aby v ňom zostalo " +
                "maximálne 5 riadkov,\nkde každý riadok je vo vyššie uvedenom vzore a " +
                "reprezentuje práve jednu ponuku v jedálnom lístku.\n" +
                "Uložený súbor zavrite a stlačte tlačidlo Vytvoriť.");
        printWriter.close();

        return pathRanajky.toFile();

    }

    public static File createDefaultContentForObedFile() throws IOException {

        PrintWriter printWriter = new PrintWriter(new FileWriter(pathObed.toString()));

        printWriter.println("VZOR: \n");
        for (int i = 0; i < 5; i++) {
            printWriter.println("jedlo;takeaway;kapacita;cena");
        }

        printWriter.print("\nPRÍKLAD: ");
        printWriter.println(" Kurací rezeň so zemiakovou kašou;Áno;124;3.30");

        printWriter.println("\nJedálny lístok môže obsahovať maximálne 5 jedál!");

        printWriter.println("\nPred uložením súboru prosím vymažte celý jeho obsah tak, aby v ňom zostalo " +
                "maximálne 5 riadkov,\nkde každý riadok je vo vyššie uvedenom vzore a " +
                "reprezentuje práve jednu ponuku v jedálnom lístku.\n" +
                "Uložený súbor zavrite a stlačte tlačidlo Vytvoriť.");

        printWriter.close();
        return pathObed.toFile();

    }

    public static void createNewFoodMenuRanajky(EntityManager entityManager) throws UnsupportedOperationException, IOException {
        String line;
        String meal;
        String drink;
        int capacity;
        double price;
        MealDao mealDao = new MealDao(entityManager);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathRanajky.toFile()));

        while ((line = bufferedReader.readLine()) != null) {
            meal = (line.split(";"))[0];
            drink = (line.split(";"))[1];
            capacity = Integer.parseInt((line.split(";"))[2]);
            price = Double.parseDouble((line.split(";"))[3]);

            mealDao.save(new Breakfast(meal, price, capacity, Drink.getEnumFromString(drink)));
        }

        bufferedReader.close();
    }
}
