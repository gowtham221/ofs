// Date difference - Find the difference between two dates

package com.objectfrontier.training.java.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DateDifference {

    private Scanner scanner;

    public static void main(String[] args) {

        DateDifference dateDifference = new DateDifference();
        LocalDate dateOne = dateDifference.getDate();
        LocalDate dateTwo = dateDifference.getDate();
        Period difference = dateDifference.getDifference(dateOne, dateTwo);
        DateDifference.print(difference);
    }

    private LocalDate getDate() {

        scanner = new Scanner(System.in);
        String input = scanner.next();
        LocalDate date = LocalDate.parse(input);
        return date;
    }

    private Period getDifference(LocalDate dateOne, LocalDate dateTwo) {

        Period difference = Period.between(dateOne, dateTwo);
        return difference;
    }

    private static void print(Period difference) {
        System.out.println(difference.getYears() + "-" + difference.getMonths() + "-" + difference.getDays());
    }
}
