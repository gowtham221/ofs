// ISO standard - Format and print current date into ISO date format

package com.objectfrontier.training.java.datetime;

import java.time.LocalDate;

public class IsoDateFormat {

    public static void main(String[] args) {

//        DateFormat isodate = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss.SSSZ");
        LocalDate today = LocalDate.now();
        System.out.println("Current DateTime is : " + today);
//        System.out.println(today.format(format));
    }
}

