import java.util.ArrayList;

public class Provider {
    String ProviderName;
    ArrayList<FormField> formFields;
    Provider(){
        formFields = new ArrayList<>();
    }

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }
}
