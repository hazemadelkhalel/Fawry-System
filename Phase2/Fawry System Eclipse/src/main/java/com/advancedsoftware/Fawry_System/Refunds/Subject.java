package com.advancedsoftware.Fawry_System.Refunds;
import com.advancedsoftware.Fawry_System.Models.Account;
import com.advancedsoftware.Fawry_System.Models.Client;
import com.advancedsoftware.Fawry_System.Models.RefundTransaction;

public interface Subject {
    void notify(RefundTransaction refundTransaction, boolean acceptance);
    String subscribe(Account account);
    String unsubscribe(Account account);
}
