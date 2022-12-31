package com.advancedsoftware.Fawry_System.util;

import com.advancedsoftware.Fawry_System.Discounts.OverallDiscount;
import com.advancedsoftware.Fawry_System.Discounts.SpecificDiscount;
import com.advancedsoftware.Fawry_System.Models.Admin;
import com.advancedsoftware.Fawry_System.Models.Client;
import com.advancedsoftware.Fawry_System.Payments.CashMethod;
import com.advancedsoftware.Fawry_System.Payments.CreditCardMethod;
import com.advancedsoftware.Fawry_System.Payments.WalletMethod;
import com.advancedsoftware.Fawry_System.Refunds.RefundRequestManager;
import com.advancedsoftware.Fawry_System.Services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Initializer {
    @PostConstruct
    private void init() {
        CreditCardMethod creditCardMethod = CreditCardMethod.getCreditCardMethod();
        WalletMethod walletMethod = WalletMethod.getWalletMethod();
        CashMethod cashMethod = CashMethod.getCashMethod();
        Vodafone vodafone = new Vodafone("Vodafone");
        We we = new We("We");
        Orange orange = new Orange("Orange");
        Etisalat etisalat = new Etisalat("Etisalat");
        MonthlyReceipt monthlyReceipt = new MonthlyReceipt("MonthlyReceipt");
        QuarterReceipt quarterReceipt = new QuarterReceipt("QuarterReceipt");
        CancerHospital cancerHospital = new CancerHospital("CancerHospital");
        School school = new School("School");
        NGO ngo = new NGO("NGO");
        vodafone.addPaymentMethod(creditCardMethod);
        we.addPaymentMethod(creditCardMethod);
        orange.addPaymentMethod(creditCardMethod);
        etisalat.addPaymentMethod(creditCardMethod);
        monthlyReceipt.addPaymentMethod(creditCardMethod);
        quarterReceipt.addPaymentMethod(creditCardMethod);
        cancerHospital.addPaymentMethod(creditCardMethod);
        school.addPaymentMethod(creditCardMethod);
        ngo.addPaymentMethod(creditCardMethod);

        vodafone.addPaymentMethod(walletMethod);
        we.addPaymentMethod(walletMethod);
        orange.addPaymentMethod(walletMethod);
        etisalat.addPaymentMethod(walletMethod);
        monthlyReceipt.addPaymentMethod(walletMethod);
        quarterReceipt.addPaymentMethod(walletMethod);
        cancerHospital.addPaymentMethod(walletMethod);
        school.addPaymentMethod(walletMethod);
        ngo.addPaymentMethod(walletMethod);

        vodafone.addPaymentMethod(cashMethod);
        cancerHospital.addPaymentMethod(cashMethod);
        school.addPaymentMethod(cashMethod);

        Database.getDatabase().services.add(vodafone);
        Database.getDatabase().mobileServices.add(vodafone);
        Database.getDatabase().InternetServices.add(vodafone);

        Database.getDatabase().services.add(we);
        Database.getDatabase().mobileServices.add(we);
        Database.getDatabase().InternetServices.add(we);
        Database.getDatabase().services.add(orange);
        Database.getDatabase().mobileServices.add(orange);
        Database.getDatabase().InternetServices.add(orange);

        Database.getDatabase().services.add(etisalat);
        Database.getDatabase().mobileServices.add(etisalat);
        Database.getDatabase().InternetServices.add(etisalat);

        Database.getDatabase().services.add(monthlyReceipt);
        Database.getDatabase().landlineServices.add(monthlyReceipt);

        Database.getDatabase().services.add(quarterReceipt);
        Database.getDatabase().landlineServices.add(quarterReceipt);
        Database.getDatabase().services.add(cancerHospital);
        Database.getDatabase().donationServices.add(cancerHospital);

        Database.getDatabase().services.add(school);
        Database.getDatabase().donationServices.add(school);

        Database.getDatabase().services.add(ngo);
        Database.getDatabase().donationServices.add(ngo);

        Database.getDatabase().mobileServiceDiscount = new SpecificDiscount(vodafone, 20);
        Database.getDatabase().overallDiscount = new OverallDiscount(new Vodafone("Overall"), 50);

        Admin admin = new Admin("admin", "Admin@gmail.com", "admin");
        Client client = new Client("client", "client@gmail.com", "client", 120);
        Database.getDatabase().accounts.add(admin);
        Database.getDatabase().accounts.add(client);
        Database.getDatabase().paymentTransactions.put(client, new ArrayList<>());
        Database.getDatabase().notifications.put(client, new ArrayList<>());
        Database.getDatabase().notifications.put(admin, new ArrayList<>());
        RefundRequestManager.getRefundRequestManager().subscribe(client);
        Database.getDatabase().addToWalletTransactions.put(client, new ArrayList<>());
    }
}
