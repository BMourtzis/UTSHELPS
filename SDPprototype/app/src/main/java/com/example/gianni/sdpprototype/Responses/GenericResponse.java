package com.example.gianni.sdpprototype.Responses;

/**
 * Created by Vasil on 28/9/2016.
 */

public class GenericResponse<T>
{
    private T Result;
    private Boolean isSuccess;
    private String displayMessage;

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public T getResult() {
        return Result;
    }

    public void setResult(T result) {
        Result = result;
    }
}
