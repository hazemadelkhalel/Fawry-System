package com.advancedsoftware.Fawry_System.APIs;

import com.advancedsoftware.Fawry_System.Controllers.AccountController;
import com.advancedsoftware.Fawry_System.Controllers.AuthenticationController;
import com.advancedsoftware.Fawry_System.Discounts.Discount;
import com.advancedsoftware.Fawry_System.Discounts.DiscountController;
import com.advancedsoftware.Fawry_System.Discounts.OverallDiscount;
import com.advancedsoftware.Fawry_System.Discounts.SpecificDiscount;
import com.advancedsoftware.Fawry_System.Models.Account;
import com.advancedsoftware.Fawry_System.Models.Admin;
import com.advancedsoftware.Fawry_System.Models.Client;
import com.advancedsoftware.Fawry_System.Models.Response;
import com.advancedsoftware.Fawry_System.Services.Service;
import com.advancedsoftware.Fawry_System.Services.Vodafone;
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
        if(existAccount.equals("-1")){
            response.setMessage("This account already exists");
            response.setStatus(false);
        }
        else{
            response.setMessage(addAdminAccountButton(account));
            response.setStatus(true);
            response.setObject(account);
        }
        return response;
    }

    @PutMapping(value = "/{username}/addDiscount/mobile/{service}")
    Response<SpecificDiscount> addMobileServiceDiscount(@PathVariable("username") String usernameAdmin, @PathVariable("service") String serviceName, @RequestBody double percentage){
        Admin admin = getAdmin(usernameAdmin);
        Response<SpecificDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        Service service = ServiceAPI.getMobileService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        SpecificDiscount specificDiscount = new SpecificDiscount(service, percentage);
        specificDiscount.setWrappee(service);
        response.setStatus(true);
        response.setMessage(discountController.addMobileServiceDiscount(specificDiscount));
        response.setObject(specificDiscount);
        return response;
    }


    @PutMapping(value = "/{username}/addDiscount/internet/{service}")
    Response<SpecificDiscount> addInternetServiceDiscount(@PathVariable("username") String usernameAdmin, @PathVariable("service") String serviceName, @RequestBody double percentage){
        Admin admin = getAdmin(usernameAdmin);
        Response<SpecificDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        Service service = ServiceAPI.getMobileService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        SpecificDiscount specificDiscount = new SpecificDiscount(service, percentage);
        specificDiscount.setWrappee(service);
        response.setStatus(true);
        response.setMessage(discountController.addInternetServiceDiscount(specificDiscount));
        response.setObject(specificDiscount);
        return response;
    }

    @PutMapping(value = "/{username}/addDiscount/landline/{service}")
    Response<SpecificDiscount> addLandLineServiceDiscount(@PathVariable("username") String usernameAdmin, @PathVariable("service") String serviceName, @RequestBody double percentage){
        Admin admin = getAdmin(usernameAdmin);
        Response<SpecificDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        Service service = ServiceAPI.getMobileService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        SpecificDiscount specificDiscount = new SpecificDiscount(service, percentage);
        specificDiscount.setWrappee(service);
        response.setStatus(true);
        response.setMessage(discountController.addLandLineServiceDiscount(specificDiscount));
        response.setObject(specificDiscount);
        return response;
    }
    @PutMapping(value = "/{username}/addDiscount/donation/{service}")
    Response<SpecificDiscount> addDonationServiceDiscount(@PathVariable("username") String usernameAdmin, @PathVariable("service") String serviceName, @RequestBody double percentage){
        Admin admin = getAdmin(usernameAdmin);
        Response<SpecificDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        Service service = ServiceAPI.getMobileService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        SpecificDiscount specificDiscount = new SpecificDiscount(service, percentage);
        specificDiscount.setWrappee(service);
        response.setStatus(true);
        response.setMessage(discountController.addDonationServiceDiscount(specificDiscount));
        response.setObject(specificDiscount);
        return response;
    }

    @PutMapping(value = "/{username}/addDiscount/overall")
    Response<OverallDiscount> addOverallDiscount(@PathVariable("username") String usernameAdmin, @RequestBody double percentage){
        Admin admin = getAdmin(usernameAdmin);
        Response<OverallDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        OverallDiscount overallDiscount = new OverallDiscount(new Vodafone("Overall Discount"), percentage);
        response.setStatus(true);
        response.setMessage(discountController.addOverallDiscount(overallDiscount));
        response.setObject(overallDiscount);
        return response;
    }
}
