public class CashMethod extends PaymentMethod{
    String MethodName = "Cash";

    @Override
    String pay(Client client, double amount) {
        return "Paid Successfully";
    }
}
