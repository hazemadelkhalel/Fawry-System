import java.util.ArrayList;

public class Client extends Account{
    CreditCard creditCard;
    double wallet = 0;
//    ArrayList<Transaction> listOverallDiscounts = new ArrayList<OverallDiscount>();
    Client(String username, String email, String password, CreditCard creditCard, double wallet){
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.wallet = wallet;
        transactions = new ArrayList<>();
    }

}
