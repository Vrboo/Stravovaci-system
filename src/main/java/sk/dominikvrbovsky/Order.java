package sk.dominikvrbovsky;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_order_user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_order_meal_id"))
    private Meal meal;

    private LocalDateTime dateTimeOrderCreation;

    private boolean inBurza;
    
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

    public void setInBurza(boolean inBurza) {
        if (inBurza) this.dateTimeAdditionToBurza = LocalDateTime.now();
        if (!inBurza) this.dateTimeAdditionToBurza = null;
        this.inBurza = inBurza;
    }

    public void addToBurza() {
        this.setInBurza(true);
        this.meal.setNumberInBurza(this.meal.getNumberInBurza() + 1);
    }

    public void removeFromBurza() {
        this.setInBurza(false);
        this.meal.setNumberInBurza(this.meal.getNumberInBurza() - 1);
    }

    public void orderFromBurza(User newUser) {
        this.user.setAccount(this.user.getAccount() + this.meal.getPrice());
        this.setUser(newUser);
        newUser.getOrders().add(this);
        this.setDateTimeOrderCreation(LocalDateTime.now());
        this.setInBurza(false);
        this.meal.setNumberInBurza(this.meal.getNumberInBurza() - 1);
    }

    @Override
    public String toString() {
        String date = this.dateTimeOrderCreation.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s %tT \t %s", date, this.dateTimeOrderCreation.toLocalTime(), this.getMeal().toStringOrder());
    }
}
