package org.chm.date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.Map;

/**
 * Created by charming on 2017/5/17.
 */
public class JodaTimeTest {

    public static String convertStringUTC(Date javaDate)
    {
        DateTime dateTime = new DateTime(javaDate,DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static Date convertDateFromUTC(String date)
    {
        DateTime dateTime = new DateTime().parse(date, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        return dateTime.toDate();
    }

    public static void main(String[] args) {
        String str = JodaTimeTest.convertStringUTC(new Date());
        System.out.println(str);

        Date date = JodaTimeTest.convertDateFromUTC("2017-05-17T06:58:43.989Z");
        System.out.println(date);
    }

}
