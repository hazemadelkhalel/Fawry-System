import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    HashMap<Account, String> accounts;
    HashMap<String, HashMap<String, ArrayList<String>>> services;
    HashMap<String, ArrayList<Pair<String, Integer>>> discounts;

    Database(){
        accounts = new HashMap<>();
        services = new HashMap<>();
        discounts = new HashMap<>();
    }

    public static class Pair<F, S> {
        private F first;
        private S second;
        Pair(F first, S second){
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public void setSecond(S second) {
            this.second = second;
        }
    }

}
