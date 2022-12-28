package com.advancedsoftware.Fawry_System.refund;
import java.util.ArrayList;
import java.util.List;

import com.advancedsoftware.Fawry_System.model.*;

public class RefundRequest implements Subject{
    public Transaction transaction;
    List<Account> accounts;
    RefundRequest(Transaction transaction){
        this.transaction = transaction;
        accounts = new ArrayList<>();
    }
    @Override
    public void notify(Client client, boolean acceptance) {
        boolean isSubscribed = false;
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i) == client){
                client.update(acceptance, transaction, true);
                isSubscribed = true;
                break;
            }
        }
        if(!isSubscribed){
            client.update(acceptance, transaction, false);
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
