package com.advancedsoftware.Fawry_System.discount;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.service.*;
import com.advancedsoftware.Fawry_System.model.*;
import com.advancedsoftware.Fawry_System.payment.*;

public class Discount implements Service{
    String discountName;
    double percentage;
    Service wrappee;
    Discount(Service wrappee){
        this.wrappee = wrappee;
    }
    @Override
    public double applyDiscount(double amount) {
        return wrappee.applyDiscount(amount);
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getDiscountName() {
        return discountName;
    }

    @Override
    public String payMobileService(Client client, double amount, int wayIndex) {
        return null;
    }

    @Override
    public String payInternetService(Client client, double amount, int wayIndex) {
        return null;
    }

    @Override
    public String payLandlineService(Client client, double amount, int wayIndex) {
        return null;
    }

    @Override
    public String payDonationService(Client client, double amount, int wayIndex) {
        return null;
    }

    @Override
    public String getServiceName() {
        return null;
    }

    @Override
    public void setWaysOfPayment(ArrayList<PaymentMethod> waysOfPayment) {

    }

    @Override
    public ArrayList<PaymentMethod> getWaysOfPayment() {
        return null;
    }

    @Override
    public void setServiceName(String serviceName) {

    }
}
