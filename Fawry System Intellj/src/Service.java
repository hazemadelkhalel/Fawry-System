import java.util.ArrayList;

public class Service {
    String serviceName;
    ArrayList<Provider> providers;
    Service(){
        providers = new ArrayList<>();
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
