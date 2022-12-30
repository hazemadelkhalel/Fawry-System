package com.advancedsoftware.Fawry_System.Discounts;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.Services.*;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Payments.*;

public class Discount implements Service{
    double percentage;
    Service wrappee;
    Discount(Service wrappee){
        this.wrappee = wrappee;
    }
    @Override
    public double applyDiscount(double amount) {
        return wrappee.applyDiscount(amount);
    }

    @Override
    public String toString() {
        return "Discount{" +
                ", percentage=" + percentage +
                ", wrappee=" + wrappee +
                '}';
    }


    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
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

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setWrappee(Service wrappee) {
        this.wrappee = wrappee;
    }

    public Service getWrappee() {
        return wrappee;
    }
}
