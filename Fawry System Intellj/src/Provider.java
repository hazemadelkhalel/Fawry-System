import java.util.ArrayList;

public class Provider {
    String ProviderName;
    ArrayList<FormField> formFields;
    ArrayList<PaymentMethod> waysOfPayment;
    Provider(Database database){
        formFields = new ArrayList<>();
        waysOfPayment = new ArrayList<>();
        CreditCardMethod creditCardMethod = new CreditCardMethod(database);
        waysOfPayment.add(creditCardMethod);
    }

    public String getProviderName() {
        return ProviderName;
    }
    public void pay(Client client, int wayIndex, double amount){
        waysOfPayment.get(wayIndex).pay(client, amount);
    }
    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }
}
