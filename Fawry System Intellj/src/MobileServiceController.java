import java.util.ArrayList;

public class MobileServiceController extends FawryController{
    MobileServiceController(Database database){
        this.database = database;
    }
    String pay(Client client, Service service, double amount, int wayIndex){
        return service.payMobileService(client, amount, wayIndex);
    }
    ArrayList<Service> searchMobileService(String context){
        SearchController searchController = new SearchController(database);
        return searchController.searchMobileService(context);
    }
}
