package com.advancedsoftware.Fawry_System.Controllers;
import java.util.ArrayList;

import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Services.*;
public class SearchController{

    private static SearchController searchController;

    private SearchController(){}
    public static SearchController getSearchController() {
        if (searchController == null) {
            searchController = new SearchController();
        }
        return searchController;
    }
    boolean match(String first, String second){
        for(int i = 0; i < first.length(); i++){
            if(Character.toLowerCase(first.charAt(i)) != Character.toLowerCase(second.charAt(i))){
                return false;
            }
        }
        return true;
    }
    ArrayList<Service> searchMobileService(String context){
        ArrayList<Service> result = new ArrayList<>();
        for(int i = 0; i < Database.getDatabase().mobileServices.size(); i++){
            Service service = Database.getDatabase().mobileServices.get(i);
            if(match(context, service.getServiceName())){
                result.add(service);
            }
        }
        return result;
    }
    ArrayList<Service> searchInternetService(String context){
        ArrayList<Service> result = new ArrayList<>();
        for(int i = 0; i < Database.getDatabase().InternetServices.size(); i++){
            Service service = Database.getDatabase().InternetServices.get(i);
            if(match(context, service.getServiceName())){
                result.add(service);
            }
        }
        return result;
    }
    ArrayList<Service> searchLandlineService(String context){
        ArrayList<Service> result = new ArrayList<>();
        for(int i = 0; i < Database.getDatabase().landlineServices.size(); i++){
            Service service = Database.getDatabase().landlineServices.get(i);
            if(match(context, service.getServiceName())){
                result.add(service);
            }
        }
        return result;
    }
    ArrayList<Service> searchDonationService(String context){
        ArrayList<Service> result = new ArrayList<>();
        for(int i = 0; i < Database.getDatabase().donationServices.size(); i++){
            Service service = Database.getDatabase().donationServices.get(i);
            if(match(context, service.getServiceName())){
                result.add(service);
            }
        }
        return result;
    }
}
