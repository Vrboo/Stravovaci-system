package sk.dominikvrbovsky.utilities;

import sk.dominikvrbovsky.Transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileUtilities {

    public static void saveTransactionsInFile(File file, List<Transaction> transactions) throws Exception {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            for (Transaction transaction : transactions) {
                printWriter.println(transaction.toStringForAdministrator());
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
