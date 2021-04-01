package sk.dominikvrbovsky.enums;

public enum Drink {
    TEA("Caj"),
    MINERAL_WATER("Mineralna voda"),
    JUICE("Dzus"),
    COLA("Cola");

    private final String drink;

    Drink(String drink) {
        this.drink = drink;
    }

    public String getDrink() {
        return this.drink;
    }

    @Override
    public String toString() {
        return this.getDrink();
    }
}
