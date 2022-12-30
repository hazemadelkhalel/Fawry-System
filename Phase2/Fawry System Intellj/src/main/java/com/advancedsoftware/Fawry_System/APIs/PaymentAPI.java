package com.advancedsoftware.Fawry_System.APIs;

import com.advancedsoftware.Fawry_System.Discounts.DiscountController;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Payments.PaymentController;
import com.advancedsoftware.Fawry_System.Services.Service;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class PaymentAPI {
    ArrayList<PaymentTransaction> getAllPaymentTransactions(){
        ArrayList<PaymentTransaction> paymentTransactions = new ArrayList<>();
        for(Map.Entry<Client, ArrayList<PaymentTransaction>> entry: Database.getDatabase().paymentTransactions.entrySet()){
            ArrayList<PaymentTransaction> temp = entry.getValue();
            paymentTransactions.addAll(temp);
        }
        return paymentTransactions;
    }
    @PutMapping(value = "/{username}/pay/mobile/{service}/{wayIndex}")
    Response<Client> payButtonMobileService(@PathVariable("username") String usernameClient, @PathVariable("service") String serviceName, @RequestBody double amount, @PathVariable("wayIndex") int wayIndex) {
        Client client = ClientAPI.getClient(usernameClient);
        Response<Client> response = new Response<>();
        if(client == null){
            response.setStatus(false);
            response.setMessage("There is no such a client");
            return response;
        }
        Service service = ServiceAPI.getMobileService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        if(wayIndex > service.getWaysOfPayment().size() || wayIndex < 0){
            response.setStatus(false);
            response.setMessage("There is no such a way Index");
            return response;
        }
        wayIndex--;
        DiscountController discountController = DiscountController.getDiscountController();
        amount = discountController.applyDiscountMobileService(service, client, amount);
        PaymentController paymentController = PaymentController.getPaymentController();
        response.setStatus(true);
        response.setObject(client);
        response.setMessage(paymentController.payMobileService(client, service, amount, wayIndex));
        return response;
    }

    @PutMapping(value = "/{username}/pay/internet/{service}/{wayIndex}")
    Response<Client> payButtonInternetService(@PathVariable("username") String usernameClient, @PathVariable("service") String serviceName, @RequestBody double amount, @PathVariable("wayIndex") int wayIndex) {
        Client client = ClientAPI.getClient(usernameClient);
        Response<Client> response = new Response<>();
        if(client == null){
            response.setStatus(false);
            response.setMessage("There is no such a client");
            return response;
        }
        Service service = ServiceAPI.getInternetService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        if(wayIndex > service.getWaysOfPayment().size() || wayIndex < 0){
            response.setStatus(false);
            response.setMessage("There is no such a way Index");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        amount = discountController.applyDiscountInternetService(service, client, amount);
        PaymentController paymentController = PaymentController.getPaymentController();
        response.setStatus(true);
        response.setObject(client);
        response.setMessage(paymentController.payInternetService(client, service, amount, wayIndex));
        return response;
    }

    @PutMapping(value = "/{username}/pay/landline/{service}/{wayIndex}")
    Response<Client> payButtonLandlineService(@PathVariable("username") String usernameClient, @PathVariable("service") String serviceName, @RequestBody double amount, @PathVariable("wayIndex") int wayIndex) {
        Client client = ClientAPI.getClient(usernameClient);
        Response<Client> response = new Response<>();
        if(client == null){
            response.setStatus(false);
            response.setMessage("There is no such a client");
            return response;
        }
        Service service = ServiceAPI.getLandlineService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        if(wayIndex > service.getWaysOfPayment().size() || wayIndex < 1){
            response.setStatus(false);
            response.setMessage("There is no such a way Index");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        amount = discountController.applyDiscountLandlineService(client, amount);
        PaymentController paymentController = PaymentController.getPaymentController();
        response.setStatus(true);
        response.setObject(client);
        response.setMessage(paymentController.payLandlineService(client, service, amount, wayIndex));
        return response;
    }
    @PutMapping(value = "/{username}/pay/donation/{service}/{wayIndex}")
    Response<Client> payButtonDonationService(@PathVariable("username") String usernameClient, @PathVariable("service") String serviceName, @RequestBody double amount, @PathVariable("wayIndex") int wayIndex) {
        Client client = ClientAPI.getClient(usernameClient);
        Response<Client> response = new Response<>();
        if(client == null){
            response.setStatus(false);
            response.setMessage("There is no such a client");
            return response;
        }
        Service service = ServiceAPI.getDonationService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        if(wayIndex > service.getWaysOfPayment().size() || wayIndex < 0){
            response.setStatus(false);
            response.setMessage("There is no such a way Index");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        amount = discountController.applyDiscountDonationService(service, client, amount);
        PaymentController paymentController = PaymentController.getPaymentController();
        response.setStatus(true);
        response.setObject(client);
        response.setMessage(paymentController.payDonationService(client, service, amount, wayIndex));
        return response;
    }
    @GetMapping(value = "/{username}/transactions/payments")
    Response<ArrayList<PaymentTransaction>> listAllPayments(@PathVariable("username") String usernameClient){
        Account account = AdminAPI.getAdmin(usernameClient);
        Response<ArrayList<PaymentTransaction>> response = new Response<>();
        if(account == null){
            response.setMessage("There is no such an admin");
            response.setStatus(false);
        }
        response.setStatus(true);
        response.setObject(getAllPaymentTransactions());
        response.setMessage("Payment transactions: " + response.getObject().size());
        return response;
    }
}
