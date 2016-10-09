package com.example.gianni.sdpprototype.Responses;

/**
 * Created by Vasil on 8/10/2016.
 */

public class WaitingListResponse extends ResponseType {


    private boolean IsWaitingList;

    public boolean isWaitingList() {
        return IsWaitingList;
    }

    public void setWaitingList(boolean waitingList) {
        IsWaitingList = waitingList;
    }
}
