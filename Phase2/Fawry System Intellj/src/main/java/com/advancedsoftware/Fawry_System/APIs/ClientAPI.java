package com.advancedsoftware.Fawry_System.APIs;

import com.advancedsoftware.Fawry_System.Controllers.AccountController;
import com.advancedsoftware.Fawry_System.Controllers.AuthenticationController;
import com.advancedsoftware.Fawry_System.Models.Account;
import com.advancedsoftware.Fawry_System.Models.Client;
import com.advancedsoftware.Fawry_System.Models.CreditCard;
import com.advancedsoftware.Fawry_System.Models.Response;
import com.advancedsoftware.Fawry_System.Payments.PaymentController;
import com.advancedsoftware.Fawry_System.Services.Service;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientAPI {

    String addClientAccountButton(Client client) {
        AccountController accountController = AccountController.getAccountController();
        return accountController.addAccount(client);
    }
    @RequestMapping(value = "/signup/client")
    Response<Client> signUpButton(@RequestBody Client account) {
        AuthenticationController authenticationController = AuthenticationController.getAuthenticationController();
        String existAccount = authenticationController.validateSignUp(account);
        Response<Client> response = new Response<>();
        if(existAccount.equals("-1")){
            response.setMessage("This account already exists");
            response.setStatus(false);
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


}
