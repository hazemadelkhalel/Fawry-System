import java.util.ArrayList;

public class Provider {
    String ProviderName;
    ArrayList<FormField> formFields;
    Provider(){
        formFields = new ArrayList<>();
    ArrayList<PaymentMethod> waysOfPayment;
    Provider(String providerName, ArrayList<FormField> formFields, ArrayList<PaymentMethod> waysOfPayment, Database database){
        this.ProviderName = providerName;
        this.formFields = formFields;
        this.waysOfPayment = waysOfPayment;
        CreditCardMethod creditCardMethod = new CreditCardMethod(database);
        waysOfPayment.add(creditCardMethod);
    }
    public String getProviderName() {
        return ProviderName;
    }
    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }
}
