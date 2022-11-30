import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchController extends FawryController{

    boolean match(String first, String second){
        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) != second.charAt(i)){
                return false;
            }
        }
        return true;
    }
    Map<String, HashMap<String, ArrayList<String>>> search(String context){
        Map<String, HashMap<String, ArrayList<String>>> result = new HashMap<>();
        for(Map.Entry<String, HashMap<String, ArrayList<String>>> entry: database.services.entrySet()){
            HashMap<String, ArrayList<String>> matchServices = new HashMap<>();
            for(Map.Entry<String, ArrayList<String>> entry1: database.services.get(entry.getKey()).entrySet()){
                String service = entry1.getKey();
                if(match(context, service)){
                    matchServices.put(entry1.getKey(), entry1.getValue());
                }
            }
            if(matchServices.size() > 0){
                result.put(entry.getKey(), matchServices);
            }
        }
        return result;
    }
}
