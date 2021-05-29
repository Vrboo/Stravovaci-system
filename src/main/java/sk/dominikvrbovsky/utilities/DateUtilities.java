package sk.dominikvrbovsky.utilities;

import java.time.LocalDate;

/**
 * Class containing methods for building text string of date in Slovak
 */
public class DateUtilities {

    /**
     * Method that creates text string informating about date in Slovak
     */
    public static String createSlovakDateString() {
        StringBuilder stringBuilder = new StringBuilder();
        LocalDate localDate = LocalDate.now();
        stringBuilder.append(getDayInSlovak(localDate.getDayOfWeek().name().toLowerCase()));
        stringBuilder.append(", ").append(localDate.getDayOfMonth()).append(". ");
        stringBuilder.append(getMonthInSlovak(localDate.getMonth().name().toLowerCase()));
        stringBuilder.append(" ").append(localDate.getYear());

        return stringBuilder.toString();
    }

    /**
     * Method that from English name of day returns Slovak name of day
     * @param dayInEnglish Slovak name of day
     */
    private static String getDayInSlovak(String dayInEnglish) {
        return switch (dayInEnglish) {
            case "monday" -> "Pondelok";
            case "tuesday" -> "Utorok";
            case "wednesday" -> "Streda";
            case "thursday" -> "Štvrtok";
            case "friday" -> "Piatok";
            case "saturday" -> "Sobota";
            case "sunday" -> "Nedeľa";
            default -> null;
        };
    }

    /**
     * Method that from English name of month returns Slovak name of month
     * @param monthInEnglish English name of month
     */
    private static String getMonthInSlovak(String monthInEnglish) {
        return switch (monthInEnglish) {
            case "january" -> "január";
            case "february" -> "február";
            case "march" -> "marec";
            case "april" -> "apríl";
            case "may" -> "máj";
            case "june" -> "jún";
            case "july" -> "júl";
            case "august" -> "august";
            case "september" -> "september";
            case "october" -> "október";
            case "november" -> "november";
            case "december" -> "decemeber";
            default -> null;
        };
    }
}

