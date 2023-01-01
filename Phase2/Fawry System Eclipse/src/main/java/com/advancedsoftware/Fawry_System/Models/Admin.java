package com.advancedsoftware.Fawry_System.Models;

public class Admin extends Account{

    public Admin(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public void update(boolean acceptance, PaymentTransaction paymentTransaction) {

    }
}
