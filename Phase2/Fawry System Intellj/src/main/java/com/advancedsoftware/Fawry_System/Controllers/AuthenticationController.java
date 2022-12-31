package com.advancedsoftware.Fawry_System.Controllers;
import com.advancedsoftware.Fawry_System.APIs.FawryScreenAPI;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.util.*;

public class AuthenticationController {
    private static AuthenticationController authenticationController;

    private AuthenticationController(){}
    public static AuthenticationController getAuthenticationController() {
        if (authenticationController == null) {
            authenticationController = new AuthenticationController();
        }
        return authenticationController;
    }
    public String validateLogin(Account account) {
        AccountController accountController = AccountController.getAccountController();
        for(int i = 0; i < Database.getDatabase().accounts.size(); i++){
            String response = accountController.checkAccountLogin(Database.getDatabase().accounts.get(i), account);
            Account tempAccount = FawryScreenAPI.getAccount(Database.getDatabase().accounts.get(i).getUsername());
            boolean ok1 = (account instanceof Client && tempAccount instanceof Client);
            boolean ok2 = (account instanceof Admin && tempAccount instanceof Admin);
            if(!response.equals("There is no such an account") && (ok1 || ok2)){
                return response;
            }
        }
        // "There is no such an account" represent there is no user with this information in system
        return "There is no such an account";
    }
    public String validateSignUp(Account account) {
        if(account.getUsername() == null || account.getPassword() == null || account.getEmail() == null){
            return "Invalid information";
        }
        AccountController accountController = AccountController.getAccountController();
        for(int i = 0; i < Database.getDatabase().accounts.size(); i++){
            if(accountController.checkAccountSignUp(Database.getDatabase().accounts.get(i), account)){
                return "This account already exists";
            }
        }
        Database.getDatabase().accounts.add(account);
        // -1 represent there is no user with this information in system
        return "OK";
    }
}
