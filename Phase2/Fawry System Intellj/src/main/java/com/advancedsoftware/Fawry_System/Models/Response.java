package com.advancedsoftware.Fawry_System.Models;

public class Response<T> {
    private boolean status;
    private String message;
    public T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
