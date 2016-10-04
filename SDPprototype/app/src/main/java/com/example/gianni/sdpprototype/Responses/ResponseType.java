package com.example.gianni.sdpprototype.Responses;

/**
 * Created by Vasil on 5/10/2016.
 */

public class ResponseType
{
    private Boolean IsSuccess;
    private String DisplayMessage;

    public Boolean getSuccess() {
        return IsSuccess;
    }

    public void setSuccess(Boolean success) {
        IsSuccess = success;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.DisplayMessage = displayMessage;
    }
}
