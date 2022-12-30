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

    public String addRefundRequest(PaymentTransaction paymentTransaction){
        RefundTransaction refundRequest = new RefundTransaction(paymentTransaction);
        for(int i = 0; i < Database.getDatabase().refunds.size(); i++){
            if(Database.getDatabase().refunds.get(i).getPaymentTransaction() == paymentTransaction){
                return "The refund request for this transaction already in queue";
            }
        }
        Database.getDatabase().refunds.add(refundRequest);
        for(int i = 0; i < Database.getDatabase().accounts.size(); i++){
            if(Database.getDatabase().accounts.get(i) instanceof Admin){
                Database.getDatabase().notifications.get(Database.getDatabase().accounts.get(i)).add("New Refund Request");
            }
        }
        return "Refund Request added successfully";
    }

    public String applyApproval(RefundTransaction refundTransaction, boolean acceptance) {
        Database.getDatabase().refunds.remove(refundTransaction);
        RefundRequestManager.getRefundRequestManager().notify(refundTransaction, acceptance);
        for(int i = 0; i < Database.getDatabase().accounts.size(); i++){
            if(Database.getDatabase().accounts.get(i) instanceof Admin){
                Database.getDatabase().notifications.get( Database.getDatabase().accounts.get(i)).remove(0);
            }
        }
        String result = "The refund request has been ";
        if(acceptance){
            result += "accepted";
        }
        else{
            result += "refused";
        }
        return result;
    }

//    ArrayList<PaymentTransaction> listAllTransaction(Client client, Service service) {
//        ArrayList<PaymentTransaction> paymentTransactions = new ArrayList<>();
//        ArrayList<Transaction> transactions = Database.getDatabase().transaction.get(client);
//        for(int i = 0; i < transactions.size(); i++){
//            if(transactions)
//            if(transactions.get(i).getService().getServiceName().equals(service.getServiceName())){
//                paymentTransactions.add(client.getTransactions().get(i));
//            }
//        }
//        return paymentTransactions;
//    }
}