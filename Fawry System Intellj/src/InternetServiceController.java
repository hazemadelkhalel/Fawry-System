import java.util.ArrayList;

public class InternetServiceController extends FawryController{
    InternetServiceController(Database database){
        this.database = database;
    }
    String pay(Client client, Service service, double amount, int wayIndex){
        return service.payInternetService(client, amount, wayIndex);
    }
    ArrayList<Service> searchInternetService(String context){
        SearchController searchController = new SearchController(database);
        return searchController.searchInternetService(context);
    }
}
