package utilities_qatek;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String[] returnNextMonth() {
        // Create Date object
        Date dNow = new Date();

        //Create Calendar object for Gregorian Calendar
        Calendar calendar = new GregorianCalendar();
        // Set Calendar object to current date
        calendar.setTime(dNow);

        //Create object for SimpleDateFormat
        // Defining date format to - example: (Aug-2025)
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
        calendar.add(Calendar.MONTH, 1);

        //Generate the date based on the specified calendar data
        String date = sdf.format(calendar.getTime());

        return date.split("-");
    }
}
