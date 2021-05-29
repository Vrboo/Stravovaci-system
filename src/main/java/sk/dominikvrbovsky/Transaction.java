package sk.dominikvrbovsky;

import sk.dominikvrbovsky.converters.TransactionTypeConverter;
import sk.dominikvrbovsky.enums.TransactionType;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represent transaction performed by a user
 */
@Entity
public class Transaction {

    /**
     * ID - Identifier in database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User who performed transaction
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_transaction_user_id"))
    private User user;

    /**
     * Type of transaction (input, output)
     */
    @Convert(converter = TransactionTypeConverter.class)
    private TransactionType transactionType;

    /**
     * Transaction amount in €
     */
    private double amount;

    /**
     * Date and time when transaction was performed
     */
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

    /**
     * Method that returns text string containing information about transaction for admin of the application
     */
    public String toStringForAdministrator() {
        String time = this.dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        String date = this.dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd.M.yyyy"));

        return String.format("%s   :   %s   -   %s   -   %s   -   %s€", user.getFullName(), this.transactionType.getTransactionType(),
                date, time, getAmountString());
    }

    /**
     * Method that returns text string containing information about transaction for user who performed this transaction
     */
    public String toStringForUser() {
        String time = this.dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        String date = this.dateTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd.M.yyyy"));

        return String.format("%s   -   %s   -   %s   -   %s€",  this.transactionType.getTransactionType(),
                date, time, getAmountString());
    }

    /**
     * Method which converts amount of the transaction to string and rounds it to two decimal
     * @return price of meal in string and rounded to two decimals
     */
    public String getAmountString() {
        return String.format("%.2f", this.getAmount());
    }


}
