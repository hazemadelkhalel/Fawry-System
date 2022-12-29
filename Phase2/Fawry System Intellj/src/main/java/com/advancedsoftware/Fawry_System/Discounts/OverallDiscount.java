package com.advancedsoftware.Fawry_System.Discounts;
import com.advancedsoftware.Fawry_System.Services.*;

public class OverallDiscount extends Discount{
    OverallDiscount(Service wrappee, double percentage) {
        super(wrappee);
        this.percentage = percentage;
    }
    @Override
    public double applyDiscount(double amount) {
        double result = wrappee.applyDiscount(amount);
        result -= (amount * percentage) / 100;
        return result;
    }
}
