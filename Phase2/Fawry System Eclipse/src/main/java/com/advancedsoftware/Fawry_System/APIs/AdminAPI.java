package com.advancedsoftware.Fawry_System.APIs;

import com.advancedsoftware.Fawry_System.Controllers.AccountController;
import com.advancedsoftware.Fawry_System.Controllers.AuthenticationController;
import com.advancedsoftware.Fawry_System.Models.Admin;
import com.advancedsoftware.Fawry_System.Models.Response;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminAPI {
    public static Admin getAdmin(String usernameOrEmail){
        Admin admin = null;
        for(int i = 0; i < Database.getDatabase().accounts.size(); i++){
            if(Database.getDatabase().accounts.get(i) instanceof Admin){
                if(usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getUsername()) || usernameOrEmail.equals(Database.getDatabase().accounts.get(i).getEmail())){
                    admin = (Admin) Database.getDatabase().accounts.get(i);
                    break;
                }
            }
        }
        return admin;
    }
    String addAdminAccountButton(Admin admin) {
        AccountController accountController = AccountController.getAccountController();
        return accountController.addAccount(admin);
    }
    @RequestMapping(value = "/signup/admin")
    Response<Admin> signUpButton(@RequestBody Admin account) {
        AuthenticationController authenticationController = AuthenticationController.getAuthenticationController();
        String existAccount = authenticationController.validateSignUp(account);
        Response<Admin> response = new Response<>();
        if(!existAccount.equals("OK")){
            response.setStatus(false);
            response.setMessage(existAccount);
        }
        else{
            response.setMessage(addAdminAccountButton(account));
            response.setStatus(true);
            response.setObject(account);
        }
        return response;
    }
}
