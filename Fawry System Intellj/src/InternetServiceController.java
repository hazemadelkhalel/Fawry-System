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
    boolean checkDiscountInternetService(Service service){
        for(int i = 0; i < database.InternetServices.size(); i++){
            if(service != null && database.mobileServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    boolean checkDiscountInternetServiceExistance(){
        if(database.internetServiceDiscount != null){
            return true;
        }
        else{
            return false;
        }
    }
}
