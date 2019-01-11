// Print the components of the current date

package com.objectfrontier.training.java.datetime;

import java.time.LocalDate;

public class CurrentDate {

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date is : " + currentDate);

        System.out.println(currentDate.getYear());
        System.out.println(currentDate.getMonthValue());
        System.out.println(currentDate.getDayOfMonth());
        System.out.println(currentDate.getDayOfYear());
        System.out.println(currentDate.getMonth());
        System.out.println(currentDate.getDayOfWeek());
        System.out.println(currentDate.getEra());
        System.out.println(currentDate.lengthOfMonth());
        System.out.println(currentDate.isLeapYear());
        System.out.println(currentDate.lengthOfYear());
        System.out.println(currentDate.toEpochDay());
        System.out.println(currentDate.atStartOfDay());

    }
}
