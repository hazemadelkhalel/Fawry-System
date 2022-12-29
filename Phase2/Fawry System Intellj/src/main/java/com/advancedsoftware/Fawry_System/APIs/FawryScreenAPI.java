package com.advancedsoftware.Fawry_System.APIs;
import com.advancedsoftware.Fawry_System.Controllers.*;
import com.advancedsoftware.Fawry_System.Discounts.*;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Payments.*;
import com.advancedsoftware.Fawry_System.Refunds.*;
import com.advancedsoftware.Fawry_System.Services.*;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class FawryScreenAPI {
    public static Account getAccount(String usernameOrEmail){
        Account account = null;
        for(int i = 0; i < Database.getDatabase().accounts.size(); i++){
            if(usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getUsername()) || usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getEmail())){
                account = Database.getDatabase().accounts.get(i);
                break;
            }

        }
        return account;
    }
    @RequestMapping("/login")
    Response<Account> loginButton(@RequestBody Account account) {
        Response<Account> response = new Response<>();
        String existAccountMessage = AuthenticationController.getAuthenticationController().validateLogin(account);
        response.setMessage(existAccountMessage);
        if(existAccountMessage.equals("There is no such an account")){
            response.setStatus(false);
        }
        else{
            if(existAccountMessage.equals("Login Successfully")){
                response.setStatus(true);
                response.setObject(getAccount(account.getUsername()));
            }
        }
        return response;
    }
    @GetMapping(value = "/profile/{username}")
    Response<Account> displayClient(@PathVariable("username") String usernameClient) {
        Account account = getAccount(usernameClient);
        Response<Account> response = new Response<>();
        if(account == null){
            response.setStatus(false);
            response.setMessage("There is no such an account");
            return response;
        }
        else{
            response.setStatus(true);
            response.setMessage("Found account");
            response.setObject(account);
        }
        return response;
    }
    @GetMapping(value = "/{username}")
    Response<Account> displayProfile(@PathVariable("username") String usernameOrEmail){
        Account account = null;
        for(int i = 0; i < Database.getDatabase().accounts.size(); i++){
            if(Database.getDatabase().accounts.get(i) instanceof Client){
                if(usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getUsername()) || usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getEmail())){
                    account = Database.getDatabase().accounts.get(i);
                    break;
                }
            }
        }
        Response<Account> response = new Response<>();
        if(account == null){
            response.setMessage("There is no such a user");
            response.setStatus(false);
        }
        else{
            response.setStatus(true);
            response.setObject(account);
            response.setMessage("Exist");
        }
        return response;
    }
    // Testing initialization
//    @GetMapping("/get")
//    Response<String> get(){
//        Response<String> response = new Response<>();
//        if(database.mobileServices.isEmpty()){
//            response.setStatus(false);
//            response.setMessage("NO THING");
//        }
//        else{
//            response.setStatus(true);
//            response.setMessage("exist");
//            response.setObject(database.mobileServices.get(0).getServiceName());
//        }
//        return response;
//    }



