import java.util.ArrayList;

public class Client extends Account{
    CreditCard creditCard;
    double wallet = 0;
//    ArrayList<Transaction> listOverallDiscounts = new ArrayList<OverallDiscount>();
    Client(String username, String email, String password, double wallet){
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = null;
        this.wallet = wallet;
        transactions = new ArrayList<>();
    }
<<<<<<< Updated upstream

=======
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
>>>>>>> Stashed changes
}
