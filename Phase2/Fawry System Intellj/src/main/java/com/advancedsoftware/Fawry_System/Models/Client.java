package com.advancedsoftware.Fawry_System.Models;
import com.advancedsoftware.Fawry_System.util.Database;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Client extends Account{
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    public CreditCard creditCard;
    double wallet = 0;

    public Client(String username, String email, String password, double wallet){
        this.username = username;
        this.email = email;
        this.password = password;
        this.creditCard = null;
        this.wallet = wallet;
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
                ", username='" + username +
                ", email='" + email +
                ", password='" + password +
                ", AccountID=" + AccountID +
                '}';
    }

    public void update(boolean acceptance, PaymentTransaction paymentTransaction){
        if(acceptance){
            paymentTransaction.getClient().setWallet(paymentTransaction.getClient().getWallet() + paymentTransaction.getAmount());
        }
    }
}
