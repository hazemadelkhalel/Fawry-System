import java.util.Map;

public class Authentication {
    Database database;
    Authentication(){
        database = new Database();
    }

    String validateLogin(Client client) {
        AccountController accountController = new AccountController();
        for(int i = 0; i < database.accounts.size(); i++){
            if(database.accounts.get(i) instanceof Client){
                if(accountController.checkAccountLogin(database.accounts.get(i), client)){
                    return "Login";
                }
            }
        }
        // -1 represent there is no user with this information in system
        return "-1";
    }
    String validateSignUp(Client client) {
        AccountController accountController = new AccountController();
        for(int i = 0; i < database.accounts.size(); i++){
            if(accountController.checkAccountLogin(database.accounts.get(i), client)){
                return "-1";
            }
        }
        // -1 represent there is no user with this information in system
        return "SignUP";
    }
    void validateCreditCard(CreditCardController creditCard) {
        // check if it was correct or not
    }
}
