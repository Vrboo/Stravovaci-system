package sk.dominikvrbovsky.utilities;

import java.io.*;
import java.nio.file.Path;

public class FileUtilities {

    private static final Path pathRanajky = Path.of("src/main/resources/food-menu/Ranajky.txt");
    private static final Path pathObed = Path.of("src/main/resources/food-menu/Obed.txt");

    public static File createDefaultContentForRanajakyFile() throws IOException {

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(pathRanajky.toString()))) {
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

            return pathRanajky.toFile();
        } catch (IOException e) {
            throw new IOException("Súbor sa nepodarilo otvoriť");
        }
    }

    public static File createDefaultContentForObedFile() throws IOException {

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(pathObed.toString()))) {
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

            return pathObed.toFile();
        } catch (IOException e) {
            throw new IOException("Súbor sa nepodarilo otvoriť");
        }
    }
}
