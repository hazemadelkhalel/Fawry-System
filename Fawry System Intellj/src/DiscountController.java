//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class DiscountController extends FawryController {
    public DiscountController() {
    }

    boolean checkSimilarity(String first, String second) {
        return first.toLowerCase().contains(second.toLowerCase());
    }

    boolean checkExistence(String categoryDiscount) {
        Iterator var2 = this.database.discounts.entrySet().iterator();

        Map.Entry entry;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            entry = (Map.Entry)var2.next();
        } while(!this.checkSimilarity(categoryDiscount, (String)entry.getKey()));

        return true;
    }

    String addDiscount(String categoryDiscount, Database.Pair<String, Integer> valueDiscount) {
        boolean existDiscountName = false;
        Iterator var4 = this.database.discounts.entrySet().iterator();

        while(var4.hasNext()) {
            Map.Entry<String, ArrayList<Database.Pair<String, Integer>>> entry = (Map.Entry)var4.next();
            String currentDiscountName = (String)entry.getKey();
            if (this.checkSimilarity(categoryDiscount, currentDiscountName)) {
                existDiscountName = true;
                boolean added = false;
                ArrayList<Database.Pair<String, Integer>> currentDiscounts = (ArrayList)entry.getValue();

                for(int i = 0; i < currentDiscounts.size(); ++i) {
                    if (this.checkSimilarity((String)valueDiscount.getFirst(), (String)((Database.Pair)currentDiscounts.get(i)).getFirst())) {
                        ((Database.Pair)currentDiscounts.get(i)).setSecond((Integer)valueDiscount.getSecond());
                        added = true;
                        break;
                    }
                }

                if (!added) {
                    ((ArrayList)entry.getValue()).add(valueDiscount);
                }
                break;
            }
        }

        if (!existDiscountName) {
            ArrayList<Database.Pair<String, Integer>> newCategory = new ArrayList();
            newCategory.add(valueDiscount);
            this.database.discounts.put(categoryDiscount, newCategory);
        }

        return "Successfully Added";
    }
}
