import javax.management.Notification;
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
        notifications = new ArrayList<>();
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
    public void update(boolean acceptance, Transaction transaction){
        transactions.remove(transaction);
        if(acceptance){
            transaction.getClient().setWallet(transaction.getClient().getWallet() + transaction.getAmount());
            notifications.add("Accepted Refund Request of "  + transaction.getService().getServiceName());
        }
        else{
            notifications.add("Refused Refund Request");
        }
    }
}
