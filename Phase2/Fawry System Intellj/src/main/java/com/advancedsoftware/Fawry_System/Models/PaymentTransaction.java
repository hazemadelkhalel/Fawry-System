
package com.advancedsoftware.Fawry_System.Models;
import com.advancedsoftware.Fawry_System.Services.Service;
public class PaymentTransaction extends Transaction{
    Client client;
    Service service;
    double amount;
    int wayIndex;

    @Override
    public String toString() {
        return "Transaction{" +
                "client=" + client +
                ", service=" + service +
                ", amount=" + amount +
                ", wayIndex=" + wayIndex +
                '}';
    }

    public PaymentTransaction(Client client, Service service, double amount, int wayIndex){
        this.client = client;
        this.service = service;
        this.amount = amount;
        this.wayIndex = wayIndex;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setWayIndex(int wayIndex) {
        this.wayIndex = wayIndex;
    }

    public Service getService() {
        return service;
    }

    public double getAmount() {
        return amount;
    }

    public Client getClient() {
        return client;
    }

    public int getWayIndex() {
        return wayIndex;
    }
}
