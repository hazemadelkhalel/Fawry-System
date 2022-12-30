package com.advancedsoftware.Fawry_System.Models;
import com.advancedsoftware.Fawry_System.util.Database;

import java.util.ArrayList;

public class Client extends Account{
    public CreditCard creditCard;
    double wallet = 0;

    public Client(String username, String email, String password, double wallet){
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = null;
        this.wallet = wallet;
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
    @Override
    public String toString() {
        return "Client{" +
                "creditCard=" + creditCard +
                ", wallet=" + wallet +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", notifications=" + notifications +
                ", AccountID=" + AccountID +
                '}';
    }

    public void update(boolean acceptance, PaymentTransaction paymentTransaction, boolean notify){
        if(acceptance){
            paymentTransaction.getClient().setWallet(paymentTransaction.getClient().getWallet() + paymentTransaction.getAmount());
//            notify = true;
            notifications.add("Accepted Refund Request of " + paymentTransaction.getService().getServiceName());
            if(notify) {
            }
        }
        else{
            if(notify) {
                notifications.add("Refused Refund Request");
            }
        }
    }
}
