import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FawryScreen {
    Database database;
    FawryScreen(){
        Admin admin = new Admin("admin", "admin@gmail.com", "admin");
        database = new Database();
        AccountController accountController = new AccountController(database);
        accountController.addAccount(admin);
    }
    void displayUserMenu(){

    }
    void displayAdminMenu(){

    }
    String loginButton(Client client) {
        Authentication authentication = new Authentication(database);
        return authentication.validateLogin(client);
    }

    String signUpButton(Client client) {
        Authentication authentication = new Authentication(database);
        return authentication.validateSignUp(client);
    }

    String addAdminAccountButton(Admin admin) {
        AccountController accountController = new AccountController(database);
        return accountController.addAccount(admin);
    }
    String addFunds(Client client, double amount){
        AccountController accountController = new AccountController(database);
        return accountController.addFunds(client, amount);
    }
    String addCreditCard(Client client, CreditCard creditCard){
        AccountController accountController = new AccountController(database);
        return accountController.addCreditCard(client, creditCard);
    }
    String addClientAccountButton(Client client) {
        AccountController accountController = new AccountController(database);
        return accountController.addAccount(client);
    }
    void searchButton(String context) {
        SearchController searchController = new SearchController(database);
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


    String addServiceButton(Service service) {
        ServiceController serviceController = new ServiceController(database);
        return serviceController.addService(service);
    }
    String addDiscountButton(OverallDiscount discount) {
        DiscountController discountController = new DiscountController(database);
        return discountController.addDiscount(discount);
    }
    String addDiscountButton(SpecificDiscount discount) {
        DiscountController discountController = new DiscountController(database);
        return discountController.addDiscount(discount);
    }
    String payButton(Client client, int indexService, int indexProvider, double amount, int wayIndex) {
        PaymentController paymentController = new PaymentController(database);
        return paymentController.pay(client, indexService, indexProvider, amount, wayIndex);
    }

//        void listCategories() {
//        ServiceController serviceController = new ServiceController();
//        serviceController.listCategories();
//    }
//    void listAllTransactionButton() {
//        // calling list all transaction from controller
//    }
//    // change boolean
//    void acceptTransactionButton() {
//        // return acceptance of check approval
//    }
}
