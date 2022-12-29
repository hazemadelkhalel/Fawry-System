package com.advancedsoftware.Fawry_System.APIs;

import com.advancedsoftware.Fawry_System.Controllers.AccountController;
import com.advancedsoftware.Fawry_System.Controllers.AuthenticationController;
import com.advancedsoftware.Fawry_System.Discounts.DiscountController;
import com.advancedsoftware.Fawry_System.Discounts.OverallDiscount;
import com.advancedsoftware.Fawry_System.Discounts.SpecificDiscount;
import com.advancedsoftware.Fawry_System.Models.Account;
import com.advancedsoftware.Fawry_System.Models.Admin;
import com.advancedsoftware.Fawry_System.Models.Client;
import com.advancedsoftware.Fawry_System.Models.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public class AdminAPI {
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

    String addMobileServiceDiscount(SpecificDiscount specificDiscount){
        DiscountController discountController = DiscountController.getDiscountController();
        return discountController.addMobileServiceDiscount(specificDiscount);
    }

    String addInternetServiceDiscount(SpecificDiscount specificDiscount){
        DiscountController discountController = DiscountController.getDiscountController();
        return discountController.addInternetServiceDiscount(specificDiscount);
    }
    String addDonationServiceDiscount(SpecificDiscount specificDiscount){
        DiscountController discountController = DiscountController.getDiscountController();
        return discountController.addDonationServiceDiscount(specificDiscount);
    }
    String addLandLineServiceDiscount(SpecificDiscount specificDiscount){
        DiscountController discountController = DiscountController.getDiscountController();
        return discountController.addLandLineServiceDiscount(specificDiscount);
    }
    String addOverallDiscount(OverallDiscount overallDiscount) {
        DiscountController discountController = DiscountController.getDiscountController();
        return discountController.addOverallDiscount(overallDiscount);
    }

}
