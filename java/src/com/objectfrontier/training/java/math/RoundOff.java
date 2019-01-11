package com.objectfrontier.training.java.math;

import java.math.BigDecimal;
import java.util.Scanner;

public class RoundOff {

    private static Scanner scanner;

    public static void main(String[] args) {

        BigDecimal firstValue = RoundOff.getBigDecimal();
        BigDecimal secondValue = RoundOff.getBigDecimal();
        BigDecimal minValue = RoundOff.findMinValue(firstValue, secondValue);
        BigDecimal maxValue = RoundOff.findMaxValue(firstValue, secondValue);
        BigDecimal absValue = RoundOff.absoluteValue(firstValue);
        BigDecimal ceilValue = RoundOff.ceilingValue(firstValue);
        BigDecimal floorValue = RoundOff.floorValue(firstValue);
        Double rintValue = RoundOff.rintValue(firstValue);

        System.out.println("The Absolute Value of the first input is " + absValue);
        System.out.println("The Ceiling Value of the first input is " + ceilValue);
        System.out.println("The Floor Value of the first input is " + floorValue);
        System.out.println("The Rint Value of the first input is " + rintValue);
        System.out.println("The minimum value in the given input values is " + minValue);
        System.out.println("The maximum value in the given input values is " + maxValue);
    }

    // Getting BigDecimal Value
    private static BigDecimal getBigDecimal() {

        scanner = new Scanner(System.in);
        String input = scanner.next();
        BigDecimal value = new BigDecimal(input);
        return value;
    }

    // Absolute Value
    private static BigDecimal absoluteValue(BigDecimal firstValue) {

        BigDecimal absValue = firstValue.abs();
        return absValue;
    }

    // Ceiling Value
    private static BigDecimal ceilingValue(BigDecimal firstValue) {

        BigDecimal ceilValue = firstValue.setScale(2, BigDecimal.ROUND_CEILING);
        return ceilValue;
    }

    // Floor Value
    private static BigDecimal floorValue(BigDecimal firstValue) {

        BigDecimal floorValue = firstValue.setScale(2, BigDecimal.ROUND_FLOOR);
        return floorValue;
    }

    // Rint Value
    private static Double rintValue(BigDecimal firstValue) {

        Double rintValue = Math.rint(firstValue.doubleValue());
        return rintValue;
    }

    // Minimum Value
    private static BigDecimal findMinValue(BigDecimal firstValue, BigDecimal secondValue) {

        BigDecimal minValue = firstValue.min(secondValue);
        return minValue;
    }

    // Maximum Value
    private static BigDecimal findMaxValue(BigDecimal firstValue, BigDecimal secondValue) {

        BigDecimal maxValue = firstValue.max(secondValue);
        return maxValue;
    }
}
