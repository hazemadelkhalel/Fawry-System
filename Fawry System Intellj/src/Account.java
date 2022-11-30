import java.util.ArrayList;

public class Account {
    String username, email, password;
    int AccountID;
    ArrayList<Transaction> transactions;

    public String getEmail() {
        return email;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
