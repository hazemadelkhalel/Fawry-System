package com.advancedsoftware.Fawry_System.Models;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo.*;


@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Client.class, name = "client"),
        @JsonSubTypes.Type(value = Admin.class, name = "admin")
})
abstract public class Account {
    String username, email, password;
    int AccountID;

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", AccountID=" + AccountID +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public int getAccountID() {
        return AccountID;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    abstract public void update(boolean acceptance, PaymentTransaction paymentTransaction);

}
