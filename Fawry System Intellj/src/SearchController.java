import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchController extends FawryController{

    boolean match(String first, String second){
        for(int i = 0; i < first.length(); i++){
            if(Character.toLowerCase(first.charAt(i)) != Character.toLowerCase(second.charAt(i))){
                return false;
            }
        }
        return true;
    }
    ArrayList<Service> search(String context){
        ArrayList<Service> result = new ArrayList<>();
        for(int i = 0; i < database.services.size(); i++){
            Service service = database.services.get(i);
            Service tempService = new Service();
            tempService.setServiceName(service.getServiceName());
            for(int j = 0; j < service.providers.size(); j++){
                Provider provider = service.providers.get(j);
                if(match(context, provider.getProviderName())){
                    tempService.providers.add(provider);
                }
            }
            if(tempService.providers.size() > 0){
                result.add(tempService);
            }
        }
        return result;
    }
}
