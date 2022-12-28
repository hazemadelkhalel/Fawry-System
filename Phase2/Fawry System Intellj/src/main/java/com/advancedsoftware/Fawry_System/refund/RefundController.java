package com.advancedsoftware.Fawry_System.refund;
import java.util.ArrayList;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.controller.*;
import com.advancedsoftware.Fawry_System.model.*;
import com.advancedsoftware.Fawry_System.service.*;

public class RefundController extends FawryController {
    public RefundController(Database database){
        this.database = database;
    }

    public String addRefundRequest(Admin admin, Transaction transaction){
        RefundRequest refundRequest = new RefundRequest(transaction);
        database.refunds.add(refundRequest);
        admin.notifications.add("New Refund Request");
        return "Added Successfully";
    }

    public boolean applyApproval(Client client, boolean acceptance, RefundRequest refundRequest) {
        database.refunds.remove(refundRequest);
        refundRequest.notify(client, acceptance);
        return acceptance;
    }

    ArrayList<Transaction> listAllTransaction(Client client, Service service) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        for(int i = 0; i < client.getTransactions().size(); i++){
            if(client.getTransactions().get(i).getService().getServiceName().equals(service.getServiceName())){
                transactions.add(client.getTransactions().get(i));
            }
        }
        return transactions;
    }
}