public class Discount {
    String discountName;
    int percentage;
    double applyDiscount(double amount) {
        return amount - (amount * percentage / 100);
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getDiscountName() {
        return discountName;
    }
}
