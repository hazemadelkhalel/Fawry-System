package com.advancedsoftware.Fawry_System.controller;
import java.util.ArrayList;

import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.service.*;
import com.advancedsoftware.Fawry_System.model.*;




public class InternetServiceController extends FawryController{
    public InternetServiceController(Database database){
        this.database = database;
    }
    public String pay(Client client, Service service, double amount, int wayIndex){
        return service.payInternetService(client, amount, wayIndex);
    }
    public ArrayList<Service> searchInternetService(String context){
        SearchController searchController = new SearchController(database);
        return searchController.searchInternetService(context);
    }
    public boolean checkDiscountInternetService(Service service){
        for(int i = 0; i < database.InternetServices.size(); i++){
            if(service != null && database.mobileServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiscountInternetServiceExistance(){
        if(database.internetServiceDiscount != null){
            return true;
        }
        else{
            return false;
        }
    }
}
