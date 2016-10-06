package com.example.gianni.sdpprototype.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vasil on 28/9/2016.
 */

public class Campus {
    @SerializedName("id")
    public Integer id;
    @SerializedName("campus")
    public String campus;
    @SerializedName("archived")
    public boolean archived;

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}
