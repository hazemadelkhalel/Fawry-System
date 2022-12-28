package com.advancedsoftware.Fawry_System.payment;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.model.*;
public class CashMethod extends PaymentMethod{
    CashMethod(Database database){
        this.database = database;
        MethodName = "Cash";
    }
    @Override
    public String pay(Client client, double amount) {
        return "Paid Successfully";
    }
}
