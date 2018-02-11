package org.chm.date;


import org.joda.time.DateTime;

import java.awt.*;
import java.time.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by charming on 2017/5/18.
 */
public class Java8Time {
    public static void main(String[] args) {

        //now of from

        LocalDate date = LocalDate.now();
        LocalDate date1 = LocalDate.of(2018, 4, 12);
        date.isAfter(date1);



        Period period = Period.between(date, date1);
        System.out.println(period.getMonths());

        //本地utc时间 加上了时区
        System.out.println(LocalDateTime.now());
        //utc时间
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant().toString());

        YearMonth yearMonth = YearMonth.from(LocalDate.now());
        yearMonth.isLeapYear();


        MonthDay monthDay = MonthDay.parse("--05-18");
        MonthDay monthDay1 = MonthDay.from(LocalDate.now());
        System.out.println(monthDay.getMonthValue());
        if (monthDay.equals(monthDay1))
        {
            System.out.println("日期相同");
        }else {
            System.out.println("日期不同");
        }


        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.toString());

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());

        Set<String> set = ZoneId.getAvailableZoneIds();
//        set.forEach(System.out::println);
        Set<String> treeSet = new TreeSet<String>(){
            {
                addAll(set);
            }
        };
        treeSet.forEach(System.out::println);

        LocalDateTime localDateTime1= LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(localDateTime1.toString());

//        DateTime dateTime = DateTime.now();
//        System.out.println(dateTime.toString());



    }
}
