package com.example.gianni.sdpprototype.Responses;

/**
 * Created by Vasil on 28/9/2016.
 */

public class GenericResponse<T>
{
    private T Results;
    private Boolean isSuccess;
    private Object displayMessage;

    public Object getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(Object displayMessage) {
        this.displayMessage = displayMessage;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public T getResult() {
        return Results;
    }

    public void setResult(T result) {
        Results = result;
    }
}
