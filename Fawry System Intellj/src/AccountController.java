public class AccountController extends FawryController{
    String addAccount(Admin admin){
        database.accounts.put(admin, "Admin");
        return "Account added successfully";
    }
    String addAccount(Client client) {
        database.accounts.put(client, "Client");
        return "Account added successfully";
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
    String addFunds(String creditCardNumber, double amount){
        CreditCardController creditCardController = new CreditCardController();
        if(creditCardController.checkValidCreditCard(creditCardNumber)){
            if(creditCardController.addFunds(creditCardNumber, amount)){
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
