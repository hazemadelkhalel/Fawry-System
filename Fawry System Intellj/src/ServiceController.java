import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceController extends FawryController{

    ServiceController(Database database){
        this.database = database;
    }

//    void listCategories() {
//        int numOfCategory= 1;
//        for(Map.Entry<String, HashMap<String, ArrayList<String>>> entry: database.services.entrySet()){
//            System.out.println(numOfCategory + ") " + entry.getKey());
//            numOfCategory++;
//        }
//    }

}
