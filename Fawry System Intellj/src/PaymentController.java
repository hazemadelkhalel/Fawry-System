
public class PaymentController extends FawryController{
    PaymentController(Database database){
        this.database = database;
    }
    String pay(Client client, int indexService, int indexProvider, double amount, int wayIndex) {
        Provider provider = database.services.get(indexService).providers.get(indexProvider);
        provider.pay(client, wayIndex, amount);
        return "Paid Successfully";
    }
}