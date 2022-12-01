public class CashMethod extends PaymentMethod{
    CashMethod(Database database){
        this.database = database;
        MethodName = "Cash";
    }
    @Override
    String pay(Client client, double amount) {
        return "Paid Successfully";
    }
}
