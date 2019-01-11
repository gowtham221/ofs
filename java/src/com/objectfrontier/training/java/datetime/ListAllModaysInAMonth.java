// For a given month of the current year, lists all of the Mondays in that month with date in mm-dd-yyyy format

package com.objectfrontier.training.java.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ListAllModaysInAMonth {

    private Scanner scanner;

    public static void main(String[] args) {

        ListAllModaysInAMonth listAllMonths = new ListAllModaysInAMonth();
        listAllMonths.listAllMondays();
    }

    private void listAllMondays() {

        Year year = Year.now();
        scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        YearMonth yearMonth = YearMonth.of(year.getValue(), month);
        int length = yearMonth.lengthOfMonth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        for (int i = 1; i < length; i++) {

            LocalDate day = yearMonth.atDay(i);
            if (day.getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.println(day.format(formatter));
            }
        }
    }
}
