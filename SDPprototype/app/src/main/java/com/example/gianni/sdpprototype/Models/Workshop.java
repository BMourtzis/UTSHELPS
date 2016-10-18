package com.example.gianni.sdpprototype.Models;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Vasil on 28/9/2016.
 */

public class Workshop
{
    @SerializedName("WorkshopId")
    private Integer workshopId;
    @SerializedName("topic")
    private String topic;
    @SerializedName("description")
    private String description;
    @SerializedName("targetingGroup")
    private String targetingGroup;
    @SerializedName("campus")
    private String campus;
    @SerializedName("StartDate")
    private String startDate;
    @SerializedName("EndDate")
    private String endDate;
    @SerializedName("maximum")
    private Integer maximum;
    @SerializedName("WorkShopSetID")
    private Integer workShopSetID;
    @SerializedName("cutoff")
    private Integer cutoff;
    @SerializedName("type")
    private String type;
    @SerializedName("reminder_num")
    private Integer reminderNum;
    @SerializedName("reminder_sent")
    private Integer reminderSent;
    @SerializedName("DaysOfWeek")
    private String daysOfWeek;
    @SerializedName("BookingCount")
    private Integer bookingCount;
    @SerializedName("archived")
    private String archived;

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
     * The topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     *
     * @param topic
     * The topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The targetingGroup
     */
    public String getTargetingGroup() {
        return targetingGroup;
    }

    /**
     *
     * @param targetingGroup
     * The targetingGroup
     */
    public void setTargetingGroup(String targetingGroup) {
        this.targetingGroup = targetingGroup;
    }

    /**
     *
     * @return
     * The campus
     */
    public String getCampus() {
        return campus;
    }

    /**
     *
     * @param campus
     * The campus
     */
    public void setCampus(String campus) {
        this.campus = campus;
    }

    /**
     *
     * @return
     * The startDate
     */
    public String getStartDate() {
        return getDate(startDate);
    }

    /**
     *
     * @param startDate
     * The StartDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     * The endDate
     */
    public String getEndDate() {
        return getDate(endDate);
    }

    /**
     *
     * @param endDate
     * The EndDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     * The maximum
     */
    public Integer getMaximum() {
        return maximum;
    }

    /**
     *
     * @param maximum
     * The maximum
     */
    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    /**
     *
     * @return
     * The workShopSetID
     */
    public Integer getWorkShopSetID() {
        return workShopSetID;
    }

    /**
     *
     * @param workShopSetID
     * The WorkShopSetID
     */
    public void setWorkShopSetID(Integer workShopSetID) {
        this.workShopSetID = workShopSetID;
    }

    /**
     *
     * @return
     * The cutoff
     */
    public Integer getCutoff() {
        return cutoff;
    }

    /**
     *
     * @param cutoff
     * The cutoff
     */
    public void setCutoff(Integer cutoff) {
        this.cutoff = cutoff;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The reminderNum
     */
    public Integer getReminderNum() {
        return reminderNum;
    }

    /**
     *
     * @param reminderNum
     * The reminder_num
     */
    public void setReminderNum(Integer reminderNum) {
        this.reminderNum = reminderNum;
    }

    /**
     *
     * @return
     * The reminderSent
     */
    public Integer getReminderSent() {
        return reminderSent;
    }

    /**
     *
     * @param reminderSent
     * The reminder_sent
     */
    public void setReminderSent(Integer reminderSent) {
        this.reminderSent = reminderSent;
    }

    /**
     *
     * @return
     * The daysOfWeek
     */
    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    /**
     *
     * @param daysOfWeek
     * The DaysOfWeek
     */
    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    /**
     *
     * @return
     * The bookingCount
     */
    public Integer getBookingCount() {
        return bookingCount;
    }

    /**
     *
     * @param bookingCount
     * The BookingCount
     */
    public void setBookingCount(Integer bookingCount) {
        this.bookingCount = bookingCount;
    }

    /**
     *
     * @return
     * The archived
     */
    public String getArchived() {
        return archived;
    }

    /**
     *
     * @param archived
     * The archived
     */
    public void setArchived(String archived) {
        this.archived = archived;
    }

    private String getDate(String datetime)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat strFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();

        try
        {
            date = format.parse(datetime);
        }
        catch(Exception e)
        {

        }
        return strFormat.format(date);
    }

    public String getRemaining()
    {
        if(getCutoff() == null)
        {
            return "N/A";
        }
        else
        {
            int i = 0;
            try
            {
                i = cutoff - bookingCount;
                if(i<0)
                {
                    i = 0;
                }
            }
            catch(Exception e)
            {

            }
            return ""+i;
        }
    }
}
