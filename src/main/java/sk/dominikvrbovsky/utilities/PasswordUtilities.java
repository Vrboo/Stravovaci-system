package sk.dominikvrbovsky.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtilities {
    public static boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z]).{6,}$");
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

}
