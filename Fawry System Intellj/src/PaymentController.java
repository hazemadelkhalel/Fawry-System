
public class PaymentController extends FawryController{
    PaymentController(Database database){
        this.database = database;
    }
    String payMobileService(Client client, Service service, double amount, int wayIndex) {
        MobileServiceController mobileServiceController = new MobileServiceController(database);
        return mobileServiceController.pay(client, service, amount, wayIndex);
    }
    String payInternetService(Client client, Service service, double amount, int wayIndex) {
        MobileServiceController mobileServiceController = new MobileServiceController(database);
        return mobileServiceController.pay(client, service, amount, wayIndex);
    }
    String payLandlineService(Client client, Service service, double amount, int wayIndex) {
        return service.payLandlineService(client, amount, wayIndex);
    }
    String payDonationService(Client client, Service service, double amount, int wayIndex) {
        return service.payDonationService(client, amount, wayIndex);
    }
}