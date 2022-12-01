public abstract class PaymentMethod {

    Database database;
    abstract String pay(Client client, double amount);

}
