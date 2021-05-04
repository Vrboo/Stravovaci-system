package sk.dominikvrbovsky;

import sk.dominikvrbovsky.enums.TransactionType;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;


    public User(String username, String fullName, String password, double account) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.account = account;
        this.transactions = new ArrayList<>();
        this.orders = new ArrayList<>();
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void makeOrder(Meal meal) throws Exception {
        if (meal instanceof  Breakfast && this.orders.stream().anyMatch(order -> order.getMeal() instanceof Breakfast)) {
            throw new Exception("Už máte objednané raňajky");
        }

        if (meal instanceof  Lunch && this.orders.stream().anyMatch(order -> order.getMeal() instanceof Lunch)) {
            throw new Exception("Už máte objednaný obed");
        }

        if (meal.getPrice() > this.getAccount()) {
            throw new Exception("Nemáte dostatok peňazí na účte");
        }

        if (meal.getCapacity() < 1) {
            throw new Exception("ˇŽiadne voľné porcie");
        }

        this.orders.add(new Order(this, meal));
        this.setAccount(getAccount() - meal.getPrice());
    }

    public void addMealToBurza(Order order) {
        order.addToBurza();
    }

    public void takeMealFromBurza(Order order) {
        order.orderFromBurza(this);
//        if (order.getMeal() instanceof Breakfast) this.breakfastOrder = order;
//        if (order.getMeal() instanceof Lunch) this.lunchOrder = order;
    }

    public void putMoneyOnAccount(double amount) {
        this.account += amount;
        this.transactions.add(new Transaction(this, TransactionType.INPUT, amount));
    }

    public void withdrawMoneyFromAccount(double amount) {
        this.account -= amount;
        this.transactions.add(new Transaction(this, TransactionType.OUTPUT, amount));
    }

    public String getAccountString() {
        return String.format("%.2f", this.getAccount());
    }



}
