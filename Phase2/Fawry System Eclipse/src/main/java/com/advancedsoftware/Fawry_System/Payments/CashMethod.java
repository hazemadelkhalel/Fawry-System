package com.advancedsoftware.Fawry_System.Payments;
import com.advancedsoftware.Fawry_System.Models.*;
public class CashMethod extends PaymentMethod{
    private static CashMethod cashMethod;

    private CashMethod(){
        MethodName = "Cash";
    }
    public static CashMethod getCashMethod() {
        if (cashMethod == null) {
            cashMethod = new CashMethod();
        }
        return cashMethod;
    }
    @Override
    public String pay(Client client, double amount) {
        return "Paid Successfully";
    }
}
