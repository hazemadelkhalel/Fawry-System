package com.advancedsoftware.Fawry_System.refund;
import com.advancedsoftware.Fawry_System.model.Client;

import java.util.ArrayList;

public interface Subject {
    void notify(Client client, boolean acceptance);
    void subscribe(Client client);
    void unsubscribe(Client client);
}
