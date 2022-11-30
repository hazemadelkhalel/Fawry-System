
public class Transaction {
    Client client;
    String CategoryService;
    int numberOfService;
    double amount;
    Transaction(Client client, String CategoryService, int numberOfService, double amount){
        this.client = client;
        this.CategoryService = CategoryService;
        this.numberOfService = numberOfService;
        this.amount = amount;
    }

}
