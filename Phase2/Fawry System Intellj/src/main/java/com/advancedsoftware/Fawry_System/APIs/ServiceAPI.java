package com.advancedsoftware.Fawry_System.APIs;

import com.advancedsoftware.Fawry_System.Models.Account;
import com.advancedsoftware.Fawry_System.Models.Response;
import com.advancedsoftware.Fawry_System.Services.Service;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAPI {
    public static Service getMobileService(String serviceName){
        for(int i = 0; i < Database.getDatabase().mobileServices.size(); i++){
            if(Database.getDatabase().mobileServices.get(i).getServiceName().toLowerCase().equals(serviceName.toLowerCase())){
                return Database.getDatabase().mobileServices.get(i);
            }
        }
        return null;
    }
    public static Service getInternetService(String serviceName){
        for(int i = 0; i < Database.getDatabase().InternetServices.size(); i++){
            if(Database.getDatabase().InternetServices.get(i).getServiceName().toLowerCase().equals(serviceName.toLowerCase())){
                return Database.getDatabase().InternetServices.get(i);
            }
        }
        return null;
    }
    public static Service getLandlineService(String serviceName){
        for(int i = 0; i < Database.getDatabase().landlineServices.size(); i++){
            if(Database.getDatabase().landlineServices.get(i).getServiceName().toLowerCase().equals(serviceName.toLowerCase())){
                return Database.getDatabase().landlineServices.get(i);
            }
        }
        return null;
    }
    public static Service getDonationService(String serviceName){
        for(int i = 0; i < Database.getDatabase().donationServices.size(); i++){
            if(Database.getDatabase().donationServices.get(i).getServiceName().toLowerCase().equals(serviceName.toLowerCase())){
                return Database.getDatabase().donationServices.get(i);
            }
        }
        return null;
    }

}
