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
        SearchController searchController = new SearchController();
        searchController.listSearchResult(searchController.search(context));
    }

//    void listCategories() {
//        ServiceController serviceController = new ServiceController();
//        serviceController.listCategories();
//    }
    String addServiceButton(String categoryService, HashMap<String, ArrayList<String>> service) {
        ServiceController serviceController = new ServiceController();
        return serviceController.addService(categoryService, service);
    }
    String addDiscountButton(String categoryDiscount, Database.Pair<String, Integer> valueDiscount) {
        DiscountController discountController = new DiscountController();
        return discountController.addDiscount(categoryDiscount, valueDiscount);
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
