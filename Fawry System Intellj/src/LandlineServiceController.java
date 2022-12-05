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
    boolean checkDiscountLandlineService(Service service){
        for(int i = 0; i < database.landlineServices.size(); i++){
            if(service != null && database.landlineServices.get(i).getServiceName().equals(service.getServiceName())){
                return true;
            }
        }
        return false;
    }
    boolean checkDiscountLandlineServiceExistance(){
        if(database.landlineServiceDiscount != null){
            return true;
        }
        else{
            return false;
        }
    }
}
