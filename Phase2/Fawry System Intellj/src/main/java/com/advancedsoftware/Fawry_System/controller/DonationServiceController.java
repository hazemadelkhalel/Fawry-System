package com.advancedsoftware.Fawry_System.controller;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.service.*;
import com.advancedsoftware.Fawry_System.model.*;


public class DonationServiceController extends FawryController{
    public DonationServiceController(Database database){
        this.database = database;
    }
    public String pay(Client client, Service service, double amount, int wayIndex){
        return service.payDonationService(client, amount, wayIndex);
    }
    public ArrayList<Service> searchDonationService(String context){
        SearchController searchController = new SearchController(database);
        return searchController.searchDonationService(context);
    }
    public boolean checkDiscountDonationService(Service service){
        for(int i = 0; i < database.donationServices.size(); i++){
            if(database.donationServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiscountDonationServiceExistance(){
        if(database.donationServiceDiscount != null){
            return true;
        }
        else{
            return false;
        }
    }
}
