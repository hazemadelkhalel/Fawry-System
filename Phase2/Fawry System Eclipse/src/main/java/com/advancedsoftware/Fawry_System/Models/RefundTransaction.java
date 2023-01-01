package com.advancedsoftware.Fawry_System.Models;

public class RefundTransaction extends Transaction{
    PaymentTransaction paymentTransaction;

    public RefundTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    public PaymentTransaction getPaymentTransaction() {
        return paymentTransaction;
    }

    public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }

    @Override
    public String toString() {
        return "RefundTransaction{" +
                "client=" + client +
                ", paymentTransaction=" + paymentTransaction +
                ", client=" + client +
                ", amount=" + amount +
                '}';
    }
}
