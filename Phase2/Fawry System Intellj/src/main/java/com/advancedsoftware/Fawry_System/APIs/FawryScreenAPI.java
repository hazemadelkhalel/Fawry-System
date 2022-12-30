package com.advancedsoftware.Fawry_System.APIs;
import com.advancedsoftware.Fawry_System.Controllers.*;
import com.advancedsoftware.Fawry_System.Discounts.*;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Refunds.*;
import com.advancedsoftware.Fawry_System.Services.*;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FawryScreenAPI {
    public static Account getAccount(String usernameOrEmail){
        Account account = null;
        for(int i = 0; i < Database.getDatabase().accounts.size(); i++){
            if(usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getUsername()) || usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getEmail())){
                account = Database.getDatabase().accounts.get(i);
                break;
            }

        }
        return account;
    }
    @RequestMapping("/login")
    Response<Account> loginButton(@RequestBody Account account) {
        Response<Account> response = new Response<>();
        String existAccountMessage = AuthenticationController.getAuthenticationController().validateLogin(account);
        response.setMessage(existAccountMessage);
        if(existAccountMessage.equals("There is no such an account")){
            response.setStatus(false);
        }
        else{
            if(existAccountMessage.equals("Login Successfully")){
                response.setStatus(true);
                response.setObject(getAccount(account.getUsername()));
            }
        }
        return response;
    }
    @GetMapping(value = "/profile/{username}")
    Response<Account> displayProfile(@PathVariable("username") String usernameClient) {
        Account account = getAccount(usernameClient);
        Response<Account> response = new Response<>();
        if(account == null){
            response.setStatus(false);
            response.setMessage("There is no such an account");
            return response;
        }
        else{
            response.setStatus(true);
            response.setMessage("Found account");
            response.setObject(account);
        }
        return response;
    }

    @GetMapping(value = "/{username}/notifications")
    Response<ArrayList<String>> showNotifications(@PathVariable("username") String usernameClient){
        Account account = getAccount(usernameClient);
        Response<ArrayList<String>> response = new Response<>();
        if(account == null){
            response.setMessage("There is no such a client");
            response.setStatus(false);
        }
        else{
            response.setStatus(true);
            response.setMessage("Exist Account");
            response.setObject(Database.getDatabase().notifications.get(account));
        }
        return response;
    }





}

