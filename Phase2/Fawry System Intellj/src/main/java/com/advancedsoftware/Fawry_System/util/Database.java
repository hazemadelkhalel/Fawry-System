package com.advancedsoftware.Fawry_System.util;

import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Services.Service;
import com.advancedsoftware.Fawry_System.Refunds.*;
import com.advancedsoftware.Fawry_System.Discounts.*;
public class Database {
    private static Database database;
    public Account account;
    public ArrayList<Account> accounts;
    public ArrayList<Transaction> addWalletTransaction;
    public ArrayList<Transaction> payments;
    public ArrayList<Service> services;
    public ArrayList<Service> mobileServices;
    public ArrayList<Service> InternetServices;
    public ArrayList<Service> landlineServices;
    public ArrayList<Service> donationServices;
    public ArrayList<RefundRequest> refunds;

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
        addWalletTransaction = new ArrayList<>();
        refunds = new ArrayList<>();
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

    public static class Pair<F, S> {
        private F first;
        private S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return this.first;
        }

        public S getSecond() {
            return this.second;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public void setSecond(S second) {
            this.second = second;
        }
    }
}