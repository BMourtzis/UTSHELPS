package com.example.gianni.sdpprototype;

import com.example.gianni.sdpprototype.Models.Booking;

/**
 * Created by Vasil_000 on 28/9/2016.
 */
public interface FragmentCallback {

    void onBookingItemSelected(Booking booking);

    void onWorkshopSetItemSelected(int id);

    void onWorkshopItemSelected(int id);

    void onWorkshopSearchIconSelected();

    void onSearchWorkshops(int campusId, int wsId, String StartingBegin, String StartingEnd);

    void onUpdateStudent();

    void StudentUpdated();
}
