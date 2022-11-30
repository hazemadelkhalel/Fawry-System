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
    String addFunds(String creditCardNumber, double amount){
        AccountController accountController = new AccountController();
        return accountController.addFunds(creditCardNumber, amount);
    }
    String addClientAccountButton(Client client) {
        AccountController accountController = new AccountController();
        return accountController.addAccount(client);
    }
    void searchButton(String context) {
        SearchController searchController = new SearchController();
        display(searchController.search(context));
    }
    void display(ArrayList<Service> result){
        for(int i = 0; i < result.size(); i++){
            System.out.println("-" + result.get(i).getServiceName());
            Service service = result.get(i);
            for(int j = 0; j < service.providers.size(); j++){
                System.out.println((j + 1) + ") " + service.providers.get(j).getProviderName());
            }
        }
    }

//    void listCategories() {
//        ServiceController serviceController = new ServiceController();
//        serviceController.listCategories();
//    }
    String addServiceButton(Service service) {
        ServiceController serviceController = new ServiceController();
        return serviceController.addService(service);
    }
    String addDiscountButton(OverallDiscount discount) {
        DiscountController discountController = new DiscountController();
        return discountController.addDiscount(discount);
    }
    String addDiscountButton(SpecificDiscount discount) {
        DiscountController discountController = new DiscountController();
        return discountController.addDiscount(discount);
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
