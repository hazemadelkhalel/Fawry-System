package com.advancedsoftware.Fawry_System.Refunds;
import java.util.ArrayList;

import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Models.*;
import com.advancedsoftware.Fawry_System.Services.*;

public class RefundController {
    private static RefundController refundController;

    private RefundController(){}
    public static RefundController getRefundController() {
        if (refundController == null) {
            refundController = new RefundController();
        }
        return refundController;
    }

    public String addRefundRequest(Admin admin, Transaction transaction){
        RefundRequest refundRequest = new RefundRequest(transaction);
        Database.getDatabase().refunds.add(refundRequest);
        admin.notifications.add("New Refund Request");
        return "Added Successfully";
    }

    public boolean applyApproval(Client client, boolean acceptance, RefundRequest refundRequest) {
        Database.getDatabase().refunds.remove(refundRequest);
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