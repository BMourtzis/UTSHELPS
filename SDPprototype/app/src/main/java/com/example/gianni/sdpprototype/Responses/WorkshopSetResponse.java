package com.example.gianni.sdpprototype.Responses;

import com.example.gianni.sdpprototype.Models.WorkshopSet;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasil on 24/9/2016.
 */

public class WorkshopSetResponse
{
    @SerializedName("Results")
    private List<WorkshopSet> results = new ArrayList<WorkshopSet>();
    @SerializedName("IsSuccess")
    private Boolean isSuccess;
    @SerializedName("DisplayMessage")
    private Object displayMessage;

    /**
     *
     * @return
     * The results
     */
    public List<WorkshopSet> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The Results
     */
    public void setResults(List<WorkshopSet> results) {
        this.results = results;
    }

    /**
     *
     * @return
     * The isSuccess
     */
    public Boolean getIsSuccess() {
        return isSuccess;
    }

    /**
     *
     * @param isSuccess
     * The IsSuccess
     */
    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     *
     * @return
     * The displayMessage
     */
    public Object getDisplayMessage() {
        return displayMessage;
    }

    /**
     *
     * @param displayMessage
     * The DisplayMessage
     */
    public void setDisplayMessage(Object displayMessage) {
        this.displayMessage = displayMessage;
    }
}
