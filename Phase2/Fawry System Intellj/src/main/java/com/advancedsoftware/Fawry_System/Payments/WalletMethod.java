package com.advancedsoftware.Fawry_System.Payments;
import com.advancedsoftware.Fawry_System.Models.*;

public class WalletMethod extends PaymentMethod{

    private static WalletMethod walletMethod;

    private WalletMethod(){
        MethodName = "Wallet";
    }
    public static WalletMethod getWalletMethod() {
        if (walletMethod == null) {
            walletMethod = new WalletMethod();
        }
        return walletMethod;
    }
    @Override
    public String pay(Client client, double amount) {
        if(client.getWallet() >= amount){
            client.setWallet(client.getWallet() - amount);
            return "Paid Successfully";
        }
        else{
            return "There is no enough money in the wallet";
        }
    }
}
