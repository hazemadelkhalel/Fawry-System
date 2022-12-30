package com.advancedsoftware.Fawry_System.Discounts;
import com.advancedsoftware.Fawry_System.Services.*;
public class SpecificDiscount extends Discount{

    public SpecificDiscount(Service wrappee, double percentage){
        super(wrappee);
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "SpecificDiscount{" +
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
