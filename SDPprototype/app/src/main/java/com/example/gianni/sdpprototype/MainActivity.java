package com.example.gianni.sdpprototype;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gianni.sdpprototype.Fragments.AboutFragment;
import com.example.gianni.sdpprototype.Fragments.AccountFragment;
import com.example.gianni.sdpprototype.Fragments.ProfileFragment;
import com.example.gianni.sdpprototype.Fragments.BookingFragment;
import com.example.gianni.sdpprototype.Fragments.BookingListFragment;
import com.example.gianni.sdpprototype.Fragments.CheckAttendanceFragment;
import com.example.gianni.sdpprototype.Fragments.FAQExamsFragment;
import com.example.gianni.sdpprototype.Fragments.FAQMiscFragment;
import com.example.gianni.sdpprototype.Fragments.FAQProgramFragment;
import com.example.gianni.sdpprototype.Fragments.HistoryFragment;
import com.example.gianni.sdpprototype.Fragments.RemindersFragment;
import com.example.gianni.sdpprototype.Fragments.UpcomingSessionsFragment;
import com.example.gianni.sdpprototype.Fragments.UpdateStudentFragment;
import com.example.gianni.sdpprototype.Fragments.WaitingListFragment;
import com.example.gianni.sdpprototype.Fragments.WorkshopFragment;
import com.example.gianni.sdpprototype.Fragments.WorkshopListFragment;
import com.example.gianni.sdpprototype.Fragments.WorkshopSearchFragment;
import com.example.gianni.sdpprototype.Fragments.WorkshopSearchResultFragment;
import com.example.gianni.sdpprototype.Models.Booking;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentCallback {
    private NfcAdapter mNfcAdapter;
    private PendingIntent mNfcPendingIntent;
    private IntentFilter[] mNdefExchangeFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        View headerView = navigationView.getHeaderView(0);

        TextView emailView =  (TextView) headerView.findViewById(R.id.navigation_header_email);

        SharedPreferences sharedPrefs = getSharedPreferences("utshelps", Context.MODE_PRIVATE);
        String studentId = sharedPrefs.getString("studentId", "error");

        emailView.setText(studentId+"@student.uts.edu.au");


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
        if (mNfcAdapter != null) mNfcAdapter.disableForegroundDispatch(this);
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
        byte[] payload = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);
        FragmentManager fragmentManager = getFragmentManager();

        String serial = getHex(payload);

        Toast.makeText(getApplicationContext(), serial, Toast.LENGTH_SHORT).show();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new CheckAttendanceFragment()).commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_bookings:
                ReplaceFragment(new BookingListFragment());
                break;
            case R.id.nav_upcoming_sessions:
                ReplaceFragment( new UpcomingSessionsFragment());
                break;
            case R.id.nav_waiting:
                ReplaceFragment(new WaitingListFragment());
                break;
            case R.id.nav_reminders:
                ReplaceFragment(new RemindersFragment());
                break;
            case R.id.nav_history:
                ReplaceFragment(new HistoryFragment());
                break;
            case R.id.nav_account:
                ReplaceFragment(new AccountFragment());
                break;
            case R.id.nav_other_drop:
                ReplaceFragment(new AboutFragment());
                break;
            case R.id.nav_check_attendance:
                ReplaceFragment(new CheckAttendanceFragment());
                break;
            case R.id.nav_faq_program:
                ReplaceFragment(new FAQProgramFragment());
                break;
            case R.id.nav_faq_exam:
                ReplaceFragment(new FAQExamsFragment());
                break;
            case R.id.nav_faq_misc:
                ReplaceFragment(new FAQMiscFragment());
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void ReplaceFragment(Fragment replacementFragment)
    {
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, replacementFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBookingItemSelected(Booking booking) {
        BookingFragment bookingFragment = new BookingFragment();
        Bundle args = new Bundle();
        args.putParcelable("booking", booking);
        bookingFragment.setArguments(args);

        ReplaceFragment( bookingFragment);
    }

    @Override
    public void onWorkshopSetItemSelected(int id) {
        WorkshopListFragment workshopListFragment = new WorkshopListFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        workshopListFragment.setArguments(args);

        ReplaceFragment(workshopListFragment);
    }

    @Override
    public void onWorkshopItemSelected(int id) {
        WorkshopFragment workshopFragment = new WorkshopFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        workshopFragment.setArguments(args);

        ReplaceFragment(workshopFragment);
    }

    private String getHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = bytes.length - 1; i >= 0; --i) {
            int b = bytes[i] & 0xff;
            if (b < 0x10)
                sb.append('0');
            sb.append(Integer.toHexString(b));
            if (i > 0) {
                sb.append(":");
            }
        }
        return String.valueOf(sb);
    }

    @Override
    public void onWorkshopSearchIconSelected() {
        WorkshopSearchFragment fragment = new WorkshopSearchFragment();

        ReplaceFragment(fragment);
    }

    @Override
    public void onSearchWorkshops(int campusId, int wsId, String StartingBegin, String StartingEnd) {
        WorkshopSearchResultFragment fragment = new WorkshopSearchResultFragment();

        Bundle args = new Bundle();
        args.putInt("campusId", campusId);
        args.putInt("wsId", wsId);
        args.putString("StartBegin", StartingBegin);
        args.putString("StartEnd", StartingEnd);
        fragment.setArguments(args);

        ReplaceFragment(fragment);
    }

    @Override
    public void onUpdateStudent() {
        UpdateStudentFragment fragment = new UpdateStudentFragment();

        ReplaceFragment(fragment);
    }

    @Override
    public void StudentUpdated() {
        AccountFragment fragment = new AccountFragment();

        ReplaceFragment(fragment);
    }
}
