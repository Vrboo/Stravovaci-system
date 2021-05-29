package sk.dominikvrbovsky;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represent order of the meal
 */
@Entity
@Table(name = "orders")
public class Order {

    /**
     * ID - Identifier in database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User who created this order
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_order_user_id"))
    private User user;

    /**
     * Meal that is ordered
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_order_meal_id"))
    private Meal meal;

    /**
     * Date and time of the order creation
     */
    private LocalDateTime dateTimeOrderCreation;

    /**
     * Order is in burza resp. meal of the order is in burza
     */
    private boolean inBurza;

    /**
     * Date and time of addition the order to burza
     */
    private LocalDateTime dateTimeAdditionToBurza;

    public Order(User user, Meal meal) {
        this.user = user;
        this.meal = meal;
        this.dateTimeOrderCreation = LocalDateTime.now();
        this.inBurza = false;
        this.dateTimeAdditionToBurza = null;
        this.meal.orderMeal();
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public LocalDateTime getDateTimeAdditionToBurza() {
        return dateTimeAdditionToBurza;
    }

    public void setDateTimeAdditionToBurza(LocalDateTime dateTimeAdditionToBurza) {
        this.dateTimeAdditionToBurza = dateTimeAdditionToBurza;
    }

    public LocalDateTime getDateTimeOrderCreation() {
        return dateTimeOrderCreation;
    }

    public void setDateTimeOrderCreation(LocalDateTime dateTimeOrderCreation) {
        this.dateTimeOrderCreation = dateTimeOrderCreation;
    }

    public boolean isInBurza() {
        return inBurza;
    }

    /**
     * Setting that this order resp. meal of this order is in burza
     */
    public void setInBurza(boolean inBurza) {
        if (inBurza) this.dateTimeAdditionToBurza = LocalDateTime.now();
        if (!inBurza) this.dateTimeAdditionToBurza = null;
        this.inBurza = inBurza;
    }

    /**
     * Add this order to burza resp. add meal of this order to burza
     */
    public void addToBurza() {
        this.setInBurza(true);
        this.meal.setNumberInBurza(this.meal.getNumberInBurza() + 1);
    }

    /**
     * Removing this order burza from Burza
     */
    public void removeFromBurza() {
        this.setInBurza(false);
        this.meal.setNumberInBurza(this.meal.getNumberInBurza() - 1);
    }

    /**
     * Ordering this order from burza
     * @param newUser User who ordered this meal of this order from burza
     */
    public void orderFromBurza(User newUser) {
        this.user.setAccount(this.user.getAccount() + this.meal.getPrice());
        this.setUser(newUser);
        newUser.getOrders().add(this);
        this.setDateTimeOrderCreation(LocalDateTime.now());
        this.setInBurza(false);
        this.meal.setNumberInBurza(this.meal.getNumberInBurza() - 1);
    }

    /**
     * Method that returns text string containing information about order
     */
    @Override
    public String toString() {
        String date = this.dateTimeOrderCreation.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s %tT \t %s", date, this.dateTimeOrderCreation.toLocalTime(), this.getMeal().toStringOrder());
    }
}
