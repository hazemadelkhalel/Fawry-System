package com.advancedsoftware.Fawry_System.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Services.Service;
import com.advancedsoftware.Fawry_System.Discounts.*;
public class Database {
    private static Database database;
    public Account account;
    public ArrayList<Account> accounts;
    public HashMap<Client, ArrayList<PaymentTransaction>> paymentTransactions;
    public HashMap<Client, ArrayList<AddToWalletTransaction>> addToWalletTransactions;
    public HashMap<Account, ArrayList<String>> notifications;

    public ArrayList<Service> services;
    public ArrayList<Service> mobileServices;
    public ArrayList<Service> InternetServices;
    public ArrayList<Service> landlineServices;
    public ArrayList<Service> donationServices;
    public ArrayList<RefundTransaction> refunds;

    public ArrayList<Discount> discounts;
    public SpecificDiscount mobileServiceDiscount;
    public SpecificDiscount internetServiceDiscount;
    public SpecificDiscount landlineServiceDiscount;
    public SpecificDiscount donationServiceDiscount;
    public OverallDiscount overallDiscount;

    public ArrayList<CreditCard> creditCards;
    private Database() {
        accounts = new ArrayList<>();
        services = new ArrayList<>();
        discounts = new ArrayList<>();
        creditCards = new ArrayList<>();
        mobileServices = new ArrayList<>();
        landlineServices = new ArrayList<>();
        InternetServices = new ArrayList<>();
        donationServices = new ArrayList<>();
        refunds = new ArrayList<>();
        addToWalletTransactions = new HashMap<>();
        paymentTransactions = new HashMap<>();
        notifications = new HashMap<>();
        mobileServiceDiscount = null;
        internetServiceDiscount = null;
        landlineServiceDiscount = null;
        donationServiceDiscount = null;
        overallDiscount = null;
    }
    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }
}