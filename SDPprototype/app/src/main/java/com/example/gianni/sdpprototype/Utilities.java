package com.example.gianni.sdpprototype;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Vasil on 16/10/2016.
 */

public class Utilities {

    public static String getFormattedDate(int day, int month, int year) {
        String yearStr = String.format(Locale.UK, "%04d", year);
        String monthStr = String.format(Locale.UK, "%02d", month);
        String dayStr = String.format(Locale.UK, "%02d", day);
        return dayStr+"/"+monthStr+"/"+yearStr;
    }

    public static String getStringDateUS(Date date)
    {
        SimpleDateFormat spf = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = spf.format(date);
        return formattedDate;
    }
}
