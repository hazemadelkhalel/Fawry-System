import java.util.ArrayList;

public class LandlineServiceController extends FawryController{
    LandlineServiceController(Database database){
        this.database = database;
    }
    String pay(Client client, Service service, double amount, int wayIndex){
        return service.payLandlineService(client, amount, wayIndex);
    }
    ArrayList<Service> searchLandlineService(String context){
        SearchController searchController = new SearchController(database);
        return searchController.searchLandlineService(context);
    }
}
