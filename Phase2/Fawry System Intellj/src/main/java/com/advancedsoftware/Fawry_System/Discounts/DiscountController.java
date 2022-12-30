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
        if(Database.getDatabase().paymentTransactions.get(client).size() > 0 || Database.getDatabase().overallDiscount == null){
            return amount;
        }
        else{
            return Database.getDatabase().overallDiscount.applyDiscount(amount);
        }
    }
    public double applyDiscountMobileService(Service service, Client client, double amount){
        MobileServiceController mobileServiceController = MobileServiceController.getMobileServiceController();
        double extra1 = amount - applyOverAllDiscount(client, amount);
        double extra2 = amount - mobileServiceController.applyMobileDiscount(amount);
        return Math.max(amount - extra1 - extra2, 0);
    }
    public double applyDiscountInternetService(Service service, Client client, double amount){
        InternetServiceController internetServiceController = InternetServiceController.getInternetServiceController();
        double extra1 = amount - applyOverAllDiscount(client, amount);
        double extra2 = amount - internetServiceController.applyInternetDiscount(amount);
        return Math.max(amount - extra1 - extra2, 0);
    }
    public double applyDiscountLandlineService(Client client, double amount){
        LandlineServiceController landlineServiceController = LandlineServiceController.getLandlineServiceController();
        double extra1 = amount - applyOverAllDiscount(client, amount);
        double extra2 = amount - landlineServiceController.applyLandlineDiscount(amount);
        return Math.max(amount - extra1 - extra2, 0);
    }
    public double applyDiscountDonationService(Service service, Client client, double amount){
        DonationServiceController donationServiceController = DonationServiceController.getDonationServiceController();
        double extra1 = amount - applyOverAllDiscount(client, amount);
        double extra2 = amount - donationServiceController.applyDonationDiscount(amount);
        return Math.max(amount - extra1 - extra2, 0);
    }
}
