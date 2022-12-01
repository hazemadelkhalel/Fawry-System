public class AccountController extends FawryController{
    String addAccount(Admin admin){
        database.accounts.add(admin);
        return "Account added successfully";
    }
    String addAccount(Client client) {
        database.accounts.add(client);
        return "Account added successfully";
    }
    String addCreditCard(Client client, CreditCard creditCard){
        client.setCreditCard(creditCard);
        CreditCardController creditCardController = new CreditCardController(database);
        int indexCreditCard = creditCardController.checkExistenceCreditCard(creditCard);
        if(indexCreditCard == -2){
            return "Please Enter a valid Credit Card";
        }
        else if(indexCreditCard == -1){
            database.creditCards.add(creditCard);
        }
        else{
            database.creditCards.set(indexCreditCard, creditCard);
        }
        return "Credit Card added successfully";
    }
    boolean checkAccountLogin(Account client1, Client client2){
        if(client1.getUsername().equals(client2.getUsername()) &&
                client1.getEmail().equals(client2.getEmail()) &&
                client1.getPassword().equals(client2.getPassword())) {
            return true;
        }
        else{
            return false;
        }
    }
    boolean checkAccountSignUp(Account client1, Client client2){
        if(client1.getUsername().equals(client2.getUsername()) ||
                client1.getEmail().equals(client2.getEmail())) {
            return false;
        }
        else{
            return true;
        }
    }
    String addFunds(Client client, String creditCardNumber, double amount){
        CreditCardController creditCardController = new CreditCardController();
        if(creditCardController.checkValidCreditCard(creditCardNumber)){
            if(creditCardController.addFunds(client, creditCardNumber, amount)){
                return "Added Successfully";
            }
            else{
                return "There is no enough money to complete payment";
            }
        }
        else{
            return "There is no credit card with this number";
        }
    }
}
