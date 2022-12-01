import java.util.ArrayList;

public class DonationServiceController extends FawryController{
    DonationServiceController(Database database){
        this.database = database;
    }
    String pay(Client client, Service service, double amount, int wayIndex){
        return service.payDonationService(client, amount, wayIndex);
    }
    ArrayList<Service> searchDonationService(String context){
        SearchController searchController = new SearchController(database);
        return searchController.searchDonationService(context);
    }
    boolean checkDiscountDonationService(Service service){
        for(int i = 0; i < database.donationServices.size(); i++){
            if(database.donationServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
}
