import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceController extends FawryController{

    ServiceController(Database database){
        this.database = database;
    }
    boolean checkSimilarity(String first, String second){
        return first.toLowerCase().contains(second.toLowerCase());
    }
    String addService(Service service){
        int counter = 0;
        boolean existService = false;
        for(int i = 0; i < database.services.size(); i++){
            Service tempService = database.services.get(i);
            if(checkSimilarity(service.getServiceName(), tempService.getServiceName())){
                existService = true;
                for(int j = 0; j < service.providers.size(); j++){
                    boolean exist = false;
                    Provider provider = service.providers.get(j);
                    for(int k = 0; k < tempService.providers.size(); k++){
                        Provider existProvider = tempService.providers.get(k);
                        if(checkSimilarity(provider.getProviderName(), existProvider.getProviderName())){
                            exist = true;
                            break;
                        }
                    }
                    if(!exist){
                        database.services.get(i).providers.add(provider);
                        counter++;
                    }
                }
                break;
            }
        }
        if(!existService){
            database.services.add(service);
            return "Successfully Added";
        }
        else {
            if (counter > 0) {
                return "Successfully Added";
            } else {
                return "All services are already exist";
            }
        }
    }
//    void listCategories() {
//        int numOfCategory= 1;
//        for(Map.Entry<String, HashMap<String, ArrayList<String>>> entry: database.services.entrySet()){
//            System.out.println(numOfCategory + ") " + entry.getKey());
//            numOfCategory++;
//        }
//    }

}
