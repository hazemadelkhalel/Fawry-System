import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchController extends FawryController{

    SearchController(Database database){
        this.database = database;
    }
    boolean match(String first, String second){
        for(int i = 0; i < first.length(); i++){
            if(Character.toLowerCase(first.charAt(i)) != Character.toLowerCase(second.charAt(i))){
                return false;
            }
        }
        return true;
    }
    ArrayList<Service> searchMobileService(String context){
        ArrayList<Service> result = new ArrayList<>();
        for(int i = 0; i < database.mobileServices.size(); i++){
            Service service = database.mobileServices.get(i);
            if(match(context, service.getServiceName())){
                result.add(service);
            }
        }
        return result;
    }
    ArrayList<Service> searchInternetService(String context){
        ArrayList<Service> result = new ArrayList<>();
        for(int i = 0; i < database.InternetServices.size(); i++){
            Service service = database.InternetServices.get(i);
            if(match(context, service.getServiceName())){
                result.add(service);
            }
        }
        return result;
    }
    ArrayList<Service> searchLandlineService(String context){
        ArrayList<Service> result = new ArrayList<>();
        for(int i = 0; i < database.landlineServices.size(); i++){
            Service service = database.landlineServices.get(i);
            if(match(context, service.getServiceName())){
                result.add(service);
            }
        }
        return result;
    }
    ArrayList<Service> searchDonationService(String context){
        ArrayList<Service> result = new ArrayList<>();
        for(int i = 0; i < database.donationServices.size(); i++){
            Service service = database.donationServices.get(i);
            if(match(context, service.getServiceName())){
                result.add(service);
            }
        }
        return result;
    }
}
