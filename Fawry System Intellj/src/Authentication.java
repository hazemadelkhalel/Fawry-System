import java.util.Map;

public class Authentication extends FawryController{
    Authentication(Database database){
        this.database = database;
    }

    Account validateLogin(String usernameOrEmail, String password) {
        AccountController accountController = new AccountController(database);
        for(int i = 0; i < database.accounts.size(); i++){
            if(accountController.checkAccountLogin(database.accounts.get(i), usernameOrEmail, password)){
                return database.accounts.get(i);
            }
        }
        // -1 represent there is no user with this information in system
        return null;
    }
    String validateSignUp(Account account) {
        AccountController accountController = new AccountController(database);
        for(int i = 0; i < database.accounts.size(); i++){
            if(accountController.checkAccountSignUp(database.accounts.get(i), account)){
                return "-1";
            }
        }
        database.accounts.add(account);
        // -1 represent there is no user with this information in system
        return "OK";
    }
}
