package com.advancedsoftware.Fawry_System.controller;
import java.util.Map;
import com.advancedsoftware.Fawry_System.model.*;
import com.advancedsoftware.Fawry_System.util.*;

public class Authentication extends FawryController{
    public Authentication(Database database){
        this.database = database;
    }

    public Account validateLogin(String usernameOrEmail, String password) {
        AccountController accountController = new AccountController(database);
        for(int i = 0; i < database.accounts.size(); i++){
            if(accountController.checkAccountLogin(database.accounts.get(i), usernameOrEmail, password)){
                return database.accounts.get(i);
            }
        }
        // -1 represent there is no user with this information in system
        return null;
    }
    public String validateSignUp(Account account) {
        AccountController accountController = new AccountController(database);
        for(int i = 0; i < database.accounts.size(); i++){
            if(accountController.checkAccountSignUp(database.accounts.get(i), account)){
                return "-1";
            }
        }
        database.accounts.add(account);
        // -1 represent there is no user with this information in system
        return "OK";
    }
}
