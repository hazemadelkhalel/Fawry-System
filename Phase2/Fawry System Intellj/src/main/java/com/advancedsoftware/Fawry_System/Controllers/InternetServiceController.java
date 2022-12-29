package com.advancedsoftware.Fawry_System.Controllers;
import java.util.ArrayList;

import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Services.*;
import com.advancedsoftware.Fawry_System.Models.*;




public class InternetServiceController{
    private static InternetServiceController internetServiceController;

    private InternetServiceController(){}
    public static InternetServiceController getInternetServiceController() {
        if (internetServiceController == null) {
            internetServiceController = new InternetServiceController();
        }
        return internetServiceController;
    }
    public String pay(Client client, Service service, double amount, int wayIndex){
        return service.payInternetService(client, amount, wayIndex);
    }
    public ArrayList<Service> searchInternetService(String context){
        return SearchController.getSearchController().searchInternetService(context);
    }
    public boolean checkDiscountInternetService(Service service){
        for(int i = 0; i < Database.getDatabase().InternetServices.size(); i++){
            if(service != null && Database.getDatabase().mobileServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiscountInternetServiceExistance(){
        if(Database.getDatabase().internetServiceDiscount != null){
            return true;
        }
        else{
            return false;
        }
    }
}
