package org.chm.date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by charming on 2017/5/17.
 */
public class Test0 {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();

        DateTime dateTime1 = dateTime.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().setCopy(12);

        System.out.println(dateTime1.toString("yyyy-MM-dd"));

        System.out.println(dateTime1.getDayOfWeek());

        LocalDate.now();

        String str="86.64466666";
        BigDecimal bd = new BigDecimal(Double.parseDouble(str));
        System.out.println(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println("=================");
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(df.format(Double.parseDouble(str)));
        System.out.println("=================");
        System.out.println(String.format("%.2f", Double.parseDouble(str)));
        System.out.println("=================");
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(Double.parseDouble(str)));


    }
}
