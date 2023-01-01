package com.advancedsoftware.Fawry_System.APIs;

import com.advancedsoftware.Fawry_System.Controllers.DonationServiceController;
import com.advancedsoftware.Fawry_System.Controllers.InternetServiceController;
import com.advancedsoftware.Fawry_System.Controllers.LandlineServiceController;
import com.advancedsoftware.Fawry_System.Controllers.MobileServiceController;
import com.advancedsoftware.Fawry_System.Models.Response;
import com.advancedsoftware.Fawry_System.Services.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SearchAPI {
    @GetMapping(value = "/search/mobile/{context}")
    Response<ArrayList<Service>> searchMobileServiceButton(@PathVariable("context") String context) {
        MobileServiceController mobileServiceController = MobileServiceController.getMobileServiceController();
        Response<ArrayList<Service>> response = new Response<>();
        ArrayList<Service> result = mobileServiceController.searchMobileService(context);
        if(result.isEmpty()){
            response.setMessage("There is no such a service with this context");
            response.setStatus(false);
        }
        else{
            response.setStatus(true);
            response.setObject(result);
            response.setMessage("Mobile Services");
        }
        return response;
    }

    @GetMapping(value = "/search/internet/{context}")
    Response<ArrayList<Service>> searchInternetServiceButton(@PathVariable("context") String context) {
        InternetServiceController internetServiceController = InternetServiceController.getInternetServiceController();
        Response<ArrayList<Service>> response = new Response<>();
        ArrayList<Service> result = internetServiceController.searchInternetService(context);
        if(result.isEmpty()){
            response.setMessage("There is no such a service with this context");
            response.setStatus(false);
        }
        else{
            response.setStatus(true);
            response.setObject(result);
            response.setMessage("Internet Services");
        }
        return response;
    }

    @GetMapping(value = "/search/landline/{context}")
    Response<ArrayList<Service>> searchLandlineServiceButton(@PathVariable("context") String context) {
        LandlineServiceController landlineServiceController = LandlineServiceController.getLandlineServiceController();
        Response<ArrayList<Service>> response = new Response<>();
        ArrayList<Service> result = landlineServiceController.searchLandlineService(context);
        if(result.isEmpty()){
            response.setMessage("There is no such a service with this context");
            response.setStatus(false);
        }
        else{
            response.setStatus(true);
            response.setObject(result);
            response.setMessage("Landline Services");
        }
        return response;
    }

    @GetMapping(value = "/search/donation/{context}")
    Response<ArrayList<Service>> searchDonationServiceButton(@PathVariable("context") String context) {
        DonationServiceController donationServiceController = DonationServiceController.getDonationServiceController();
        Response<ArrayList<Service>> response = new Response<>();
        ArrayList<Service> result = donationServiceController.searchDonationService(context);
        if(result.isEmpty()){
            response.setMessage("There is no such a service with this context");
            response.setStatus(false);
        }
        else{
            response.setStatus(true);
            response.setObject(result);
            response.setMessage("Donation Services");
        }
        return response;
    }

    @GetMapping(value = "/search/service/{context}")
        Response<ArrayList<Response<ArrayList<Service>>>> searchAllServiceButton(@PathVariable("context") String context) {
        Response<ArrayList<Response<ArrayList<Service>>>> response = new Response<>();
        Response<ArrayList<Service>> responseMobile = new Response<>();
        Response<ArrayList<Service>> responseInternet = new Response<>();
        Response<ArrayList<Service>> responseLandline = new Response<>();
        Response<ArrayList<Service>> responseDonation = new Response<>();
        ArrayList<Service> result1 = MobileServiceController.getMobileServiceController().searchMobileService(context);
        ArrayList<Service> result2 = InternetServiceController.getInternetServiceController().searchInternetService(context);
        ArrayList<Service> result3 = LandlineServiceController.getLandlineServiceController().searchLandlineService(context);
        ArrayList<Service> result4 = DonationServiceController.getDonationServiceController().searchDonationService(context);
        response.setObject(new ArrayList<>());
        if(!result1.isEmpty()){
            responseMobile.setObject(result1);
            responseMobile.setStatus(true);
            responseMobile.setMessage("Mobile Services");
            response.getObject().add(responseMobile);
        }
        if(!result2.isEmpty()){
            responseInternet.setObject(result2);
            responseInternet.setStatus(true);
            responseInternet.setMessage("Internet Services");
            response.getObject().add(responseInternet);
        }
        if(!result3.isEmpty()){
            responseLandline.setObject(result3);
            responseLandline.setStatus(true);
            responseLandline.setMessage("Landline Services");
            response.getObject().add(responseLandline);
        }
        if(!result4.isEmpty()){
            responseDonation.setObject(result4);
            responseDonation.setStatus(true);
            responseDonation.setMessage("Donation Services");
            response.getObject().add(responseDonation);
        }
        if(response.getObject().isEmpty()){
            response.setMessage("There is no such a service with this context");
            response.setStatus(false);
        }
        else{
            response.setStatus(true);
            response.setMessage("Found " + response.getObject().size() + " Service");
            if(response.getObject().size() > 1){
                response.setMessage(response.getMessage() + "s");
            }
        }
        return response;
    }
}
