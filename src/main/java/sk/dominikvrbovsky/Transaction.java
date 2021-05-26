package sk.dominikvrbovsky;

import sk.dominikvrbovsky.converters.TransactionTypeConverter;
import sk.dominikvrbovsky.enums.TransactionType;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_transaction_user_id"))
    private User user;

    @Convert(converter = TransactionTypeConverter.class)
    private TransactionType transactionType;

    private double amount;

    private LocalDateTime dateTime;

    public Transaction(User user, TransactionType transactionType, double amount) {
        this.user = user;
        this.transactionType = transactionType;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public Transaction() {
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

    public String toStringForAdministrator() {
        String time = this.dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        String date = this.dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd.M.yyyy"));

        return String.format("%s   :   %s   -   %s   -   %s   -   %s€", user.getFullName(), this.transactionType.getTransactionType(),
                date, time, getAmountString());
    }

    public String toStringForUser() {
        String time = this.dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        String date = this.dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd.M.yyyy"));

        return String.format("%s   -   %s   -   %s   -   %s€",  this.transactionType.getTransactionType(),
                date, time, getAmountString());
    }

    public String getAmountString() {
        return String.format("%.2f", this.getAmount());
    }


}
