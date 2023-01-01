package com.advancedsoftware.Fawry_System.Payments;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Controllers.*;
import com.advancedsoftware.Fawry_System.Models.*;
public class CreditCardMethod extends PaymentMethod{
    private static CreditCardMethod creditCardMethod;

    private CreditCardMethod(){
        MethodName = "Credit Card";
    }
    public static CreditCardMethod getCreditCardMethod() {
        if (creditCardMethod == null) {
            creditCardMethod = new CreditCardMethod();
        }
        return creditCardMethod;
    }

    @Override
    public String pay(Client client, double amount) {
        CreditCardController creditCardController = CreditCardController.getCreditCardController();
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
        CreditCardController creditCardController = CreditCardController.getCreditCardController();
        if(creditCardController.checkValidCreditCard(client.creditCard)){
            if(creditCardController.checkCanPayCreditCard(creditCard, amount)){
                AddToWalletTransaction addToWalletTransaction = new AddToWalletTransaction(client, client.creditCard, amount);
                Database.getDatabase().addToWalletTransactions.get(client).add(addToWalletTransaction);
                creditCard.setAmount(creditCard.getAmount() - amount);
                client.setWallet(client.getWallet() + amount);
                client.setCreditCard(creditCard);
                Database.getDatabase().accounts.set(client.getAccountID(), client);
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
