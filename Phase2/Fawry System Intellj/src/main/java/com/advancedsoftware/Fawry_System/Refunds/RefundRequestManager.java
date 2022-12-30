package com.advancedsoftware.Fawry_System.Refunds;
import java.util.ArrayList;
import java.util.List;

import com.advancedsoftware.Fawry_System.Controllers.AccountController;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.util.Database;

public class RefundRequestManager implements Subject{
    private static RefundRequestManager refundRequestManager;

    private RefundRequestManager(){
        accounts = new ArrayList<>();
    }
    public static RefundRequestManager getRefundRequestManager() {
        if (refundRequestManager == null) {
            refundRequestManager = new RefundRequestManager();
        }
        return refundRequestManager;
    }
    List<Account> accounts;
    @Override
    public void notify(RefundTransaction refundTransaction, boolean acceptance) {
        boolean isSubscribed = false;
        Client client = refundTransaction.getPaymentTransaction().getClient();
        PaymentTransaction paymentTransaction = refundTransaction.getPaymentTransaction();
        if(acceptance){
            Database.getDatabase().paymentTransactions.get(client).remove(paymentTransaction);
        }
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i) == client){
                if(acceptance){
                    Database.getDatabase().notifications.get(client).add("Accepted Refund Request of " + paymentTransaction.getService().getServiceName());
                }
                else{
                    Database.getDatabase().notifications.get(client).add("Refused Refund Request");
                }
                client.update(acceptance, paymentTransaction);
                isSubscribed = true;
                break;
            }
        }
        if(!isSubscribed){
            Database.getDatabase().paymentTransactions.get(client).remove(paymentTransaction);
            client.update(acceptance, paymentTransaction);
        }
    }

    @Override
    public String subscribe(Account account) {
        accounts.add(account);
        return "Subscribed Successfully";
    }

    @Override
    public String unsubscribe(Account account) {
        accounts.remove(account);
        return "Unsubscribed Successfully";
    }
}
