public class AccountController extends FawryController{
    AccountController(Database database){
        this.database = database;
    }
    String addAccount(Admin admin){
        admin.setAccountID(database.accounts.size());
        database.accounts.add(admin);
        return "Account added successfully";
    }
    String addAccount(Client client) {
        client.setAccountID(database.accounts.size());
        database.accounts.add(client);
        return "Account added successfully";
    }
    String addCreditCard(Client client, CreditCard creditCard){
        client.setCreditCard(creditCard);
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
    String addFunds(Client client, double amount){
        CreditCardMethod creditCardMethod = new CreditCardMethod(database);
        return creditCardMethod.addFunds(client, amount);
    }
}
