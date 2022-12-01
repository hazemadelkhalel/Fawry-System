public abstract class PaymentMethod {

    Database database;
    String MethodName;

    abstract String pay(Client client, double amount);

    public void setMethodName(String methodName) {
        MethodName = methodName;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public String getMethodName() {
        return MethodName;
    }
}
