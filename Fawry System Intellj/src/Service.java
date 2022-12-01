import java.util.ArrayList;

public interface Service {
    String serviceName = null;
    String payMobileService(Client client, double amount, int wayIndex);
    String payInternetService(Client client, double amount, int wayIndex);
    String payLandlineService(Client client, double amount, int wayIndex);
    String payDonationService(Client client, double amount, int wayIndex);
    public String getServiceName();
    public void setWaysOfPayment(ArrayList<PaymentMethod> waysOfPayment);
    public ArrayList<PaymentMethod> getWaysOfPayment();
    double applyDiscount(double amount);


    public void setServiceName(String serviceName);
}
