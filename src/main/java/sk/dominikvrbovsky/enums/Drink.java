package sk.dominikvrbovsky.enums;

public enum Drink {
    TEA("Čaj"),
    MINERAL_WATER("Minerálna voda"),
    JUICE("Džús"),
    COLA("Cola");

    private final String drink;

    Drink(String drink) {
        this.drink = drink;
    }

    public String getDrink() {
        return this.drink;
    }

    public static Drink getEnumFromString(String string) throws UnsupportedOperationException {
        if (string.equals("Min. voda")) return MINERAL_WATER;
        for (Drink drink : Drink.values()) {
            if (string.equals(drink.getDrink())) {
                return drink;
            }
        }

        throw new UnsupportedOperationException("Zadali ste chybný názov nápoja");
    }
}
