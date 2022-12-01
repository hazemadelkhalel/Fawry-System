import java.util.ArrayList;

public class Client extends Account{
    CreditCard creditCard;
    double wallet = 0;
    ArrayList<Transaction> transactions;
    Client(String username, String email, String password, double wallet){
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = null;
        this.wallet = wallet;
        transactions = new ArrayList<>();
    }
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double getWallet() {
        return wallet;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

}
