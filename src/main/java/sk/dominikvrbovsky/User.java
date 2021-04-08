package sk.dominikvrbovsky;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String fullName;
    private String password;
    private double account;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Order breakfastOrder;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Order lunchOrder;

    public User(String username, String fullName, String password, double account) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.account = account;
        this.transactions = new ArrayList<>();
        this.breakfastOrder = null;
        this.lunchOrder = null;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Order getBreakfastOrder() {
        return breakfastOrder;
    }

    public void setBreakfastOrder(Order breakfastOrder) {
        this.breakfastOrder = breakfastOrder;
    }

    public Order getLunchOrder() {
        return lunchOrder;
    }

    public void setLunchOrder(Order lunchOrder) {
        this.lunchOrder = lunchOrder;
    }

    public boolean makeOrder(Meal meal) {
        if (meal instanceof Breakfast) this.breakfastOrder = new Order(this, meal);
        return true;
    }

    public void cancelOrder(Order order) {

    }

    public void addMealToBurza() {

    }

    public void takeMealFromBurza() {

    }

//    public void makeOrder(Meal meal) {
//        this.orders.add(new Order(this,meal));
//    }
//
//    public void cancelOrder(Order order) {
//        this.orders.remove(order);
//    }
//
//    public void addMealToBurza(Order order) {
//        order.addToBurza();
//    }
//
//    public boolean takeMealFromBurza(Order order) {
//        if (!order.isBurza()) return false;
//
//        order.removeFromBurza(this);
//        return true;
//    }

    public void addTransaciton(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        this.transactions.remove(transaction);
        transaction.setUser(null);
    }

}
