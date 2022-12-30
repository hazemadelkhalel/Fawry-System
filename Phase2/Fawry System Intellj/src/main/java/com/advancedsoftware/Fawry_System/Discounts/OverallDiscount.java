package com.advancedsoftware.Fawry_System.Discounts;
import com.advancedsoftware.Fawry_System.Services.*;

public class OverallDiscount extends Discount{
    public OverallDiscount(Service wrappee, double percentage) {
        super(wrappee);
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "OverallDiscount{" +
                ", percentage=" + percentage +
                ", wrappee=" + wrappee +
                '}';
    }

    @Override
    public double applyDiscount(double amount) {
        double result = wrappee.applyDiscount(amount);
        result -= (amount * percentage) / 100;
        return result;
    }
}
