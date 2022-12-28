package com.advancedsoftware.Fawry_System.model;
import javax.management.Notification;
import java.util.ArrayList;

public class Client extends Account{
    public CreditCard creditCard;
    double wallet = 0;
    public ArrayList<Transaction> transactions;
    public Client(String username, String email, String password, double wallet){
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = null;
        this.wallet = wallet;
        transactions = new ArrayList<>();
        notifications = new ArrayList<>();
    }
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public double getWallet() {
        return wallet;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Client{" +
                "creditCard=" + creditCard +
                ", wallet=" + wallet +
                ", transactions=" + transactions +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", notifications=" + notifications +
                ", AccountID=" + AccountID +
                '}';
    }

    public void update(boolean acceptance, Transaction transaction, boolean notify){
        transactions.remove(transaction);
        if(acceptance){
            transaction.getClient().setWallet(transaction.getClient().getWallet() + transaction.getAmount());
            if(notify) {
                notifications.add("Accepted Refund Request of " + transaction.getService().getServiceName());
            }
        }
        else{
            if(notify) {
                notifications.add("Refused Refund Request");
            }
        }
    }
}
