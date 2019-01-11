// For a given year, print the length of each month within that year.
package com.objectfrontier.training.java.datetime;

import java.time.YearMonth;
import java.util.Scanner;

public class MonthLength {

    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        System.out.println("Enter the Year");
        int givenYear = scanner.nextInt();
        System.out.println("Entered Year : " + givenYear);

        for(int i=1; i<=12;i++) {

            YearMonth year = YearMonth.of(givenYear, i);
            int DaysOfMonth = year.lengthOfMonth();
            System.out.println(year.getMonth().name() +": " + DaysOfMonth);

        }
    }
}


