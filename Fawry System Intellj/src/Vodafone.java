import java.util.ArrayList;

public class Vodafone implements Service{
    String serviceName;
    ArrayList<PaymentMethod> waysOfPayment;
    Vodafone(String serviceName){
        this.serviceName = serviceName;
        waysOfPayment = new ArrayList<>();
    }

    @Override
    public String payMobileService(Client client, double amount, int wayIndex) {
        return waysOfPayment.get(wayIndex).pay(client, amount);
    }

    @Override
    public String payInternetService(Client client, double amount, int wayIndex) {
        return waysOfPayment.get(wayIndex).pay(client, amount);
    }

    @Override
    public String payLandlineService(Client client, double amount, int wayIndex) {return "Not Supported";}
    @Override
    public String payDonationService(Client client, double amount, int wayIndex) {return "Not Supported";}

    public String getServiceName() {
        return serviceName;
    }

    public void setWaysOfPayment(ArrayList<PaymentMethod> waysOfPayment) {
        this.waysOfPayment = waysOfPayment;
    }

    public ArrayList<PaymentMethod> getWaysOfPayment() {
        return waysOfPayment;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public void addPaymentMethod(PaymentMethod paymentMethod){
        waysOfPayment.add(paymentMethod);
    }
}