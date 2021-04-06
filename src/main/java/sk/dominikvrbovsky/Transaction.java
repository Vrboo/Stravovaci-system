package sk.dominikvrbovsky;

import sk.dominikvrbovsky.enums.TransactionType;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private User user;
    private TransactionType transactionType;
    private double amount;
    private LocalDateTime dateTime;

    public Transaction(User user, TransactionType transactionType, double amount) {
        this.user = user;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String toStringUser() {
        String date = this.dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return String.format("%s %tT - %s: %.2f€", date, this.dateTime.toLocalTime(),
                this.transactionType.toString().toUpperCase(), this.amount );
    }
}
