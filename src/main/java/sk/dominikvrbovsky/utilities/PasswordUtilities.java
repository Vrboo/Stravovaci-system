package sk.dominikvrbovsky.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class containing one method for checking password
 */
public class PasswordUtilities {

    /**
     * Method that finds out if input string contains:
     * - at least one number
     * - at least one uppercase letter
     * - at least six characters
     */
    public static boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z]).{6,}$");
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

}
