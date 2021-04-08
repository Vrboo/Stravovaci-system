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

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_order_user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_order_meal_id"))
    private Meal meal;

    private LocalDateTime dateTime;

    private boolean burza;

    public Order(User user, Meal meal) {
        this.user = user;
        this.meal = meal;
        this.dateTime = LocalDateTime.now();
        this.burza = false;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isBurza() {
        return burza;
    }

    public void setBurza(boolean burza) {
        this.burza = burza;
    }

    @Override
    public String toString() {
        String date = this.dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s %tT \t %s", date, this.dateTime.toLocalTime(), this.getMeal().toStringOrder());
    }
}
