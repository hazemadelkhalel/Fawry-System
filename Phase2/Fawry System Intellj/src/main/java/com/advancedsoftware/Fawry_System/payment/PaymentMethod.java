package com.advancedsoftware.Fawry_System.payment;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.model.*;
public abstract class PaymentMethod {

    Database database;
    String MethodName;

    public abstract String pay(Client client, double amount);

    public void setMethodName(String methodName) {
        MethodName = methodName;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public String getMethodName() {
        return MethodName;
    }
}
