package com.advancedsoftware.Fawry_System.Controllers;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Payments.*;
import com.advancedsoftware.Fawry_System.util.*;

import java.util.ArrayList;


public class AccountController{
    private static AccountController accountController;

    private AccountController(){}
    public static AccountController getAccountController() {
        if (accountController == null) {
            accountController = new AccountController();
        }
        return accountController;
    }
    public String addAccount(Admin admin){
        admin.setAccountID(Database.getDatabase().accounts.size());
        Database.getDatabase().accounts.add(admin);
        return "Account added successfully";
    }
    public String addAccount(Client client) {
        client.setAccountID(Database.getDatabase().accounts.size());
        Database.getDatabase().accounts.add(client);
        Database.getDatabase().paymentTransactions.put(client, new ArrayList<>());
        Database.getDatabase().addToWalletTransactions.put(client, new ArrayList<>());
        Database.getDatabase().notifications.put(client, new ArrayList<>());
        return "Account added successfully";
    }
    public String addCreditCard(Client client, CreditCard creditCard){
        client.setCreditCard(creditCard);
        CreditCardController creditCardController = CreditCardController.getCreditCardController();
        int indexCreditCard = creditCardController.checkExistenceCreditCard(creditCard);
        if(indexCreditCard == -2){
            return "Please Enter a valid Credit Card";
        }
        else if(indexCreditCard == -1){
            Database.getDatabase().creditCards.add(creditCard);
        }
        else{
            Database.getDatabase().creditCards.set(indexCreditCard, creditCard);
        }
        return "Credit Card added successfully";
    }
    String checkAccountLogin(Account account, Account account2){
        if((account2.getUsername() != null && account.getUsername().equals(account2.getUsername())) ||
                (account2.getEmail() != null && account.getEmail().equals(account2.getEmail()))){
            if(account2.getPassword() != null && account.getPassword().equals(account2.getPassword())){
                return "Login Successfully";
            }
            else{
                return "The password is not correct";
            }
        }
        else{
            return "There is no such an account";
        }
    }
    boolean checkAccountSignUp(Account account1, Account account2){
        if(account1.getUsername().equals(account2.getUsername()) ||
                account1.getEmail().equals(account2.getEmail())) {
            return true;
        }
        else{
            return false;
        }
    }
    public String addFunds(Client client, double amount){
        CreditCardMethod creditCardMethod = CreditCardMethod.getCreditCardMethod();
        return creditCardMethod.addFunds(client, amount);
    }
}
