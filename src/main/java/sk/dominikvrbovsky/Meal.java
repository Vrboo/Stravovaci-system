package sk.dominikvrbovsky;

import javax.persistence.*;

/**
 * This class represents meal in menu
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Meal {

    /**
     * ID - identifier in database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of meal
     */
    private String name;

    /**
     * Price of meal
     */
    private double price;

    /**
     *  Max. number of orders for this meal
     */
    private int capacity;

    /**
     * Number of orders for this meal
     */
    private int numberOfOrder;

    /**
     * Number of orders that are in burza
     */
    private int numberInBurza;

    public Meal(String name, double price, int capacity) {
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.numberOfOrder = 0;
        this.numberInBurza = 0;
    }

    public Meal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getNumberInBurza() {
        return numberInBurza;
    }

    public void setNumberInBurza(int numberInBurza) {
        this.numberInBurza = numberInBurza;
    }

    /**
     * Ordering meal - decrease capacity of meal and increase number of order for this meal
     */
    public void orderMeal() {
        this.setCapacity(this.getCapacity() - 1);
        this.setNumberOfOrder(this.getNumberOfOrder() + 1);
    }

    /**
     * Method which converts price to string and rounds it to two decimal
     * @return price of meal in string and rounded to two decimals
     */
    public String getPriceString() {
        return String.format("%.2f", this.getPrice());
    }

    public abstract String toStringMealMenu();

    public abstract String toStringNumOfOrders();

    public abstract String toStringBurza();

    public abstract String toStringOrder();

}
