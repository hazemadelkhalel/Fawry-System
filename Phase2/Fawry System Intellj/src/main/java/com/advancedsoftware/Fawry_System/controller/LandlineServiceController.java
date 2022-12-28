package com.advancedsoftware.Fawry_System.controller;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.service.*;
import com.advancedsoftware.Fawry_System.model.*;
public class LandlineServiceController extends FawryController{
    public LandlineServiceController(Database database){
        this.database = database;
    }
    public String pay(Client client, Service service, double amount, int wayIndex){
        return service.payLandlineService(client, amount, wayIndex);
    }
    public ArrayList<Service> searchLandlineService(String context){
        SearchController searchController = new SearchController(database);
        return searchController.searchLandlineService(context);
    }
    public boolean checkDiscountLandlineService(Service service){
        for(int i = 0; i < database.landlineServices.size(); i++){
            if(service != null && database.landlineServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiscountLandlineServiceExistance(){
        if(database.landlineServiceDiscount != null){
            return true;
        }
        else{
            return false;
        }
    }
}
