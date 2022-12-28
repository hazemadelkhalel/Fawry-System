package com.advancedsoftware.Fawry_System.payment;

import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.service.*;
import com.advancedsoftware.Fawry_System.model.*;
import com.advancedsoftware.Fawry_System.controller.*;
public class PaymentController extends FawryController{
    public PaymentController(Database database){
        this.database = database;
    }
    public String payMobileService(Client client, Service service, double amount, int wayIndex) {
        MobileServiceController mobileServiceController = new MobileServiceController(database);
        String result = mobileServiceController.pay(client, service, amount, wayIndex);
        Transaction transaction = new Transaction(client, service, amount, wayIndex);
        database.payments.add(transaction);
        client.transactions.add(transaction);
        return result;
    }
    public String payInternetService(Client client, Service service, double amount, int wayIndex) {
        InternetServiceController internetServiceController = new InternetServiceController(database);
        String result = internetServiceController.pay(client, service, amount, wayIndex);
        Transaction transaction = new Transaction(client, service, amount, wayIndex);
        database.payments.add(transaction);
        client.transactions.add(transaction);
        return result;
    }
    public String payLandlineService(Client client, Service service, double amount, int wayIndex) {
        LandlineServiceController landlineServiceController = new LandlineServiceController(database);
        String result = landlineServiceController.pay(client, service, amount, wayIndex);
        Transaction transaction = new Transaction(client, service, amount, wayIndex);
        database.payments.add(transaction);
        client.transactions.add(transaction);
        return result;
    }
    public String payDonationService(Client client, Service service, double amount, int wayIndex) {
        DonationServiceController donationServiceController = new DonationServiceController(database);
        String result = donationServiceController.pay(client, service, amount, wayIndex);
        Transaction transaction = new Transaction(client, service, amount, wayIndex);
        database.payments.add(transaction);
        client.transactions.add(transaction);
        return result;
    }
}