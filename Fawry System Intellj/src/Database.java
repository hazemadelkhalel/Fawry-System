
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    HashMap<Account, String> accounts = new HashMap();
    HashMap<String, HashMap<String, ArrayList<String>>> services = new HashMap();
    HashMap<String, ArrayList<Pair<String, Integer>>> discounts = new HashMap();

    Database() {
    }

    public static class Pair<F, S> {
        private F first;
        private S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return this.first;
        }

        public S getSecond() {
            return this.second;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public void setSecond(S second) {
            this.second = second;
        }
    }
}