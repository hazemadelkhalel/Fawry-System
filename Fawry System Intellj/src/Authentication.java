import java.util.Map;

public class Authentication extends FawryController{
    Authentication(Database database){
        this.database = database;
    }

    String validateLogin(Client client) {
        AccountController accountController = new AccountController(database);
        for(int i = 0; i < database.accounts.size(); i++){
            if(database.accounts.get(i) instanceof Client){
                if(accountController.checkAccountLogin(database.accounts.get(i), client)){
                    return "Logged in successfully";
                }
            }
        }
        // -1 represent there is no user with this information in system
        return "-1";
    }
    String validateSignUp(Client client) {
        AccountController accountController = new AccountController(database);
        for(int i = 0; i < database.accounts.size(); i++){
            if(accountController.checkAccountSignUp(database.accounts.get(i), client)){
                return "-1";
            }
        }
        database.accounts.add(client);
        // -1 represent there is no user with this information in system
        return "Signed up successfully";
    }
    void validateCreditCard(CreditCardController creditCard) {
        // check if it was correct or not
    }
}
