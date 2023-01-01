package com.advancedsoftware.Fawry_System.Controllers;
import com.advancedsoftware.Fawry_System.util.*;
import com.advancedsoftware.Fawry_System.Models.*;


public class CreditCardController{
    private static CreditCardController creditCardController;

    private CreditCardController(){}
    public static CreditCardController getCreditCardController() {
        if (creditCardController == null) {
            creditCardController = new CreditCardController();
        }
        return creditCardController;
    }
    public boolean checkValidCreditCard(CreditCard creditCard){
        if(creditCard == null){
            return false;
        }
        for(int i = 0; i < Database.getDatabase().creditCards.size(); i++){
            if(Database.getDatabase().creditCards.get(i).getCardNumber().equals(creditCard.getCardNumber())){
                return true;
            }
        }
        return false;
    }
    public boolean checkCanPayCreditCard(CreditCard creditCard, double amount){
        for(int i = 0; i < Database.getDatabase().creditCards.size(); i++){
            if(Database.getDatabase().creditCards.get(i).getCardNumber().equals(creditCard.getCardNumber())){
                if(creditCard.getAmount() >= amount) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    int checkExistenceCreditCard(CreditCard creditCard){
        if(creditCard == null){
            return -2;
        }
        for(int i = 0; i < Database.getDatabase().creditCards.size(); i++){
            if(Database.getDatabase().creditCards.get(i).getCardNumber().equals(creditCard.getCardNumber())){
                return i;
            }
        }
        return -1;
    }

}
