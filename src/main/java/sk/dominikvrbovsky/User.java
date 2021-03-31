package sk.dominikvrbovsky;

public class User {

    private String username;
    private String fullName;
    private String password;
    private double account;

    public User(String username, String fullName, String password, double account) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.account = account;
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
}
