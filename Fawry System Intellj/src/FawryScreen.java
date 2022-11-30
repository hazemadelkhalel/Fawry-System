import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FawryScreen {
    FawryScreen(){
        Admin admin = new Admin("admin", "admin@gmail.com", "admin");
        AccountController accountController = new AccountController();
        accountController.addAccount(admin);
    }
    void displayUserMenu(){

    }
    void displayAdminMenu(){

    }
    String loginButton(Client client) {
        Authentication authentication = new Authentication();
        return authentication.validateLogin(client);
    }

    String signUpButton(Client client) {
        Authentication authentication = new Authentication();
        return authentication.validateSignUp(client);
    }

    String addAdminAccountButton(Admin admin) {
        AccountController accountController = new AccountController();
        return accountController.addAccount(admin);
    }

    String addClientAccountButton(Client client) {
        AccountController accountController = new AccountController();
        return accountController.addAccount(client);
    }
    void searchButton(String context) {
        
    }

//    void listCategories() {
//        ServiceController serviceController = new ServiceController();
//        serviceController.listCategories();
//    }
    void addServiceButton(String categoryService, HashMap<String, ArrayList<String>> service) {
        
    }
    void addDiscountButton(String categoryDiscount, Database.Pair<String, Integer> valueDiscount) {
        
    }
//    void payButton(Client client, MobileService service, double amount) {
//        // payment process
//    }

    void listAllTransactionButton() {
        // calling list all transaction from controller
    }
    // change boolean
    void acceptTransactionButton() {
        // return acceptance of check approval
    }
}
