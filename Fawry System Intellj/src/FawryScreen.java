import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FawryScreen {
    Database database;
    FawryScreen(Database database){
        this.database = database;

        // do it in main and add all services (Initialize the database)

//        Admin admin = new Admin("admin", "admin@gmail.com", "admin");
//        this.database = database;
//        AccountController accountController = new AccountController(database);
//        accountController.addAccount(admin);
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

    void searchMobileServiceButton(String context) {
        MobileServiceController mobileServiceController = new MobileServiceController(database);
        display("Mobile Services", mobileServiceController.searchMobileService( context));
    }
    void searchInternetServiceButton(String context) {
        InternetServiceController internetServiceController = new InternetServiceController(database);
        display("Internet Services", internetServiceController.searchInternetService(context));
    }
    void searchLandlineServiceButton(String context) {
        LandlineServiceController landlineServiceController = new LandlineServiceController(database);
        display("Landline Services", landlineServiceController.searchLandlineService(context));
    }
    void searchDonationServiceButton(String context) {
        DonationServiceController donationServiceController = new DonationServiceController(database);
        display("Donation Services", donationServiceController.searchDonationService(context));
    }
    void display(String category, ArrayList<Service> result){
        if(result.size() == 0){
            System.out.println("No result found");
            return;
        }
        System.out.println("Category " + category + ":");
        for(int i = 0; i < result.size(); i++){
            System.out.println((i + 1) + ") " + result.get(i).getServiceName());
        }
    }
    void display(Service service){
        System.out.println(service.getServiceName());
        for(int i = 0; i < service.getWaysOfPayment().size(); i++){
            System.out.println((i + 1) + ") " + service.getWaysOfPayment().get(i).getMethodName());
        }
    }
    void display(Client client){
        System.out.println("Username: " + client.getUsername());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Wallet: " + client.getWallet());
        System.out.println("Transactions");
        if(client.getTransactions().size() > 0) {
            for (int i = 0; i < client.getTransactions().size(); i++) {
                System.out.println("-------------------------------------");
                System.out.println((i + 1) + "# Transaction");
                System.out.println("Service Name: " + client.getTransactions().get(i).getService().getServiceName());
                System.out.println("Amount: " + client.getTransactions().get(i).getAmount());
                System.out.println("Way of Payment: " + client.getTransactions().get(i).getService().getWaysOfPayment().get(client.getTransactions().get(i).getWayIndex()).getMethodName());
            }
        }
        else{
            System.out.println("There is no transaction yet");
        }
        System.out.println("-------------------------------------");
    }
    String payButtonMobileService(Client client, Service service, double amount, int wayIndex) {
        PaymentController paymentController = new PaymentController(database);
        return paymentController.payMobileService(client, service, amount, wayIndex);
    }
    String payButtonInternetService(Client client, Service service, double amount, int wayIndex) {
        PaymentController paymentController = new PaymentController(database);
        return paymentController.payInternetService(client, service, amount, wayIndex);
    }
    String payButtonLandlineService(Client client, Service service, double amount, int wayIndex) {
        PaymentController paymentController = new PaymentController(database);
        return paymentController.payLandlineService(client, service, amount, wayIndex);
    }
    String payButtonDonationService(Client client, Service service, double amount, int wayIndex) {
        PaymentController paymentController = new PaymentController(database);
        return paymentController.payDonationService(client, service, amount, wayIndex);
    }
    double applyDiscountMobileServiceButton(Service service, Client client, double amount){
        DiscountController discountController = new DiscountController(database);
        return discountController.applyDiscountMobileService(service, client, amount);
    }
    double applyDiscountInternetServiceButton(Service service, Client client, double amount){
        DiscountController discountController = new DiscountController(database);
        return discountController.applyDiscountInternetService(service, client, amount);
    }
    double applyDiscountLandlineServiceButton(Service service, Client client, double amount){
        DiscountController discountController = new DiscountController(database);
        return discountController.applyDiscountLandlineService(service, client, amount);
    }
    double applyDiscountDonationServiceButton(Service service, Client client, double amount){
        DiscountController discountController = new DiscountController(database);
        return discountController.applyDiscountDonationService(service, client, amount);
    }
    String addMobileServiceDiscount(SpecificDiscount specificDiscount){
        DiscountController discountController = new DiscountController(database);
        return discountController.addMobileServiceDiscount(specificDiscount);
    }

    String addInternetServiceDiscount(SpecificDiscount specificDiscount){
        DiscountController discountController = new DiscountController(database);
        return discountController.addInternetServiceDiscount(specificDiscount);
    }
    String addDonationServiceDiscount(SpecificDiscount specificDiscount){
        DiscountController discountController = new DiscountController(database);
        return discountController.addDonationServiceDiscount(specificDiscount);
    }
    String addLandLineServiceDiscount(SpecificDiscount specificDiscount){
        DiscountController discountController = new DiscountController(database);
        return discountController.addLandLineServiceDiscount(specificDiscount);
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
