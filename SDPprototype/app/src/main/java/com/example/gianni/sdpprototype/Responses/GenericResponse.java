package com.example.gianni.sdpprototype.Responses;

/**
 * Created by Vasil on 28/9/2016.
 */

public class GenericResponse<T>
{
    private T Result;
    private Boolean IsSuccess;
    private String DisplayMessage;

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.DisplayMessage = displayMessage;
    }

    public Boolean getSuccess() {
        return IsSuccess;
    }

    public void setSuccess(Boolean success) {
        IsSuccess = success;
    }

    public T getResult() {
        return Result;
    }

    public void setResult(T result) {
        Result = result;
    }
}
