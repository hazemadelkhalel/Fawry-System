import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FawryScreen {
    Database database;
    FawryScreen(Database database){
        Admin admin = new Admin("admin", "admin@gmail.com", "admin");
        this.database = database;
        AccountController accountController = new AccountController(database);
        accountController.addAccount(admin);
    }
    void displayUserMenu(){
        for(int i = 0; i < database.accounts.size(); i++){
            if(database.accounts.get(i) instanceof Client){
                System.out.println(database.accounts.get(i).getUsername());
                System.out.println(database.accounts.get(i).getEmail());
                System.out.println(((Client) database.accounts.get(i)).getWallet());
            }
        }
    }
    void displayAdminMenu(){
        for(int i = 0; i < database.accounts.size(); i++){
            if(database.accounts.get(i) instanceof Admin){
                System.out.println(database.accounts.get(i).getUsername());
                System.out.println(database.accounts.get(i).getEmail());
            }
        }
    }
    String loginButton(Client client) {
        Authentication authentication = new Authentication(database);
        return authentication.validateLogin(client);
    }

    String signUpButton(Client client) {
        Authentication authentication = new Authentication(database);
        return authentication.validateSignUp(client);
    }

    String addAccountButton(Admin admin) {
        AccountController accountController = new AccountController(database);
        return accountController.addAccount(admin);
    }
    String addClientAccountButton(Client client) {
        AccountController accountController = new AccountController(database);
        return accountController.addAccount(client);
    }
    String addFunds(Client client, double amount){
        AccountController accountController = new AccountController(database);
        return accountController.addFunds(client, amount);
    }
    String addCreditCard(Client client, CreditCard creditCard){
        AccountController accountController = new AccountController(database);
        return accountController.addCreditCard(client, creditCard);
    }

    void searchButton(String context) {
        SearchController searchController = new SearchController(database);
        display(searchController.search(context));
    }
    void display(ArrayList<Service> result){
        for(int i = 0; i < result.size(); i++){
            System.out.println("Category " + result.get(i).getServiceName() + ":");
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
