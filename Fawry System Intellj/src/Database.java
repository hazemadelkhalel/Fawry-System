
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    Account account;
    ArrayList<Account> accounts;
    ArrayList<Service> services;
    ArrayList<Service> mobileServices;
    ArrayList<Service> InternetServices;
    ArrayList<Service> landlineServices;
    ArrayList<Service> donationServices;

    ArrayList<Discount> discounts;

    ArrayList<CreditCard> creditCards;
    Database() {
        accounts = new ArrayList<>();
        services = new ArrayList<>();
        discounts = new ArrayList<>();
        creditCards = new ArrayList<>();
        mobileServices = new ArrayList<>();
        landlineServices = new ArrayList<>();
        InternetServices = new ArrayList<>();
        donationServices = new ArrayList<>();
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