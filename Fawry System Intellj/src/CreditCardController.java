
public class CreditCardController extends FawryController{
    boolean checkValidCreditCard(String creditCardNumber){
        for(int i = 0; i < database.creditCards.size(); i++){
            if(database.creditCards.get(i).getCardNumber().equals(creditCardNumber)){
                return true;
            }
        }
        return false;
    }
    boolean addFunds(Client client, String creditCardNumber, double amount){
        for(int i = 0; i < database.creditCards.size(); i++){
            if(database.creditCards.get(i).getCardNumber().equals(creditCardNumber)){
                if(database.creditCards.get(i).getAmount() >= amount){
                    double currentAmount = database.creditCards.get(i).getAmount();
                    database.creditCards.get(i).setAmount(currentAmount - amount);
                    for(int j = 0; j < database.accounts.size(); j++){
                        if(database.accounts.get(j) instanceof Client){
                            if(database.accounts.get(j).getUsername().equals(client.getUsername())){
                                Client client1 = (Client) database.accounts.get(j);
                                client1.setWallet(client.getWallet() + amount);
                                database.accounts.set(j, client1);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
