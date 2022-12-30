package com.advancedsoftware.Fawry_System.Refunds;
import java.util.ArrayList;
import java.util.List;

import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.util.Database;

public class RefundRequest implements Subject{
    public PaymentTransaction paymentTransaction;
    List<Account> accounts;
    RefundRequest(PaymentTransaction paymentTransaction){
        this.paymentTransaction = paymentTransaction;
        accounts = new ArrayList<>();
    }
    @Override
    public void notify(Client client, boolean acceptance) {
        boolean isSubscribed = false;
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i) == client){
                client.update(acceptance, paymentTransaction, true);
                isSubscribed = true;
                break;
            }
        }
        if(!isSubscribed){
            Database.getDatabase().paymentTransactions.get(client).remove(paymentTransaction);
            client.update(acceptance, paymentTransaction, false);
        }
    }

    @Override
    public void subscribe(Client client) {
        accounts.add(client);
    }

    @Override
    public void unsubscribe(Client client) {
        accounts.remove(client);
    }
}
