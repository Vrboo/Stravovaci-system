package sk.dominikvrbovsky.converters;

import sk.dominikvrbovsky.enums.Drink;

import javax.persistence.AttributeConverter;

/**
 * Drink[enum] converter for database (converting between Drink[enum] and String)
 */
public class DrinkConverter implements AttributeConverter<Drink, String> {

    /**
     * Converting from enum Drink to text string
     * @param drink enum Drink
     * @return text string representing input enum Drink
     */
    @Override
    public String convertToDatabaseColumn(Drink drink) {
        if (drink == null) return null;

        return drink.getDrink();
    }

    /**
     * Converting from text string to enum Drink
     * @param s text string representing enum Drink
     * @return enum Drink
     */
    @Override
    public Drink convertToEntityAttribute(String s) {
        if (s == null) return null;

        return Drink.getEnumFromString(s);
    }
}
