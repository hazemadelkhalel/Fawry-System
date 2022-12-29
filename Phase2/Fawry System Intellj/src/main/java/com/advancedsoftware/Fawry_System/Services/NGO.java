package com.advancedsoftware.Fawry_System.Services;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Payments.*;
public class NGO implements Service{
    String serviceName;
    ArrayList<PaymentMethod> waysOfPayment;
    public NGO(String serviceName){
        this.serviceName = serviceName;
        waysOfPayment = new ArrayList<>();

    }
    @Override
    public String payMobileService(Client client, double amount, int wayIndex) {return "Not Supported";}

    @Override
    public String payInternetService(Client client, double amount, int wayIndex) {return "Not Supported";}

    @Override
    public String payLandlineService(Client client, double amount, int wayIndex) {return "Not Supported";}
    @Override
    public String payDonationService(Client client, double amount, int wayIndex) {
        return waysOfPayment.get(wayIndex).pay(client, amount);
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public void addPaymentMethod(PaymentMethod paymentMethod){
        waysOfPayment.add(paymentMethod);
    }
    public void setWaysOfPayment(ArrayList<PaymentMethod> waysOfPayment) {
        this.waysOfPayment = waysOfPayment;
    }

    public ArrayList<PaymentMethod> getWaysOfPayment() {
        return waysOfPayment;
    }
    @Override
    public double applyDiscount(double amount) {
        return amount;
    }

}
