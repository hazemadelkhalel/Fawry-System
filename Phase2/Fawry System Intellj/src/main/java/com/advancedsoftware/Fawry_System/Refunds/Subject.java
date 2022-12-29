package com.advancedsoftware.Fawry_System.Refunds;
import com.advancedsoftware.Fawry_System.Models.Client;

public interface Subject {
    void notify(Client client, boolean acceptance);
    void subscribe(Client client);
    void unsubscribe(Client client);
}
