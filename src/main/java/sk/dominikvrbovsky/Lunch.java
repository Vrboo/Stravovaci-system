package sk.dominikvrbovsky;

import javax.persistence.Entity;

@Entity
public class Lunch extends Meal{

    private boolean takeaway;

    public Lunch(String name, double price, int capacity, boolean takeaway) {
        super(name, price, capacity);
        this.takeaway = takeaway;
    }

    public Lunch() {
    }

    public Lunch(String name, double price, int capacity, String takeaway) {
        super(name, price, capacity);
        if (takeaway.equals("Áno")) {
            this.takeaway = true;
        } else if (takeaway.equals("Nie")) {
            this.takeaway = false;
        }
    }

    public boolean isTakeaway() {
        return takeaway;
    }

    public void setTakeaway(boolean takeaway) {
        this.takeaway = takeaway;
    }

    @Override
    public String toStringMealMenu() {
        return String.format("%s %s - %.2f€ - %dx ", getName(), this.takeaway ? "[Takeaway]":"", getPrice(), getCapacity());
    }

    @Override
    public String toStringNumOfOrders() {
        return String.format("%s %s - pocet objednavok %dx ", getName(), this.takeaway ? "[Takeaway]":"", getNumberOfOrder());
    }

    @Override
    public String toStringBurza() {
        return String.format("%s %s - %.2f€ - %dx", getName(), this.takeaway ? "[Takeaway]":"", getPrice(), getNumberInBurza());
    }

    @Override
    public String toStringOrder() {
        return String.format("%s %s - %.2f€", getName(), this.takeaway ? "[Takeaway]":"", getPrice());
    }
}
