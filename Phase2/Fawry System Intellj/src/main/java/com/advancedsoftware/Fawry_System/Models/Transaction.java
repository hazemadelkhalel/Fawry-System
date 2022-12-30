package com.advancedsoftware.Fawry_System.Models;

abstract public class Transaction {
    Client client;
    double amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "client=" + client +
                ", amount=" + amount +
                '}';
    }

    public Client getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
