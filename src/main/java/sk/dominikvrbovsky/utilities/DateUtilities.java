package sk.dominikvrbovsky.utilities;

import java.time.LocalDate;

public class DateUtilities {

    public static String buildSlovakTimeString() {
        StringBuilder stringBuilder = new StringBuilder();
        LocalDate localDate = LocalDate.now();
        stringBuilder.append(getDayInSlovak(localDate.getDayOfWeek().name().toLowerCase()));
        stringBuilder.append(", ").append(localDate.getDayOfMonth()).append(". ");
        stringBuilder.append(getMonthInSlovak(localDate.getMonth().name().toLowerCase()));
        stringBuilder.append(" ").append(localDate.getYear());

        return stringBuilder.toString();
    }

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

