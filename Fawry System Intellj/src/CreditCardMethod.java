public class CreditCardMethod extends PaymentMethod{
    String MethodName = "Credit Card";
    CreditCardMethod(Database database){
        this.database = database;
    }
    @Override
    String pay(Client client, double amount) {
        CreditCardController creditCardController = new CreditCardController(database);
        if(creditCardController.checkValidCreditCard(client.creditCard)){
            if(creditCardController.checkCanPayCreditCard(client.getCreditCard(), amount)){
                CreditCard creditCard = client.creditCard;
                creditCard.setAmount(creditCard.getAmount() - amount);
                client.setCreditCard(creditCard);
                return "Paid Successfully";
            }
            else{
                return "There is no enough money to pay this service";
            }
        }
        else{
            return "There is no credit card with this information";
        }
    }
    String addFunds(Client client, double amount){
        CreditCard creditCard = client.getCreditCard();
        CreditCardController creditCardController = new CreditCardController(database);
        if(creditCardController.checkValidCreditCard(client.creditCard)){
            if(creditCardController.checkCanPayCreditCard(creditCard, amount)){
                creditCard.setAmount(creditCard.getAmount() - amount);
                client.setWallet(client.getWallet() + amount);
                client.setCreditCard(creditCard);
                database.accounts.set(client.getAccountID(), client);
                return "Funds Added Successfully";
            }
            else{
                return "There is no enough money to add funds";
            }
        }
        else{
            return "There is no credit card with this information";
        }
    }
}
