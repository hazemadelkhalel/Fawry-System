//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SearchController extends FawryController {
    public SearchController() {
    }

<<<<<<< Updated upstream
    boolean match(String first, String second) {
        for(int i = 0; i < first.length(); ++i) {
            if (first.charAt(i) != second.charAt(i)) {
=======
    SearchController(Database database){
        this.database = database;
    }
    boolean match(String first, String second){
        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) != second.charAt(i)){
>>>>>>> Stashed changes
                return false;
            }
        }

        return true;
    }

    Map<String, HashMap<String, ArrayList<String>>> search(String context) {
        Map<String, HashMap<String, ArrayList<String>>> result = new HashMap();
        Iterator var3 = this.database.services.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<String, HashMap<String, ArrayList<String>>> entry = (Map.Entry)var3.next();
            HashMap<String, ArrayList<String>> matchServices = new HashMap();
            Iterator var6 = ((HashMap)this.database.services.get(entry.getKey())).entrySet().iterator();

            while(var6.hasNext()) {
                Map.Entry<String, ArrayList<String>> entry1 = (Map.Entry)var6.next();
                String service = (String)entry1.getKey();
                if (this.match(context, service)) {
                    matchServices.put((String)entry1.getKey(), (ArrayList)entry1.getValue());
                }
            }

            if (matchServices.size() > 0) {
                result.put((String)entry.getKey(), matchServices);
            }
        }

        return result;
    }

    void listSearchResult(Map<String, HashMap<String, ArrayList<String>>> result) {
        Iterator var2 = result.entrySet().iterator();

        while(var2.hasNext()) {
            Map.Entry<String, HashMap<String, ArrayList<String>>> entry = (Map.Entry)var2.next();
            System.out.println("-" + (String)entry.getKey());
            HashMap<String, ArrayList<String>> servicesInCategory = (HashMap)entry.getValue();
            int numOfService = 1;

            for(Iterator var6 = servicesInCategory.entrySet().iterator(); var6.hasNext(); ++numOfService) {
                Map.Entry<String, ArrayList<String>> entry1 = (Map.Entry)var6.next();
                System.out.println("" + numOfService + ") " + (String)entry1.getKey());
            }
        }

    }
}
