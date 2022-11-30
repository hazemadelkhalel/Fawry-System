import java.util.ArrayList;
import java.util.Map;

public class DiscountController extends FawryController{
    DiscountController(Database database){
        this.database = database;
    }
    boolean checkSimilarity(String first, String second){
        return first.toLowerCase().contains(second.toLowerCase());
    }

    String addDiscount(OverallDiscount discount){
        boolean existDiscount = false;
        for(int i = 0; i < database.discounts.size();i++){
            if(database.discounts.get(i) instanceof OverallDiscount){
                database.discounts.set(i, discount);
                existDiscount = true;
                break;
            }
        }
        if(!existDiscount){
            database.discounts.add(discount);
        }
        return "Added Successfully";
    }
    String addDiscount(SpecificDiscount discount){
        boolean existDiscount = false;
        for(int i = 0; i < database.discounts.size();i++){
            if(database.discounts.get(i) instanceof SpecificDiscount){
                if(checkSimilarity(database.discounts.get(i).getDiscountName(), discount.getDiscountName())) {
                    database.discounts.set(i, discount);
                    existDiscount = true;
                    break;
                }
            }
        }
        if(!existDiscount){
            database.discounts.add(discount);
        }
        return "Added Successfully";

    }
}
