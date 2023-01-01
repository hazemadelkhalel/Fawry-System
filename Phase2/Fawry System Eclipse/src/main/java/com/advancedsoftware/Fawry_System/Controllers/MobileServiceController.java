package com.advancedsoftware.Fawry_System.Controllers;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Services.*;
import com.advancedsoftware.Fawry_System.Models.*;
public class MobileServiceController{
    private static MobileServiceController mobileServiceController;

    private MobileServiceController(){}
    public static MobileServiceController getMobileServiceController() {
        if (mobileServiceController == null) {
            mobileServiceController = new MobileServiceController();
        }
        return mobileServiceController;
    }
    public String pay(Client client, Service service, double amount, int wayIndex){
        return service.payMobileService(client, amount, wayIndex);
    }
    public ArrayList<Service> searchMobileService(String context){
        return SearchController.getSearchController().searchMobileService(context);
    }
    public double applyMobileDiscount(double amount){
        if(Database.getDatabase().mobileServiceDiscount == null){
            return amount;
        }
        else{
            return Database.getDatabase().mobileServiceDiscount.applyDiscount(amount);
        }
    }
    public boolean checkDiscountMobileServiceExistance(){
        if(Database.getDatabase().mobileServiceDiscount != null)return true;
        return false;
    }
}
