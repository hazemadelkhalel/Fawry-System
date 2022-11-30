import java.util.Map;

public class Authentication {
    Database database;
    Authentication(){
        database = new Database();
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
    String validateLogin(Client client) {
        for(Map.Entry <Account, String> entry : database.accounts.entrySet()){
            Account account = entry.getKey();
            if(checkAccountLogin(account, client)){
                // Can Login and return the type of account
                // admin or clinet
                return entry.getValue();
            }
        }
        // -1 represent there is no user with this information in system
        return "-1";
    }
    String validateSignUp(Client client) {
        for(Map.Entry <Account, String> entry : database.accounts.entrySet()){
            Account account = entry.getKey();
            if(checkAccountSignUp(account, client)){
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
