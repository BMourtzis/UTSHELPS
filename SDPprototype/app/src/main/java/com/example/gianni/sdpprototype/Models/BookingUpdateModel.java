package com.example.gianni.sdpprototype.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vasil on 16/10/2016.
 */

public class BookingUpdateModel {

    @SerializedName("WorkshopId")
    private Integer workshopId;
    @SerializedName("StudentId")
    private String studentId;
    @SerializedName("Canceled")
    private Integer canceled;
    @SerializedName("Attended")
    private Integer attended;
    @SerializedName("UserId")
    private Integer userId;
    @SerializedName("Notes")
    private String notes;

    public BookingUpdateModel(int workshopId, String studentId)
    {
        this.workshopId = workshopId;
        this.studentId = studentId;
        this.userId = Integer.parseInt(studentId);
        this.attended = 1;
    }

    /**
     *
     * @return
     * The workshopId
     */
    public Integer getWorkshopId() {
        return workshopId;
    }

    /**
     *
     * @param workshopId
     * The WorkshopId
     */
    public void setWorkshopId(Integer workshopId) {
        this.workshopId = workshopId;
    }

    /**
     *
     * @return
     * The studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     *
     * @param studentId
     * The StudentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     *
     * @return
     * The canceled
     */
    public Integer getCanceled() {
        return canceled;
    }

    /**
     *
     * @param canceled
     * The Canceled
     */
    public void setCanceled(Integer canceled) {
        this.canceled = canceled;
    }

    /**
     *
     * @return
     * The attended
     */
    public Integer getAttended() {
        return attended;
    }

    /**
     *
     * @param attended
     * The Attended
     */
    public void setAttended(Integer attended) {
        this.attended = attended;
    }

    /**
     *
     * @return
     * The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The UserId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     * The Notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
