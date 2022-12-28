import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FawryScreen {
    Database database;
    FawryScreen(Database database){
        this.database = database;
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
    Account loginButton(String usernameOrEmail, String password) {
        Authentication authentication = new Authentication(database);
        return authentication.validateLogin(usernameOrEmail, password);
    }

    String signUpButton(Account account) {
        Authentication authentication = new Authentication(database);
        return authentication.validateSignUp(account);
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
        displayClientTransactions(client);
    }
    void displayClientTransactions(Client client){
        if(client.getTransactions().size() > 0) {
            System.out.println("Transactions");
            for (int i = 0; i < client.getTransactions().size(); i++) {
                System.out.println("-------------------------------------");
                System.out.println((i + 1) + "# Transaction");
                System.out.println("Service Name: " + client.getTransactions().get(i).getService().getServiceName());
                System.out.println("Amount: " + client.getTransactions().get(i).getAmount());
                System.out.println("Way of Payment: " + client.getTransactions().get(i).getService().getWaysOfPayment().get(client.getTransactions().get(i).getWayIndex()).getMethodName());
            }
            System.out.println("-------------------------------------");
        }
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
    String addOverallDiscount(OverallDiscount overallDiscount) {
        DiscountController discountController = new DiscountController(database);
        return discountController.addOverallDiscount(overallDiscount);
    }

    void listAllRefundRequest() {
        if(database.refunds.size() > 0) {
            System.out.println("Refund Requests");
            for (int i = 0; i < database.refunds.size(); i++) {
                System.out.println("-------------------------------------");
                System.out.println((i + 1) + "# Refund Request");
                System.out.println("Service Name: " + database.refunds.get(i).transaction.getService().getServiceName());
                System.out.println("Amount: " + database.refunds.get(i).transaction.getAmount());
                System.out.println("Username Account: " + database.refunds.get(i).transaction.getClient().getUsername());
            }
            System.out.println("-------------------------------------");
        }
        else{
            System.out.println("There are no refund requests");
        }
    }
    boolean acceptRefundRequestButton(boolean acceptance, RefundRequest refundRequest) {
        RefundController refundController = new RefundController(database);
        return refundController.applyApproval(acceptance, refundRequest);
    }
    String addRefundRequest(Admin admin, Transaction transaction){
        RefundController refundController = new RefundController(database);
        return refundController.addRefundRequest(admin, transaction);
    }
    boolean checkDiscountAvailable(Service service){
        DiscountController discountController = new DiscountController(database);
        return discountController.checkDiscountAvailable(service);
    }
    void showAvailableDiscounts(Service service){
        MobileServiceController mobileServiceController = new MobileServiceController(database);
        InternetServiceController internetServiceController = new InternetServiceController(database);
        LandlineServiceController landlineServiceController = new LandlineServiceController(database);
        DonationServiceController donationServiceController = new DonationServiceController(database);
        boolean checkMobileService = mobileServiceController.checkDiscountMobileServiceExistance();
        boolean checkInternetService = internetServiceController.checkDiscountInternetServiceExistance();
        boolean checkLandlineService = landlineServiceController.checkDiscountLandlineServiceExistance();
        boolean checkDonationService = donationServiceController.checkDiscountDonationServiceExistance();
        boolean printed = false;
        if(checkMobileService){
            printed = true;
            System.out.println("Mobile Service");
            System.out.println("Service Name: " + service.getServiceName());
            System.out.println("Discount for " + database.mobileServiceDiscount.getPercentage() + "%");
        }
        if(checkInternetService){
            printed = true;
            System.out.println("Internet Service");
            System.out.println("Service Name: " + service.getServiceName());
            System.out.println("Discount for " + database.internetServiceDiscount.getPercentage() + "%");
        }
        if(checkLandlineService){
            printed = true;
            System.out.println("Landline Service");
            System.out.println("Service Name: " + service.getServiceName());
            System.out.println("Discount for " + database.landlineServiceDiscount.getPercentage() + "%");
        }
        if(checkDonationService){
            printed = true;
            System.out.println("Donation Service");
            System.out.println("Service Name: " + service.getServiceName());
            System.out.println("Discount for " + database.donationServiceDiscount.getPercentage() + "%");
        }
        if(!printed){
            System.out.println("There is no discount for this service");
        }
    }
}
