package com.advancedsoftware.Fawry_System.Payments;
import com.advancedsoftware.Fawry_System.Models.*;
public abstract class PaymentMethod {
    String MethodName;

    public abstract String pay(Client client, double amount);

    public void setMethodName(String methodName) {
        MethodName = methodName;
    }


    public String getMethodName() {
        return MethodName;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "MethodName='" + MethodName + '\'' +
                '}';
    }
}
