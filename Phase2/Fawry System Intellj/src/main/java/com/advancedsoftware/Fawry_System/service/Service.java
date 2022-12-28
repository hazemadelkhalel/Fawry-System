package com.advancedsoftware.Fawry_System.service;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.model.*;
import com.advancedsoftware.Fawry_System.payment.*;
public interface Service {
    String serviceName = null;
    String payMobileService(Client client, double amount, int wayIndex);
    String payInternetService(Client client, double amount, int wayIndex);
    String payLandlineService(Client client, double amount, int wayIndex);
    String payDonationService(Client client, double amount, int wayIndex);
    public String getServiceName();
    public void setWaysOfPayment(ArrayList<PaymentMethod> waysOfPayment);
    public ArrayList<PaymentMethod> getWaysOfPayment();
    double applyDiscount(double amount);


    public void setServiceName(String serviceName);
}
