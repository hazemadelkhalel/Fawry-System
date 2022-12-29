package com.advancedsoftware.Fawry_System.Controllers;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Services.*;
import com.advancedsoftware.Fawry_System.Models.*;


public class DonationServiceController{
    private static DonationServiceController donationServiceController;

    private DonationServiceController(){}
    public static DonationServiceController getDonationServiceController() {
        if (donationServiceController == null) {
            donationServiceController = new DonationServiceController();
        }
        return donationServiceController;
    }
    public String pay(Client client, Service service, double amount, int wayIndex){
        return service.payDonationService(client, amount, wayIndex);
    }
    public ArrayList<Service> searchDonationService(String context){
        return SearchController.getSearchController().searchDonationService(context);
    }
    public boolean checkDiscountDonationService(Service service){
        for(int i = 0; i < Database.getDatabase().donationServices.size(); i++){
            if(Database.getDatabase().donationServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    public boolean checkDiscountDonationServiceExistance(){
        if(Database.getDatabase().donationServiceDiscount != null){
            return true;
        }
        else{
            return false;
        }
    }
}
