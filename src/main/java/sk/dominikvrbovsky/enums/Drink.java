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

    public static Drink getEnumFromString(String string) {
        for (Drink drink : Drink.values()) {
            if (string.equals(drink.getDrink())) {
                return drink;
            }
        }

        throw new UnsupportedOperationException("Pre dany string neexistuje ziadne enum Drink");
    }
}
