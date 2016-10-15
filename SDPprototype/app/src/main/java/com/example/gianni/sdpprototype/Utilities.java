package com.example.gianni.sdpprototype;

import java.util.Locale;

/**
 * Created by Vasil on 16/10/2016.
 */

public class Utilities {

    public static String getFormattedDate(int day, int month, int year) {
        String yearStr = String.format(Locale.UK, "%04d", year);
        String monthStr = String.format(Locale.UK, "%02d", month);
        String dayStr = String.format(Locale.UK, "%02d", day);
        return yearStr + "-" + monthStr + "-" + dayStr;
    }
}
