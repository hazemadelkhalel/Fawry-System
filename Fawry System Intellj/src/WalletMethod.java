public class WalletMethod extends PaymentMethod{
    String MethodName = "Wallet";
    WalletMethod(Database database){
        this.database = database;
    }

    @Override
    String pay(Client client, double amount) {
        if(client.getWallet() >= amount){
            client.setWallet(client.getWallet() - amount);
            database.accounts.set(client.getAccountID(), client);
            return "Paid Successfully";
        }
        else{
            return "There is no enough money in the wallet";
        }
    }
}
