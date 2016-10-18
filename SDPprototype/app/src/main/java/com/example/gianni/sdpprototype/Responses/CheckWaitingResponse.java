package com.example.gianni.sdpprototype.Responses;

/**
 * Created by Vasil on 8/10/2016.
 */

public class CheckWaitingResponse extends ResponseType {


    private boolean IsWaitListed;

    public boolean isWaitingList() {
        return IsWaitListed;
    }

    public void setWaitingList(boolean waitingList) {
        IsWaitListed = waitingList;
    }
}
