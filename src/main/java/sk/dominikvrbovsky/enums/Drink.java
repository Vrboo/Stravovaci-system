package sk.dominikvrbovsky.enums;

public enum Drink {
    TEA("caj"),
    MINERAL_WATER("mineralna voda"),
    JUICE("dzus"),
    COLA("cola");

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
