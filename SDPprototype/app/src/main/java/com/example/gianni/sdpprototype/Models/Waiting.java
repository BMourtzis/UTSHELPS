package com.example.gianni.sdpprototype.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vasil on 16/10/2016.
 */

public class Waiting {
    @SerializedName("id")
    private Integer id;
    @SerializedName("workshopID")
    private Integer workshopID;
    @SerializedName("studentID")
    private String studentID;
    @SerializedName("priority")
    private boolean priority;
    @SerializedName("archived")
    private boolean archived;

    public Waiting() {}

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The workshopID
     */
    public Integer getWorkshopID() {
        return workshopID;
    }

    /**
     *
     * @param workshopID
     * The workshopID
     */
    public void setWorkshopID(Integer workshopID) {
        this.workshopID = workshopID;
    }

    /**
     *
     * @return
     * The studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     *
     * @param studentID
     * The studentID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     *
     * @return
     * The priority
     */
    public boolean getPriority() {
        return priority;
    }

    /**
     *
     * @param priority
     * The priority
     */
    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    /**
     *
     * @return
     * The archived
     */
    public boolean getArchived() {
        return archived;
    }

    /**
     *
     * @param archived
     * The archived
     */
    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
