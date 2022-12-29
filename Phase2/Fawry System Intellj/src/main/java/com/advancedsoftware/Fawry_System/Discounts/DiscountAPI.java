package com.advancedsoftware.Fawry_System.Discounts;

import com.advancedsoftware.Fawry_System.APIs.ClientAPI;
import com.advancedsoftware.Fawry_System.APIs.ServiceAPI;
import com.advancedsoftware.Fawry_System.Models.Client;
import com.advancedsoftware.Fawry_System.Models.Response;
import com.advancedsoftware.Fawry_System.Services.Service;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DiscountAPI {
    ArrayList<Discount> getMobileDiscounts(Client client){
        ArrayList<Discount> result = new ArrayList<>();
        if(client.getTransactions().isEmpty() && Database.getDatabase().overallDiscount != null){
            result.add(Database.getDatabase().overallDiscount);
        }
        if(Database.getDatabase().mobileServiceDiscount != null){
            result.add(Database.getDatabase().mobileServiceDiscount);
        }
        return result;
    }
    ArrayList<Discount> getInternetDiscounts(Client client){
        ArrayList<Discount> result = new ArrayList<>();
        if(client.getTransactions().isEmpty() && Database.getDatabase().overallDiscount != null){
            result.add(Database.getDatabase().overallDiscount);
        }
        if(Database.getDatabase().internetServiceDiscount != null){
            result.add(Database.getDatabase().internetServiceDiscount);
        }
        return result;
    }
    ArrayList<Discount> getLandlineDiscounts(Client client){
        ArrayList<Discount> result = new ArrayList<>();
        if(client.getTransactions().isEmpty() && Database.getDatabase().overallDiscount != null){
            result.add(Database.getDatabase().overallDiscount);
        }
        if(Database.getDatabase().landlineServiceDiscount != null){
            result.add(Database.getDatabase().landlineServiceDiscount);
        }
        return result;
    }
    ArrayList<Discount> getDonationDiscounts(Client client){
        ArrayList<Discount> result = new ArrayList<>();
        if(client.getTransactions().isEmpty() && Database.getDatabase().overallDiscount != null){
            result.add(Database.getDatabase().overallDiscount);
        }
        if(Database.getDatabase().donationServiceDiscount != null){
            result.add(Database.getDatabase().donationServiceDiscount);
        }
        return result;
    }

    @GetMapping(value = "/{username}/mobile/{service}/discounts")
    Response<ArrayList<Discount>> checkDiscountMobileServiceButton(@PathVariable("username") String usernameClient, @PathVariable("service") String serviceName){
        Client client = ClientAPI.getClient(usernameClient);
        Response<ArrayList<Discount>> response = new Response<>();
        if(client == null){
            response.setStatus(false);
            response.setMessage("There is no such a client");
            return response;
        }
        Service service = ServiceAPI.getMobileService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        ArrayList<Discount> discounts = getMobileDiscounts(client);
        if(discounts == null){
            response.setStatus(false);
            response.setMessage("There is no any discount");
            return response;
        }
        response.setStatus(true);
        response.setMessage("Exist " + discounts.size() + " discounts");
        response.setObject(discounts);
        return response;
    }
    @GetMapping(value = "/{username}/internet/{service}/discounts")
    Response<ArrayList<Discount>> checkDiscountInternetServiceButton(@PathVariable("username") String usernameClient, @PathVariable("service") String serviceName){
        Client client = ClientAPI.getClient(usernameClient);
        Response<ArrayList<Discount>> response = new Response<>();
        if(client == null){
            response.setStatus(false);
            response.setMessage("There is no such a client");
            return response;
        }
        Service service = ServiceAPI.getInternetService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        ArrayList<Discount> discounts = getInternetDiscounts(client);
        if(discounts == null){
            response.setStatus(false);
            response.setMessage("There is no any discount");
            return response;
        }
        response.setStatus(true);
        response.setMessage("Exist " + discounts.size() + " discounts");
        response.setObject(discounts);
        return response;
    }

    @GetMapping(value = "/{username}/landline/{service}/discounts")
    Response<ArrayList<Discount>> checkDiscountLandlineServiceButton(@PathVariable("username") String usernameClient, @PathVariable("service") String serviceName){
        Client client = ClientAPI.getClient(usernameClient);
        Response<ArrayList<Discount>> response = new Response<>();
        if(client == null){
            response.setStatus(false);
            response.setMessage("There is no such a client");
            return response;
        }
        Service service = ServiceAPI.getLandlineService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        ArrayList<Discount> discounts = getLandlineDiscounts(client);
        if(discounts == null){
            response.setStatus(false);
            response.setMessage("There is no any discount");
            return response;
        }
        response.setStatus(true);
        response.setMessage("Exist " + discounts.size() + " discounts");
        response.setObject(discounts);
        return response;
    }

    @GetMapping(value = "/{username}/donation/{service}/discounts")
    Response<ArrayList<Discount>> checkDiscountDonationServiceButton(@PathVariable("username") String usernameClient, @PathVariable("service") String serviceName){
        Client client = ClientAPI.getClient(usernameClient);
        Response<ArrayList<Discount>> response = new Response<>();
        if(client == null){
            response.setStatus(false);
            response.setMessage("There is no such a client");
            return response;
        }
        Service service = ServiceAPI.getDonationService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        ArrayList<Discount> discounts = getDonationDiscounts(client);
        if(discounts == null){
            response.setStatus(false);
            response.setMessage("There is no any discount");
            return response;
        }
        response.setStatus(true);
        response.setMessage("Exist " + discounts.size() + " discounts");
        response.setObject(discounts);
        return response;
    }
}
