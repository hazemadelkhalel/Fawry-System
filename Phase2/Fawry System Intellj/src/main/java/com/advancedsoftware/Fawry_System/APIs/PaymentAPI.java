package com.advancedsoftware.Fawry_System.APIs;

import com.advancedsoftware.Fawry_System.Discounts.DiscountController;
import com.advancedsoftware.Fawry_System.Models.Client;
import com.advancedsoftware.Fawry_System.Models.Response;
import com.advancedsoftware.Fawry_System.Payments.PaymentController;
import com.advancedsoftware.Fawry_System.Services.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentAPI {
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
        if(wayIndex > service.getWaysOfPayment().size() || wayIndex < 0){
            response.setStatus(false);
            response.setMessage("There is no such a way Index");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        amount = discountController.applyDiscountLandlineService(service, client, amount);
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
}
