import java.util.Map;

public class Authentication {
    Database database;
    Authentication(){
        database = new Database();
    }

    String validateLogin(Client client) {
        AccountController accountController = new AccountController();
        for(Map.Entry <Account, String> entry : database.accounts.entrySet()){
            Account account = entry.getKey();
            if(accountController.checkAccountLogin(account, client)){
                // Can Login and return the type of account
                // admin or clinet
                return entry.getValue();
            }
        }
        // -1 represent there is no user with this information in system
        return "-1";
    }
    String validateSignUp(Client client) {
        AccountController accountController = new AccountController();
        for(Map.Entry <Account, String> entry : database.accounts.entrySet()){
            Account account = entry.getKey();
            if(accountController.checkAccountSignUp(account, client)){
                // -1 represent there is matching with other client's username or email in system
                // Can Login and return the type of account
                // admin or clinet
                return "-1";
            }
        }
        return "OK";
    }
    void validateCreditCard(CreditCard creditCard) {
        // check if it was correct or not
    }
}
