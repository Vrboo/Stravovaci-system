package sk.dominikvrbovsky;

import sk.dominikvrbovsky.enums.Drink;

public class Breakfast extends Meal {

    private Drink drink;

    public Breakfast(String name, double price, int capacity, Drink drink) {
        super(name, price, capacity);
        this.drink = drink;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String toStringMealMenu() {
        return super.toStringMealMenu() + String.format("[%s]" , this.drink.toString());
    }


}
