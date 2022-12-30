package com.advancedsoftware.Fawry_System.Refunds;

import com.advancedsoftware.Fawry_System.APIs.AdminAPI;
import com.advancedsoftware.Fawry_System.APIs.ClientAPI;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.*;

@RestController
public class RefundAPI {


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
        RefundRequest refundRequest = Database.getDatabase().refunds.get(index);
        response.setMessage(refundController.applyApproval(refundRequest.paymentTransaction.getClient(), acceptance, refundRequest));
        response.setObject(admin);
        return response;
    }

    @PutMapping(value = "/{username}/refundrequest/{index}")
    Response<Client> addRefundRequest(@PathVariable("username") String usernameClient, @RequestBody int index){
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