//    void display(String category, ArrayList<Service> result){
//        if(result.size() == 0){
//            System.out.println("No result found");
//            return;
//        }
//        System.out.println("Category " + category + ":");
//        for(int i = 0; i < result.size(); i++){
//            System.out.println((i + 1) + ") " + result.get(i).getServiceName());
//        }
//    }
//    void display(Service service){
//        System.out.println(service.getServiceName());
//        for(int i = 0; i < service.getWaysOfPayment().size(); i++){
//            System.out.println((i + 1) + ") " + service.getWaysOfPayment().get(i).getMethodName());
//        }
//    }
//    void display(Client client){
//        System.out.println("Username: " + client.getUsername());
//        System.out.println("Email: " + client.getEmail());
//        System.out.println("Wallet: " + client.getWallet());
//        displayClientTransactions(client);
//    }
//    void displayClientTransactions(Client client){
//        if(client.getTransactions().size() > 0) {
//            System.out.println("Transactions");
//            for (int i = 0; i < client.getTransactions().size(); i++) {
//                System.out.println("-------------------------------------");
//                System.out.println((i + 1) + "# Transaction");
//                System.out.println("Service Name: " + client.getTransactions().get(i).getService().getServiceName());
//                System.out.println("Amount: " + client.getTransactions().get(i).getAmount());
//                System.out.println("Way of Payment: " + client.getTransactions().get(i).getService().getWaysOfPayment().get(client.getTransactions().get(i).getWayIndex()).getMethodName());
//            }
//            System.out.println("-------------------------------------");
//        }
//    }



    void listAllRefundRequest() {
        if(Database.getDatabase().refunds.size() > 0) {
            System.out.println("Refund Requests");
            for (int i = 0; i < Database.getDatabase().refunds.size(); i++) {
                System.out.println("-------------------------------------");
                System.out.println((i + 1) + "# Refund Request");
                System.out.println("Service Name: " + Database.getDatabase().refunds.get(i).transaction.getService().getServiceName());
                System.out.println("Amount: " + Database.getDatabase().refunds.get(i).transaction.getAmount());
                System.out.println("Username Account: " + Database.getDatabase().refunds.get(i).transaction.getClient().getUsername());
            }
            System.out.println("-------------------------------------");
        }
        else{
            System.out.println("There are no refund requests");
        }
    }
    boolean acceptRefundRequestButton(Client client, boolean acceptance, RefundRequest refundRequest) {
        RefundController refundController = RefundController.getRefundController();
        return refundController.applyApproval(client, acceptance, refundRequest);
    }
    String addRefundRequest(Admin admin, Transaction transaction){
        RefundController refundController = RefundController.getRefundController();
        return refundController.addRefundRequest(admin, transaction);
    }
    boolean checkDiscountAvailable(Service service){
        DiscountController discountController = DiscountController.getDiscountController();
        return discountController.checkDiscountAvailable(service);
    }
    void showAvailableDiscounts(Service service){
        MobileServiceController mobileServiceController = MobileServiceController.getMobileServiceController();
        InternetServiceController internetServiceController = InternetServiceController.getInternetServiceController();
        LandlineServiceController landlineServiceController = LandlineServiceController.getLandlineServiceController();
        DonationServiceController donationServiceController = DonationServiceController.getDonationServiceController();
        boolean checkMobileService = mobileServiceController.checkDiscountMobileServiceExistance();
        boolean checkInternetService = internetServiceController.checkDiscountInternetServiceExistance();
        boolean checkLandlineService = landlineServiceController.checkDiscountLandlineServiceExistance();
        boolean checkDonationService = donationServiceController.checkDiscountDonationServiceExistance();
        boolean printed = false;
        if(checkMobileService){
            printed = true;
            System.out.println("Mobile Service");
            System.out.println("Service Name: " + service.getServiceName());
            System.out.println("Discount for " + Database.getDatabase().mobileServiceDiscount.getPercentage() + "%");
        }
        if(checkInternetService){
            printed = true;
            System.out.println("Internet Service");
            System.out.println("Service Name: " + service.getServiceName());
            System.out.println("Discount for " + Database.getDatabase().internetServiceDiscount.getPercentage() + "%");
        }
        if(checkLandlineService){
            printed = true;
            System.out.println("Landline Service");
            System.out.println("Service Name: " + service.getServiceName());
            System.out.println("Discount for " + Database.getDatabase().landlineServiceDiscount.getPercentage() + "%");
        }
        if(checkDonationService){
            printed = true;
            System.out.println("Donation Service");
            System.out.println("Service Name: " + service.getServiceName());
            System.out.println("Discount for " + Database.getDatabase().donationServiceDiscount.getPercentage() + "%");
        }
        if(!printed){
            System.out.println("There is no discount for this service");
        }
    }
}

