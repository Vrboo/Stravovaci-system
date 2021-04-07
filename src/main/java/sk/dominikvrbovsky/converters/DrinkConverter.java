package sk.dominikvrbovsky.converters;

import sk.dominikvrbovsky.enums.Drink;

import javax.persistence.AttributeConverter;

public class DrinkConverter implements AttributeConverter<Drink, String> {

    @Override
    public String convertToDatabaseColumn(Drink drink) {
        if (drink == null) return null;

        return drink.getDrink();
    }

    @Override
    public Drink convertToEntityAttribute(String s) {
        if (s == null) return null;

        return Drink.getEnumFromString(s);
    }
}
