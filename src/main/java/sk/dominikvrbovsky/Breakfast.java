package sk.dominikvrbovsky;

import sk.dominikvrbovsky.converters.DrinkConverter;
import sk.dominikvrbovsky.enums.Drink;
import javax.persistence.Convert;
import javax.persistence.Entity;

/**
 * This class represents breakfast in menu
 */
@Entity
public class Breakfast extends Meal {

    /**
     * The drink for breakfast (Breakfast drink)
     */
    @Convert(converter = DrinkConverter.class)
    private Drink drink;

    public Breakfast(String name, double price, int capacity, Drink drink) {
        super(name, price, capacity);
        this.drink = drink;
    }

    public Breakfast() {
    }

    public Breakfast(String name, double price, int capacity, String drink) {
        super(name, price, capacity);
        this.drink = Drink.getEnumFromString(drink);
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String toStringMealMenu() {
        return String.format("%s [%s] - %.2f€ - %dx", getName(), getDrink().toString(), getPrice(), getCapacity());
    }

    @Override
    public String toStringNumOfOrders() {
        return String.format("%s [%s] - pocet objednavok %dx", getName(), getDrink().toString(), getCapacity());
    }

    @Override
    public String toStringBurza() {
        return String.format("%s [%s] - %.2f€ - %dx", getName(),getDrink().toString(), getPrice(), getNumberInBurza());
    }

    @Override
    public String toStringOrder() {
        return String.format("%s [%s] - %.2f€", getName(),getDrink().toString(), getPrice());
    }
}
