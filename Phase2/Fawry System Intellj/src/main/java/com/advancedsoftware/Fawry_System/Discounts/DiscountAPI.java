package com.advancedsoftware.Fawry_System.Discounts;

import com.advancedsoftware.Fawry_System.APIs.AdminAPI;
import com.advancedsoftware.Fawry_System.APIs.ClientAPI;
import com.advancedsoftware.Fawry_System.APIs.ServiceAPI;
import com.advancedsoftware.Fawry_System.Models.Admin;
import com.advancedsoftware.Fawry_System.Models.Client;
import com.advancedsoftware.Fawry_System.Models.Response;
import com.advancedsoftware.Fawry_System.Services.Service;
import com.advancedsoftware.Fawry_System.Services.Vodafone;
import com.advancedsoftware.Fawry_System.util.Database;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DiscountAPI {
    ArrayList<Discount> getMobileDiscounts(Client client){
        ArrayList<Discount> result = new ArrayList<>();
        if(Database.getDatabase().paymentTransactions.get(client).isEmpty() && Database.getDatabase().overallDiscount != null){
            result.add(Database.getDatabase().overallDiscount);
        }
        if(Database.getDatabase().mobileServiceDiscount != null){
            result.add(Database.getDatabase().mobileServiceDiscount);
        }
        return result;
    }
    ArrayList<Discount> getInternetDiscounts(Client client){
        ArrayList<Discount> result = new ArrayList<>();
        if(Database.getDatabase().paymentTransactions.get(client).isEmpty() && Database.getDatabase().overallDiscount != null){
            result.add(Database.getDatabase().overallDiscount);
        }
        if(Database.getDatabase().internetServiceDiscount != null){
            result.add(Database.getDatabase().internetServiceDiscount);
        }
        return result;
    }
    ArrayList<Discount> getLandlineDiscounts(Client client){
        ArrayList<Discount> result = new ArrayList<>();
        if(Database.getDatabase().paymentTransactions.get(client).isEmpty() && Database.getDatabase().overallDiscount != null){
            result.add(Database.getDatabase().overallDiscount);
        }
        if(Database.getDatabase().landlineServiceDiscount != null){
            result.add(Database.getDatabase().landlineServiceDiscount);
        }
        return result;
    }
    ArrayList<Discount> getDonationDiscounts(Client client){
        ArrayList<Discount> result = new ArrayList<>();
        if(Database.getDatabase().paymentTransactions.get(client).isEmpty() && Database.getDatabase().overallDiscount != null){
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
        response.setMessage("Exist " + discounts.size() + " discount");
        if(discounts.size() > 1)response.setMessage(response.getMessage() + 's');
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
        if(discounts.size() > 1)response.setMessage(response.getMessage() + 's');
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
        if(discounts.size() > 1)response.setMessage(response.getMessage() + 's');
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
        if(discounts.size() > 1)response.setMessage(response.getMessage() + 's');
        response.setObject(discounts);
        return response;
    }

    @PutMapping(value = "/{username}/addDiscount/mobile/{service}")
    Response<SpecificDiscount> addMobileServiceDiscount(@PathVariable("username") String usernameAdmin, @PathVariable("service") String serviceName, @RequestBody double percentage){
        Admin admin = AdminAPI.getAdmin(usernameAdmin);
        Response<SpecificDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        Service service = ServiceAPI.getMobileService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        SpecificDiscount specificDiscount = new SpecificDiscount(service, percentage);
        specificDiscount.setWrappee(service);
        response.setStatus(true);
        response.setMessage(discountController.addMobileServiceDiscount(specificDiscount));
        response.setObject(specificDiscount);
        return response;
    }


    @PutMapping(value = "/{username}/addDiscount/internet/{service}")
    Response<SpecificDiscount> addInternetServiceDiscount(@PathVariable("username") String usernameAdmin, @PathVariable("service") String serviceName, @RequestBody double percentage){
        Admin admin = AdminAPI.getAdmin(usernameAdmin);
        Response<SpecificDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        Service service = ServiceAPI.getInternetService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        SpecificDiscount specificDiscount = new SpecificDiscount(service, percentage);
        specificDiscount.setWrappee(service);
        response.setStatus(true);
        response.setMessage(discountController.addInternetServiceDiscount(specificDiscount));
        response.setObject(specificDiscount);
        return response;
    }

    @PutMapping(value = "/{username}/addDiscount/landline/{service}")
    Response<SpecificDiscount> addLandLineServiceDiscount(@PathVariable("username") String usernameAdmin, @PathVariable("service") String serviceName, @RequestBody double percentage){
        Admin admin = AdminAPI.getAdmin(usernameAdmin);
        Response<SpecificDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        Service service = ServiceAPI.getLandlineService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        SpecificDiscount specificDiscount = new SpecificDiscount(service, percentage);
        specificDiscount.setWrappee(service);
        response.setStatus(true);
        response.setMessage(discountController.addLandLineServiceDiscount(specificDiscount));
        response.setObject(specificDiscount);
        return response;
    }
    @PutMapping(value = "/{username}/addDiscount/donation/{service}")
    Response<SpecificDiscount> addDonationServiceDiscount(@PathVariable("username") String usernameAdmin, @PathVariable("service") String serviceName, @RequestBody double percentage){
        Admin admin = AdminAPI.getAdmin(usernameAdmin);
        Response<SpecificDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        Service service = ServiceAPI.getDonationService(serviceName);
        if(service == null){
            response.setStatus(false);
            response.setMessage("There is no such a service");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        SpecificDiscount specificDiscount = new SpecificDiscount(service, percentage);
        specificDiscount.setWrappee(service);
        response.setStatus(true);
        response.setMessage(discountController.addDonationServiceDiscount(specificDiscount));
        response.setObject(specificDiscount);
        return response;
    }

    @PutMapping(value = "/{username}/addDiscount/overall")
    Response<OverallDiscount> addOverallDiscount(@PathVariable("username") String usernameAdmin, @RequestBody double percentage){
        Admin admin = AdminAPI.getAdmin(usernameAdmin);
        Response<OverallDiscount> response = new Response<>();
        if(admin == null){
            response.setStatus(false);
            response.setMessage("There is no such an admin");
            return response;
        }
        DiscountController discountController = DiscountController.getDiscountController();
        OverallDiscount overallDiscount = new OverallDiscount(new Vodafone("Overall Discount"), percentage);
        response.setStatus(true);
        response.setMessage(discountController.addOverallDiscount(overallDiscount));
        response.setObject(overallDiscount);
        return response;
    }
}
