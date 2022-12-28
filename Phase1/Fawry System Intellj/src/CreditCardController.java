
public class CreditCardController extends FawryController{
    CreditCardController(Database database){
        this.database = database;
    }
    boolean checkValidCreditCard(CreditCard creditCard){
        if(creditCard == null){
            return false;
        }
        for(int i = 0; i < database.creditCards.size(); i++){
            if(database.creditCards.get(i).getCardNumber().equals(creditCard.getCardNumber())){
                return true;
            }
        }
        return false;
    }
    boolean checkCanPayCreditCard(CreditCard creditCard, double amount){
        for(int i = 0; i < database.creditCards.size(); i++){
            if(database.creditCards.get(i).getCardNumber().equals(creditCard.getCardNumber())){
                if(creditCard.getAmount() >= amount) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    int checkExistenceCreditCard(CreditCard creditCard){
        if(creditCard == null){
            return -2;
        }
        for(int i = 0; i < database.creditCards.size(); i++){
            if(database.creditCards.get(i).getCardNumber().equals(creditCard.getCardNumber())){
                return i;
            }
        }
        return -1;
    }

}
