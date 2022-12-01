
public class PaymentController extends FawryController{
    PaymentController(Database database){
        this.database = database;
    }
    String payMobileService(Client client, Service service, double amount, int wayIndex) {
        MobileServiceController mobileServiceController = new MobileServiceController(database);
        String result = mobileServiceController.pay(client, service, amount, wayIndex);
        Transaction transaction = new Transaction(client, service, amount, wayIndex);
        client.transactions.add(transaction);
        return result;
    }
    String payInternetService(Client client, Service service, double amount, int wayIndex) {
        InternetServiceController internetServiceController = new InternetServiceController(database);
        String result = internetServiceController.pay(client, service, amount, wayIndex);
        Transaction transaction = new Transaction(client, service, amount, wayIndex);
        client.transactions.add(transaction);
        return result;
    }
    String payLandlineService(Client client, Service service, double amount, int wayIndex) {
        LandlineServiceController landlineServiceController = new LandlineServiceController(database);
        String result = landlineServiceController.pay(client, service, amount, wayIndex);
        Transaction transaction = new Transaction(client, service, amount, wayIndex);
        client.transactions.add(transaction);
        return result;
    }
    String payDonationService(Client client, Service service, double amount, int wayIndex) {
        DonationServiceController donationServiceController = new DonationServiceController(database);
        String result = donationServiceController.pay(client, service, amount, wayIndex);
        Transaction transaction = new Transaction(client, service, amount, wayIndex);
        client.transactions.add(transaction);
        return result;
    }
}