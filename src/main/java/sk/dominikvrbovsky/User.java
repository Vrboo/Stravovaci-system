package sk.dominikvrbovsky;

import sk.dominikvrbovsky.enums.TransactionType;
import sk.dominikvrbovsky.utilities.PasswordUtilities;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents user of the application
 */
@Entity
public class User {

    /**
     * ID - Identifier in database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Username of user
     */
    private String username;

    /**
     * Fullname of user
     */
    private String fullName;

    /**
     * Password of user
     */
    private String password;

    /**
     * Amount on account in €
     */
    private double account;

    /**
     * List of transactions that user performed
     */
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    /**
     * List of orders of user; User can have only one breakfast and one lunch
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orders;


    public User(String username, String fullName, String password) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.account = 0.0;
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

    /**
     * Ordering meal resp. making of order
     * @param meal meal that user want to order
     * @throws Exception
     */
    public void makeOrder(Meal meal) throws Exception {
        if (meal == null) {
            throw new Exception("Objednávanie neprebehlo úspešne. Skuste to znovu.");
        }

        if (meal instanceof  Breakfast && hasBreakfastOrder()) {
            throw new Exception("Už máte objednané raňajky");
        }

        if (meal instanceof  Lunch && hasLunchOrder()) {
            throw new Exception("Už máte objednaný obed");
        }

        if (meal.getPrice() > this.getAccount()) {
            throw new Exception("Nemáte dostatok peňazí na účte");
        }

        if (meal.getCapacity() < 1) {
            throw new Exception("Žiadne voľné porcie");
        }

        this.orders.add(new Order(this, meal));
        this.setAccount(getAccount() - meal.getPrice());
    }

    /**
     * Method that finds out if user already have ordered breakfast
     */
    public boolean hasBreakfastOrder() {
        return this.orders.stream().anyMatch(order -> order.getMeal() instanceof Breakfast);
    }

    /**
     * Method that finds out if user already have ordered lunch
     */
    public boolean hasLunchOrder() {
        return this.orders.stream().anyMatch(order -> order.getMeal() instanceof Lunch);
    }

    /**
     * Method that return order of breakfast
     */
    public Order getBreakfastOrder() {
        return this.orders.stream().filter(order -> order.getMeal() instanceof Breakfast).findFirst().orElse(null);
    }

    /**
     * Method that return order of lunch
     */
    public Order getLunchOrder() {
        return this.orders.stream().filter(order -> order.getMeal() instanceof Lunch).findFirst().orElse(null);
    }

    /**
     * Ordering meal from burza
     * @param order
     * @throws Exception
     */
    public void takeMealFromBurza(Order order) throws Exception {
        if (order == null) {
            throw new Exception("Objednávanie neprebehlo úspešne. Skuste to znovu.");
        }

        if (order.getMeal() instanceof  Breakfast && hasBreakfastOrder()) {
            throw new Exception("Už máte objednané raňajky");
        }

        if (order.getMeal() instanceof  Lunch && hasLunchOrder()) {
            throw new Exception("Už máte objednaný obed");
        }

        if (order.getMeal().getPrice() > this.getAccount()) {
            throw new Exception("Nemáte dostatok peňazí na účte");
        }

        if (order.getMeal().getNumberInBurza() < 1) {
            throw new Exception("Žiadne voľné porcie v burze");
        }

        order.orderFromBurza(this);
        this.setAccount(getAccount() - order.getMeal().getPrice());
    }

    /**
     * Putting money on account
     * @param amount
     */
    public void putMoneyOnAccount(double amount) throws Exception {
        amount = roundedAmountParameter(amount);

        if (amount < 1) {
            throw new Exception("Minimálny vklad na účet je 1 €");
        }


        this.account += amount;
        this.transactions.add(new Transaction(this, TransactionType.INPUT, amount));
    }

    /**
     * Withdrawal money from account
     * @param amount withdrawal amount
     */
    public void withdrawMoneyFromAccount(double amount) throws Exception {
        amount = roundedAmountParameter(amount);

        isAmountParameterValid(amount);

        this.account -= amount;
        this.transactions.add(new Transaction(this, TransactionType.OUTPUT, amount));
    }

    /**
     * Method that finds out if input amount is less than 1 or greater than amount on account of user
     */
    public void isAmountParameterValid(double amount) throws Exception {
        if (amount < 1) {
            throw new Exception("Minimálny výber z účtu je 1 €");
        }

        if (amount > getAccount()) {
            throw new Exception("Suma môže byť maximálne " + getAccountString());
        }
    }

    /**
     * Method that rounded input amount to two decimals
     * @param amount
     * @return
     */
    private double roundedAmountParameter(double amount) {
        if ((amount * 100) % 1 != 0 ) { // find out whether amount has more than two decimals or not
            BigDecimal bd = BigDecimal.valueOf(amount);
            bd = bd.setScale(2 , RoundingMode.HALF_UP);
            amount = bd.doubleValue();
        }
        return amount;
    }

    /**
     * Changing password
     * @param oldPassword old password of the user
     * @param newPassword new password of the user
     * @param newPasswordConfirmation new password of the user again
     */
    public void changePassword(String oldPassword, String newPassword, String newPasswordConfirmation) throws Exception {
        if (getPassword().equals(oldPassword)) {
            if (PasswordUtilities.checkPassword(newPassword)) {
                if (newPassword.equals(newPasswordConfirmation)) {
                    this.setPassword(newPassword);
                } else {
                    throw new Exception("Heslá sa nezhodujú");
                }
            } else {
                throw new Exception("Heslo má nesprávny formát");
            }
        } else {
            throw new Exception("Nesprávne staré heslo");
        }
    }

    /**
     * Method which converts account to string and rounds it to two decimal
     * @return account of user in string and rounded to two decimals
     */
    public String getAccountString() {
        return String.format("%.2f", this.getAccount());
    }



}
