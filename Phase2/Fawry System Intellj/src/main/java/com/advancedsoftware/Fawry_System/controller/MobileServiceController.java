package com.advancedsoftware.Fawry_System.controller;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.service.*;
import com.advancedsoftware.Fawry_System.model.*;
public class MobileServiceController extends FawryController{
    public MobileServiceController(Database database){
        this.database = database;
    }
    public String pay(Client client, Service service, double amount, int wayIndex){
        return service.payMobileService(client, amount, wayIndex);
    }
    public ArrayList<Service> searchMobileService(String context){
        SearchController searchController = new SearchController(database);
        return searchController.searchMobileService(context);
    }
    public boolean checkDiscountMobileService(Service service){
        for(int i = 0; i < database.mobileServices.size(); i++){
            if(service != null &&database.mobileServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiscountMobileServiceExistance(){
        if(database.mobileServiceDiscount != null)return true;
        return false;
    }
}
