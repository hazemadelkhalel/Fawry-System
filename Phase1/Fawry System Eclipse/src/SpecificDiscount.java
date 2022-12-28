
public class SpecificDiscount extends Discount{

    SpecificDiscount(Service wrappee, double percentage){
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
