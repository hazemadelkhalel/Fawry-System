package com.advancedsoftware.Fawry_System.Refunds;

import com.advancedsoftware.Fawry_System.APIs.AdminAPI;
import com.advancedsoftware.Fawry_System.APIs.ClientAPI;
import com.advancedsoftware.Fawry_System.APIs.FawryScreenAPI;
import com.advancedsoftware.Fawry_System.Controllers.AccountController;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RefundAPI {

    public static boolean checkSubscription(Account account){
        RefundRequestManager refundRequestManager = RefundRequestManager.getRefundRequestManager();
        for(int i = 0; i < refundRequestManager.accounts.size(); i++){
            if(refundRequestManager.accounts.get(i) == account){
                return true;
            }
        }
        return false;
    }
    @PutMapping(value = "/{username}/refunds/{index}")
    Response<Admin> acceptRefundRequestButton(@PathVariable("username") String usernameAdmin, @RequestBody boolean acceptance, @PathVariable("index") int index) {
        Admin admin = AdminAPI.getAdmin(usernameAdmin);
        Response<Admin> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an Admin");
            return response;
        }
        if(index > Database.getDatabase().refunds.size() || index < 1){
            response.setStatus(false);
            response.setMessage("The is no such a refund request with this index");
            return response;
        }
        RefundController refundController = RefundController.getRefundController();
        index--;
        response.setStatus(true);
        RefundTransaction refundRequest = Database.getDatabase().refunds.get(index);
        response.setMessage(refundController.applyApproval(refundRequest, acceptance));
        response.setObject(admin);
        return response;
    }

    @GetMapping(value = "/{username}/refunds/{index}")
    Response<RefundTransaction> showRefundRequest(@PathVariable("username") String usernameAdmin, @PathVariable("index") int index) {
        Admin admin = AdminAPI.getAdmin(usernameAdmin);
        Response<RefundTransaction> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an Admin");
            return response;
        }
        if(index > Database.getDatabase().refunds.size() || index < 1){
            response.setStatus(false);
            response.setMessage("The is no such a refund request with this index");
            return response;
        }
        index--;
        response.setStatus(true);
        RefundTransaction refundRequest = Database.getDatabase().refunds.get(index);
        response.setMessage("Found Refund Request");
        response.setObject(refundRequest);
        return response;
    }

    @PutMapping(value = "/{username}/refundrequest/{index}")
    Response<Client> addRefundRequest(@PathVariable("username") String usernameClient, @PathVariable("index") int index){
        Client client = ClientAPI.getClient(usernameClient);
        Response<Client> response = new Response<>();
        if(client == null){
            response.setStatus(false);
            response.setMessage("There is no such a client");
            return response;
        }
        if(index > Database.getDatabase().paymentTransactions.get(client).size() || index < 1){
            response.setStatus(false);
            response.setMessage("The is no such a transaction with this index");
            return response;
        }
        index--;
        response.setStatus(true);
        PaymentTransaction paymentTransaction = Database.getDatabase().paymentTransactions.get(client).get(index);
        RefundController refundController = RefundController.getRefundController();
        response.setMessage(refundController.addRefundRequest(paymentTransaction));
        response.setObject(client);
        return response;
    }

    @PutMapping(value = "/{username}/notifications/subscribe")
    Response<String> subscribeRefundRequests(@PathVariable("username") String usernameClient){
        Account account = FawryScreenAPI.getAccount(usernameClient);
        Response<String> response = new Response<>();
        if(account == null){
            response.setMessage("There is no such a account");
            response.setStatus(false);
        }
        boolean check = checkSubscription(account);
        if(check){
            response.setStatus(false);
            response.setMessage("This account already subscribed");
            return response;
        }
        response.setStatus(true);
        RefundRequestManager refundRequestManager = RefundRequestManager.getRefundRequestManager();
        response.setMessage(refundRequestManager.subscribe(account));
        return response;
    }

    @PutMapping(value = "/{username}/notifications/unsubscribe")
    Response<String> unsubscribeRefundRequests(@PathVariable("username") String usernameClient){
        Account account = FawryScreenAPI.getAccount(usernameClient);
        Response<String> response = new Response<>();
        if(account == null){
            response.setMessage("There is no such a account");
            response.setStatus(false);
        }
        boolean check = checkSubscription(account);
        if(!check){
            response.setStatus(false);
            response.setMessage("This account already unsubscribed");
            return response;
        }
        response.setStatus(true);
        RefundRequestManager refundRequestManager = RefundRequestManager.getRefundRequestManager();
        response.setMessage(refundRequestManager.unsubscribe(account));
        return response;
    }

    @GetMapping(value = "/{username}/transactions/refunds")
    Response<ArrayList<RefundTransaction>> listAllRefundRequest(@PathVariable("username") String usernameClient){
        Account account = AdminAPI.getAdmin(usernameClient);
        Response<ArrayList<RefundTransaction>> response = new Response<>();
        if(account == null){
            response.setMessage("There is no such an admin");
            response.setStatus(false);
        }
        response.setStatus(true);
        response.setMessage("Refund transactions: " + Database.getDatabase().refunds.size());
        response.setObject(Database.getDatabase().refunds);
        return response;
    }

//    void listAllRefundRequest() {
//        if(Database.getDatabase().refunds.size() > 0) {
//            System.out.println("Refund Requests");
//            for (int i = 0; i < Database.getDatabase().refunds.size(); i++) {
//                System.out.println("-------------------------------------");
//                System.out.println((i + 1) + "# Refund Request");
//                System.out.println("Service Name: " + Database.getDatabase().refunds.get(i).paymentTransaction.getService().getServiceName());
//                System.out.println("Amount: " + Database.getDatabase().refunds.get(i).paymentTransaction.getAmount());
//                System.out.println("Username Account: " + Database.getDatabase().refunds.get(i).paymentTransaction.getClient().getUsername());
//            }
//            System.out.println("-------------------------------------");
//        }
//        else{
//            System.out.println("There are no refund requests");
//        }
//    }
}
