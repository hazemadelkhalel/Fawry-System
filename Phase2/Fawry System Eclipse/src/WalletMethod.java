public class WalletMethod extends PaymentMethod{
    WalletMethod(Database database){
        this.database = database;
        MethodName = "Wallet";
    }
    @Override
    String pay(Client client, double amount) {
        if(client.getWallet() >= amount){
            client.setWallet(client.getWallet() - amount);
            return "Paid Successfully";
        }
        else{
            return "There is no enough money in the wallet";
        }
    }
}
