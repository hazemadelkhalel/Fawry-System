package com.advancedsoftware.Fawry_System.Services;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Payments.*;
public interface Service {
    String serviceName = null;
    public ArrayList<PaymentMethod> getWaysOfPayment();
    String payMobileService(Client client, double amount, int wayIndex);
    String payInternetService(Client client, double amount, int wayIndex);
    String payLandlineService(Client client, double amount, int wayIndex);
    String payDonationService(Client client, double amount, int wayIndex);
    public String getServiceName();
    public void setWaysOfPayment(ArrayList<PaymentMethod> waysOfPayment);
    double applyDiscount(double amount);


    public void setServiceName(String serviceName);
}
