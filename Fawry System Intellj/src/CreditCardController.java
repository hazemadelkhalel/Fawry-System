
public class CreditCardController extends FawryController{
    boolean checkValidCreditCard(String creditCardNumber){
        for(int i = 0; i < database.creditCards.size(); i++){
            if(database.creditCards.get(i).getCardNumber().equals(creditCardNumber)){
                return true;
            }
        }
        return false;
    }
    boolean addFunds(String creditCardNumber, double amount){
        for(int i = 0; i < database.creditCards.size(); i++){
            if(database.creditCards.get(i).getCardNumber().equals(creditCardNumber)){
                if(database.creditCards.get(i).getAmount() >= amount){
                    double currentAmount = database.creditCards.get(i).getAmount();
                    database.creditCards.get(i).setAmount(currentAmount + amount);
                    return true;
                }
            }
        }
        return false;
    }
}
