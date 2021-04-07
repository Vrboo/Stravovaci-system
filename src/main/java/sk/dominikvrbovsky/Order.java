package sk.dominikvrbovsky;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

    private User user;
    private Meal meal;
    private LocalDateTime dateTime;

    public Order(User user, Meal meal) {
        this.user = user;
        this.meal = meal;
        this.dateTime = LocalDateTime.now();
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

    @Override
    public String toString() {
        String date = this.dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s %tT \t %s", date, this.dateTime.toLocalTime(), this.getMeal().toStringOrder());
    }
}
