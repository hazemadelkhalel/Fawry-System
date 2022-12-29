package com.advancedsoftware.Fawry_System.Models;
import java.util.ArrayList;

public class Admin extends Account{

    public Admin(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        notifications = new ArrayList<>();
    }

    @Override
    public void update(boolean acceptance, Transaction transaction, boolean notify) {

    }
}
