package sk.dominikvrbovsky;

import java.util.ArrayList;

public class User {

    private String username;
    private String fullName;
    private String password;
    private double account;
    private ArrayList<Transaction> transactions;
    private ArrayList<Order> orders;

    public User(String username, String fullName, String password, double account) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.account = account;
        this.transactions = new ArrayList<>();
        this.orders = new ArrayList<>();
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

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
