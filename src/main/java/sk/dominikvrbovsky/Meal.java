package sk.dominikvrbovsky;

public abstract class Meal {

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

    public abstract String toStringMealMenu();

    public abstract String toStringNumOfOrders();

    public abstract String toStringBurza();

}
