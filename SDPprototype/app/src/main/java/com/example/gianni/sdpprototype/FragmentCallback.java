package com.example.gianni.sdpprototype;

import com.example.gianni.sdpprototype.Models.Booking;

/**
 * Created by Vasil_000 on 28/9/2016.
 */
public interface FragmentCallback {

    public void onBookingItemSelected(Booking booking);

    public void onWorkshopSetItemSelected(int id);

    public void onWorkshopItemSelected(int id);

    public void onWorkshopSearchIconSelected();

    public void onSearchWorkshops(int campusId, int wsId, String StartingBegin, String StartingEnd);
}
