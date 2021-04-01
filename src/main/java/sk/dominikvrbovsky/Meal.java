package sk.dominikvrbovsky;

public class Meal {

    private String name;
    private double price;
    private int capacity;
    private int numberOfOrder;

    public Meal(String name, double price, int capacity) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.numberOfOrder = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public boolean orderMeal() {

        if (this.getCapacity() == 0) return false;

        this.setCapacity(this.getCapacity() - 1);
        this.setNumberOfOrder(this.getNumberOfOrder() + 1);
        return true;
    }

    public String toStringMealMenu() {
        return String.format("%s - %.2f€ - %dx", this.name, this.price, this.capacity);
    }

    public String toStringNumOfOrders() {
        return String.format("%s - pocet objednavok %dx", this.name, this.numberOfOrder);
    }

    public String toStringBurza() {
        return String.format("%s - %.2f€", this.name, this.price);
    }

}
