import java.util.ArrayList;

abstract public class Account {
    String username, email, password;
    ArrayList<String> notifications;
    int AccountID;

    public String getEmail() {
        return email;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public int getAccountID() {
        return AccountID;
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
    abstract public void update(boolean acceptance, Transaction transaction);

}
