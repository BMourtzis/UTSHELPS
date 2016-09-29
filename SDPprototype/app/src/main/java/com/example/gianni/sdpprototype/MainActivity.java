package com.example.gianni.sdpprototype;

import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gianni.sdpprototype.Fragments.AboutFragment;
import com.example.gianni.sdpprototype.Fragments.AccountFragment;
import com.example.gianni.sdpprototype.Fragments.BookingFragment;
import com.example.gianni.sdpprototype.Fragments.BookingListFragment;
import com.example.gianni.sdpprototype.Fragments.CheckAttendanceFragment;
import com.example.gianni.sdpprototype.Fragments.HistoryFragment;
import com.example.gianni.sdpprototype.Fragments.RemindersFragment;
import com.example.gianni.sdpprototype.Fragments.UpcomingSessionsFragment;
import com.example.gianni.sdpprototype.Fragments.WorkshopListFragment;
import com.example.gianni.sdpprototype.Models.Booking;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentCallback {
    private NfcAdapter mNfcAdapter;
    private PendingIntent mNfcPendingIntent;
    private IntentFilter[] mNdefExchangeFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new BookingListFragment()).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        mNfcPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,
                getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TOP), 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNfcAdapter.enableForegroundDispatch(this, mNfcPendingIntent,
                mNdefExchangeFilters, null);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mNfcAdapter != null) mNfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        NdefMessage[] message = null;
        Parcelable[] msg = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        FragmentManager fragmentManager = getFragmentManager();

        if (msg != null) {
            message = new NdefMessage[msg.length];
            for (int i = 0; i < msg.length; i++) {
                message[i] = (NdefMessage) msg[i];
            }
        }

        String parentID="";
        byte[] payload = message[0].getRecords()[0].getPayload();

        for (int temp = 3; temp < payload.length; temp++) {
            parentID += (char) payload[temp];
        }
        Toast.makeText(getApplicationContext(), parentID, Toast.LENGTH_SHORT).show();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new CheckAttendanceFragment()).commit();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        switch (id)
        {
            case R.id.nav_bookings:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new BookingListFragment()).commit();
                break;
            case R.id.nav_upcoming_sessions:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new UpcomingSessionsFragment()).commit();
                break;
            case R.id.nav_reminders:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new RemindersFragment()).commit();
                break;
            case R.id.nav_history:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new HistoryFragment()).commit();
                break;
            case R.id.nav_account:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new AccountFragment()).commit();
                break;
            case R.id.nav_about:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new AboutFragment()).commit();
                break;
            case R.id.nav_check_attendance:
                fragmentManager.beginTransaction().replace(R.id.content_frame, new CheckAttendanceFragment()).commit();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBookingItemSelected(Booking booking) {
        FragmentManager fragmentManager = getFragmentManager();

        BookingFragment bookingFragment = new BookingFragment();
        Bundle args = new Bundle();
        args.putParcelable("booking", booking);
        bookingFragment.setArguments(args);

        fragmentManager.beginTransaction().replace(R.id.content_frame, bookingFragment).commit();
    }

    @Override
    public void onWorkshopSetItemSelected(int id) {
        FragmentManager fragmentManager = getFragmentManager();

        WorkshopListFragment workshopListFragment = new WorkshopListFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        workshopListFragment.setArguments(args);

        fragmentManager.beginTransaction().replace(R.id.content_frame, workshopListFragment).commit();
    }
}
