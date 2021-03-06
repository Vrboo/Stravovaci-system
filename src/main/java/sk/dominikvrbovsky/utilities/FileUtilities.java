package sk.dominikvrbovsky.utilities;

import sk.dominikvrbovsky.Transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Class containing methods for writing to file
 */
public class FileUtilities {

    /**
     * Writing to file informations about transactions for admin of application
     */
    public static void saveTransactionsInFileForAdmin(File file, List<Transaction> transactions) throws Exception {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            for (Transaction transaction : transactions) {
                printWriter.println(transaction.toStringForAdministrator());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Writing to file informations about transactions of user
     */
    public static void saveTransactionsInFileForUser(File file, List<Transaction> transactions) throws Exception {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            for (Transaction transaction : transactions) {
                printWriter.println(transaction.toStringForUser());
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
