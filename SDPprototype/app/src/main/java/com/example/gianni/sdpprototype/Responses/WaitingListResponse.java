package com.example.gianni.sdpprototype.Responses;

import com.example.gianni.sdpprototype.Models.Waiting;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vasil on 16/10/2016.
 */

public class WaitingListResponse extends ResponseType {
    @SerializedName("waitings")
    private List<Waiting> waitings;


    public List<Waiting> getWaitings() {
        return waitings;
    }

    public void setWaitings(List<Waiting> waitings) {
        this.waitings = waitings;
    }
}
