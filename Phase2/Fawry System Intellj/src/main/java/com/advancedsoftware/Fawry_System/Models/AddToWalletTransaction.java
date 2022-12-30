package com.advancedsoftware.Fawry_System.Models;

public class AddToWalletTransaction extends Transaction{
    Client client;
    CreditCard creditCard;
    double amount;

    public AddToWalletTransaction(Client client, CreditCard creditCard, double amount) {
        this.client = client;
        this.creditCard = creditCard;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AddToWalletTransaction{" +
                "client=" + client +
                ", creditCard=" + creditCard +
                ", amount=" + amount +
                '}';
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public double getAmount() {
        return amount;
    }
}
