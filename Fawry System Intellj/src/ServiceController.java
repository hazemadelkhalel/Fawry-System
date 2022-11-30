import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceController extends FawryController{

    boolean checkSimilarity(String first, String second){
        return first.toLowerCase().contains(second.toLowerCase());
    }
    String addService(String categoryService, HashMap<String, ArrayList<String>> service){
        HashMap<String, ArrayList<String>> newServices = new HashMap<>();
        for(Map.Entry<String, HashMap<String, ArrayList<String>>> entry: database.services.entrySet()){
            if(checkSimilarity(entry.getKey(), categoryService)){
                categoryService = entry.getKey();
                for(Map.Entry<String, ArrayList<String>> entry1 : service.entrySet()){
                    boolean exist = false;
                    for(Map.Entry<String, ArrayList<String>> entry2 : entry.getValue().entrySet()){
                        if(checkSimilarity(entry1.getKey(), entry2.getKey())){
                            exist = true;
                            break;
                        }
                    }
                    if(!exist){
                        newServices.put(entry1.getKey(), entry1.getValue());
                    }
                }

            }
        }
        if(newServices.size() > 0) {
            database.services.put(categoryService, newServices);
            return "Successfully Added";
        }
        else{
            return "All services are already exist";
        }
    }
    void listCategories() {
        int numOfCategory= 1;
        for(Map.Entry<String, HashMap<String, ArrayList<String>>> entry: database.services.entrySet()){
            System.out.println(numOfCategory + ") " + entry.getKey());
            numOfCategory++;
        }
    }

}
