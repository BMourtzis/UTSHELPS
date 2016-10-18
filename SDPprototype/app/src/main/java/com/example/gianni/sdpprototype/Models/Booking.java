package com.example.gianni.sdpprototype.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.gianni.sdpprototype.RestService.RestClient;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Vasil on 28/9/2016.
 */
public class Booking implements Parcelable, Comparator<Booking>, Comparable<Booking>
{
    @SerializedName("BookingId")
    public Integer bookingId;
    @SerializedName("workshopID")
    public Integer workshopID;
    @SerializedName("studentID")
    public String studentID;
    @SerializedName("topic")
    public String topic;
    @SerializedName("description")
    public String description;
    @SerializedName("targetingGroup")
    public String targetingGroup;
    @SerializedName("campusID")
    public Integer campusID;
    @SerializedName("starting")
    public String starting;
    @SerializedName("ending")
    public String ending;
    @SerializedName("maximum")
    public Integer maximum;
    @SerializedName("cutoff")
    public Integer cutoff;
    @SerializedName("canceled")
    public Integer canceled;
    @SerializedName("attended")
    public Integer attended;
    @SerializedName("WorkShopSetID")
    public Integer workShopSetID;
    @SerializedName("type")
    public String type;
    @SerializedName("reminder_num")
    public Integer reminderNum;
    @SerializedName("reminder_sent")
    public Integer reminderSent;
    @SerializedName("WorkshopArchived")
    public String workshopArchived;
    @SerializedName("BookingArchived")
    public String bookingArchived;

    public String getBookingArchived() {
        return bookingArchived;
    }

    public void setBookingArchived(String bookingArchived) {
        this.bookingArchived = bookingArchived;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getWorkshopID() {
        return workshopID;
    }

    public void setWorkshopID(Integer workshopID) {
        this.workshopID = workshopID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetingGroup() {
        return targetingGroup;
    }

    public void setTargetingGroup(String targetingGroup) {
        this.targetingGroup = targetingGroup;
    }

    public Integer getCampusID() {
        return campusID;
    }

    public void setCampusID(Integer campusID) {
        this.campusID = campusID;
    }

    public String getStarting() {
        return getDate(starting);
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public String getEnding() {
        return getDate(ending);
    }

    public void setEnding(String ending) {

        this.ending = ending;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public Integer getCutoff() {
        return cutoff;
    }

    public void setCutoff(Integer cutoff) {
        this.cutoff = cutoff;
    }

    public Integer getCanceled() {
        return canceled;
    }

    public void setCanceled(Integer canceled) {
        this.canceled = canceled;
    }

    public Integer getAttended() {
        return attended;
    }

    public void setAttended(Integer attended) {
        this.attended = attended;
    }

    public Integer getWorkShopSetID() {
        return workShopSetID;
    }

    public void setWorkShopSetID(Integer workShopSetID) {
        this.workShopSetID = workShopSetID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getReminderNum() {
        return reminderNum;
    }

    public void setReminderNum(Integer reminderNum) {
        this.reminderNum = reminderNum;
    }

    public Integer getReminderSent() {
        return reminderSent;
    }

    public void setReminderSent(Integer reminderSent) {
        this.reminderSent = reminderSent;
    }

    public String getWorkshopArchived() {
        return workshopArchived;
    }

    public void setWorkshopArchived(String workshopArchived) {
        this.workshopArchived = workshopArchived;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(bookingId);
        parcel.writeInt(workshopID);
        parcel.writeString(studentID);
        parcel.writeString(topic);
        parcel.writeString(description);
        parcel.writeString(targetingGroup);
        parcel.writeInt(campusID);
        parcel.writeString(starting);
        parcel.writeString(ending);
        parcel.writeInt(maximum);
        parcel.writeInt(cutoff);
        parcel.writeInt(canceled);
        parcel.writeInt(attended);
        parcel.writeInt(workShopSetID);
        parcel.writeString(type);
        parcel.writeInt(reminderNum);
        parcel.writeInt(reminderSent);
        parcel.writeString(workshopArchived);
        parcel.writeString(bookingArchived);
    }

    @Override
    public int compareTo(Booking booking) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date datethis = new Date();
        Date dateother = new Date();
        try
        {
            datethis = format.parse(this.ending);
            dateother = format.parse(booking.ending);
        }
        catch(Exception e)
        {

        }

        return  dateother.compareTo(datethis);
    }

    @Override
    public int compare(Booking booking, Booking t1) {
        return 0;
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

        String s1 = strFormat.format(date);
        return s1;
    }
}
