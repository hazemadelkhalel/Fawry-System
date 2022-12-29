package com.advancedsoftware.Fawry_System.Discounts;
import com.advancedsoftware.Fawry_System.Controllers.*;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Services.*;
import com.advancedsoftware.Fawry_System.Models.*;




public class DiscountController {
    private static DiscountController discountController;

    private DiscountController(){}
    public static DiscountController getDiscountController() {
        if (discountController == null) {
            discountController = new DiscountController();
        }
        return discountController;
    }

    public String addMobileServiceDiscount(SpecificDiscount specificDiscount){
        Database.getDatabase().mobileServiceDiscount = specificDiscount;
        return "Added Successfully";
    }

    public String addInternetServiceDiscount(SpecificDiscount specificDiscount){
        Database.getDatabase().internetServiceDiscount = specificDiscount;
        return "Added Successfully";
    }
    public String addDonationServiceDiscount(SpecificDiscount specificDiscount){
        Database.getDatabase().donationServiceDiscount = specificDiscount;
        return "Added Successfully";
    }
    public String addLandLineServiceDiscount(SpecificDiscount specificDiscount){
        Database.getDatabase().landlineServiceDiscount = specificDiscount;
        return "Added Successfully";
    }
    public String addOverallDiscount(OverallDiscount overallDiscount){
        Database.getDatabase().overallDiscount = overallDiscount;
        return "Added Successfully";
    }

    double applyOverAllDiscount(Client client, double amount){
        if(client.getTransactions().size() > 0 || Database.getDatabase().overallDiscount == null){
            return amount;
        }
        else{
            return Database.getDatabase().overallDiscount.applyDiscount(amount);
        }
    }
    public double applyDiscountMobileService(Service service, Client client, double amount){
        double extra = amount - applyOverAllDiscount(client, amount);
        MobileServiceController mobileServiceController = MobileServiceController.getMobileServiceController();
        if(mobileServiceController.checkDiscountMobileService(service) && Database.getDatabase().mobileServiceDiscount != null){
            return Math.max(Database.getDatabase().mobileServiceDiscount.applyDiscount(amount) - extra, 0);
        }
        else{
            return amount;
        }
    }
    public double applyDiscountInternetService(Service service, Client client, double amount){
        double extra = amount - applyOverAllDiscount(client, amount);
        InternetServiceController internetServiceController = InternetServiceController.getInternetServiceController();
        if(internetServiceController.checkDiscountInternetService(service) && Database.getDatabase().internetServiceDiscount != null){
            return Math.max(Database.getDatabase().internetServiceDiscount.applyDiscount(amount) - extra, 0);
        }
        else{
            return amount;
        }
    }
    public double applyDiscountLandlineService(Service service, Client client, double amount){
        double extra = amount - applyOverAllDiscount(client, amount);
        LandlineServiceController landlineServiceController = LandlineServiceController.getLandlineServiceController();
        if(landlineServiceController.checkDiscountLandlineService(service) && Database.getDatabase().landlineServiceDiscount != null){
            return Math.max(Database.getDatabase().landlineServiceDiscount.applyDiscount(amount) - extra, 0);
        }
        else{
            return amount;
        }
    }
    public double applyDiscountDonationService(Service service, Client client, double amount){
        double extra = amount - applyOverAllDiscount(client, amount);
        DonationServiceController donationServiceController = DonationServiceController.getDonationServiceController();
        if(donationServiceController.checkDiscountDonationService(service) && Database.getDatabase().donationServiceDiscount != null){
            return Math.max(Database.getDatabase().donationServiceDiscount.applyDiscount(amount) - extra, 0);
        }
        else{
            return amount;
        }
    }
    public boolean checkDiscountAvailable(Service service){
        for(int i = 0; i < Database.getDatabase().discounts.size(); i++){
            if(Database.getDatabase().discounts.get(i).wrappee.getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
}
