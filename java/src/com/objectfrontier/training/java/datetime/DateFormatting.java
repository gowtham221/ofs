//Formatting current date to following formats: 2001-07-04T12:08:56.235-0700 and 2001.07.04 at 12:08:56 PDT
/**
 *
 */
package com.objectfrontier.training.java.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatting {

    public static void main(String[] args) {

        DateFormat date1 = new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        DateFormat date2 = new SimpleDateFormat ("yyyy.MM.dd 'at' HH:mm:ss z");
        Date today = new Date();
        System.out.println(date1.format(today));
        System.out.println(date2.format(today));
    }
}

