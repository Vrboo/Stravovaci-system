package sk.dominikvrbovsky;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {

    private Meal meal;
    private LocalDateTime dateTime;

    public Order(Meal meal) {
        this.meal = meal;
        this.dateTime = LocalDateTime.now();
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
        return String.format("%s %tT \t", date, this.dateTime.toLocalTime()) + this.getMeal().toStringBurza();
    }
}
