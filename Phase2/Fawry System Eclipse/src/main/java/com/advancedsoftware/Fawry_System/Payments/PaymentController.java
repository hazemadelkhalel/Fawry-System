package com.advancedsoftware.Fawry_System.Payments;

import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Services.*;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Controllers.*;
public class PaymentController{
    private static PaymentController paymentController;

    private PaymentController(){}
    public static PaymentController getPaymentController() {
        if (paymentController == null) {
            paymentController = new PaymentController();
        }
        return paymentController;
    }
    public String payMobileService(Client client, Service service, double amount, int wayIndex) {
        String result = MobileServiceController.getMobileServiceController().pay(client, service, amount, wayIndex);
        PaymentTransaction paymentTransaction = new PaymentTransaction(client, service, amount, wayIndex);
        Database.getDatabase().paymentTransactions.get(client).add(paymentTransaction);
        return result;
    }
    public String payInternetService(Client client, Service service, double amount, int wayIndex) {
        String result = InternetServiceController.getInternetServiceController().pay(client, service, amount, wayIndex);
        PaymentTransaction paymentTransaction = new PaymentTransaction(client, service, amount, wayIndex);
        Database.getDatabase().paymentTransactions.get(client).add(paymentTransaction);
        return result;
    }
    public String payLandlineService(Client client, Service service, double amount, int wayIndex) {
        String result = LandlineServiceController.getLandlineServiceController().pay(client, service, amount, wayIndex);
        PaymentTransaction paymentTransaction = new PaymentTransaction(client, service, amount, wayIndex);
        Database.getDatabase().paymentTransactions.get(client).add(paymentTransaction);
        return result;
    }
    public String payDonationService(Client client, Service service, double amount, int wayIndex) {
        String result = DonationServiceController.getDonationServiceController().pay(client, service, amount, wayIndex);
        PaymentTransaction paymentTransaction = new PaymentTransaction(client, service, amount, wayIndex);
        Database.getDatabase().paymentTransactions.get(client).add(paymentTransaction);
        return result;
    }
}