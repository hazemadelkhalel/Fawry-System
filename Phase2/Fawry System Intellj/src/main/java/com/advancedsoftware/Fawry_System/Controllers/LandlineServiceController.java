package com.advancedsoftware.Fawry_System.Controllers;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Services.*;
import com.advancedsoftware.Fawry_System.Models.*;
public class LandlineServiceController{
    private static LandlineServiceController landlineServiceController;

    private LandlineServiceController(){}
    public static LandlineServiceController getLandlineServiceController() {
        if (landlineServiceController == null) {
            landlineServiceController = new LandlineServiceController();
        }
        return landlineServiceController;
    }
    public String pay(Client client, Service service, double amount, int wayIndex){
        return service.payLandlineService(client, amount, wayIndex);
    }
    public ArrayList<Service> searchLandlineService(String context){
        return SearchController.getSearchController().searchLandlineService(context);
    }
    public boolean checkDiscountLandlineService(Service service){
        for(int i = 0; i < Database.getDatabase().landlineServices.size(); i++){
            if(service != null && Database.getDatabase().landlineServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiscountLandlineServiceExistance(){
        if(Database.getDatabase().landlineServiceDiscount != null){
            return true;
        }
        else{
            return false;
        }
    }
}
