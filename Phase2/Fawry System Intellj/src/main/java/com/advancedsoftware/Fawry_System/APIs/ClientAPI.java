package com.advancedsoftware.Fawry_System.APIs;

import com.advancedsoftware.Fawry_System.Controllers.AccountController;
import com.advancedsoftware.Fawry_System.Controllers.AuthenticationController;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class ClientAPI {
    ArrayList<AddToWalletTransaction> getAllAddToAllTransactions(){
        ArrayList<AddToWalletTransaction> addToWalletTransactions = new ArrayList<>();
        for(Map.Entry<Client, ArrayList<AddToWalletTransaction>> entry: Database.getDatabase().addToWalletTransactions.entrySet()){
            ArrayList<AddToWalletTransaction> temp = entry.getValue();
            addToWalletTransactions.addAll(temp);
        }
        return addToWalletTransactions;
    }
    String addClientAccountButton(Client client) {
        AccountController accountController = AccountController.getAccountController();
        return accountController.addAccount(client);
    }
    @RequestMapping(value = "/signup/client")
    Response<Client> signUpButton(@RequestBody Client account) {
        AuthenticationController authenticationController = AuthenticationController.getAuthenticationController();
        String existAccount = authenticationController.validateSignUp(account);
        Response<Client> response = new Response<>();
        if(!existAccount.equals("OK")){
            response.setStatus(false);
            response.setMessage(existAccount);
        }
        else{
            response.setMessage(addClientAccountButton(account));
            response.setStatus(true);
            response.setObject(account);
        }
        return response;
    }

    public static Client getClient(String usernameOrEmail){
        Client client = null;
        for(int i = 0; i < Database.getDatabase().accounts.size(); i++){
            if(Database.getDatabase().accounts.get(i) instanceof Client){
                if(usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getUsername()) || usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getEmail())){
                    client = (Client) Database.getDatabase().accounts.get(i);
                    break;
                }
            }
        }
        return client;
    }
    @PutMapping(value = "/{username}/addfunds")
    Response<Client> addFunds(@PathVariable("username") String usernameClient, @RequestBody double amount){
        Client client = getClient(usernameClient);
        Response<Client> response = new Response<>();
        if(client == null){
            response.setMessage("There is no such a client");
            response.setStatus(false);
        }
        else{
            response.setStatus(true);
            response.setObject(client);
            AccountController accountController = AccountController.getAccountController();
            response.setMessage(accountController.addFunds(client, amount));
        }
        return response;
    }


    @PutMapping(value = "/{username}/addCreditCard")
    Response<Client> addCreditCard(@PathVariable("username") String usernameClient, @RequestBody CreditCard creditCard){
        Client client = getClient(usernameClient);
        Response<Client> response = new Response<>();
        if(client == null){
            response.setMessage("There is no such a client");
            response.setStatus(false);
        }
        else{
            response.setStatus(true);
            response.setObject(client);
            AccountController accountController = AccountController.getAccountController();
            response.setMessage(accountController.addCreditCard(client, creditCard));
        }
        return response;
    }


    @GetMapping(value = "/client/check")
    Response<Client> checkClient(@RequestBody Client client) {
        Response<Client> response = new Response<>();
        String existAccountMessage = AuthenticationController.getAuthenticationController().validateLogin(client);
        response.setMessage(existAccountMessage);
        if(existAccountMessage.equals("There is no such an account")){
            response.setStatus(false);
        }
        else{
            if(existAccountMessage.equals("Login Successfully")){
                response.setMessage("Found a clinet");
                response.setStatus(true);
                if(client.getUsername() == null){
                    response.setObject(getClient(client.getEmail()));
                }
                else{
                    response.setObject(getClient(client.getUsername()));
                }
            }
        }
        return response;
    }

    @GetMapping(value = "/{username}/transactions/addToWallet")
    Response<ArrayList<AddToWalletTransaction>> listAllPayments(@PathVariable("username") String usernameClient){
        Account account = AdminAPI.getAdmin(usernameClient);
        Response<ArrayList<AddToWalletTransaction>> response = new Response<>();
        if(account == null){
            response.setMessage("There is no such an admin");
            response.setStatus(false);
        }
        response.setStatus(true);
        response.setObject(getAllAddToAllTransactions());
        response.setMessage("Add To Wallet transactions: " + response.getObject().size());
        return response;
    }



}
