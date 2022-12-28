package com.advancedsoftware.Fawry_System.payment;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.controller.*;
import com.advancedsoftware.Fawry_System.payment.*;
import com.advancedsoftware.Fawry_System.model.*;
public class CreditCardMethod extends PaymentMethod{
    public CreditCardMethod(Database database){
        this.database = database;
        MethodName = "Credit Card";
    }
    @Override
    public String pay(Client client, double amount) {
        CreditCardController creditCardController = new CreditCardController(database);
        if(creditCardController.checkValidCreditCard(client.creditCard)){
            if(creditCardController.checkCanPayCreditCard(client.getCreditCard(), amount)){
                CreditCard creditCard = client.creditCard;
                creditCard.setAmount(creditCard.getAmount() - amount);
                client.setCreditCard(creditCard);
                return "Paid Successfully";
            }
            else{
                return "There is no enough money to pay this service";
            }
        }
        else{
            return "There is no credit card with this information";
        }
    }
    public String addFunds(Client client, double amount){
        CreditCard creditCard = client.getCreditCard();
        CreditCardController creditCardController = new CreditCardController(database);
        if(creditCardController.checkValidCreditCard(client.creditCard)){
            if(creditCardController.checkCanPayCreditCard(creditCard, amount)){
                Transaction transaction = new Transaction(client, null, amount, -1);
                database.addWalletTransaction.add(transaction);
                creditCard.setAmount(creditCard.getAmount() - amount);
                client.setWallet(client.getWallet() + amount);
                client.setCreditCard(creditCard);
                database.accounts.set(client.getAccountID(), client);
                return "Funds Added Successfully";
            }
            else{
                return "There is no enough money to add funds";
            }
        }
        else{
            return "There is no credit card with this information";
        }
    }
}
