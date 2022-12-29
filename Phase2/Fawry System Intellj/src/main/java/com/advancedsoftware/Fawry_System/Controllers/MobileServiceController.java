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
    public boolean checkDiscountMobileService(Service service){
        for(int i = 0; i < Database.getDatabase().mobileServices.size(); i++){
            if(service != null &&Database.getDatabase().mobileServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiscountMobileServiceExistance(){
        if(Database.getDatabase().mobileServiceDiscount != null)return true;
        return false;
    }
}
