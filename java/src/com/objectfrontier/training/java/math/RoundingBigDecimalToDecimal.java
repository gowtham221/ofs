// Write a Java program to round a BigDecimal number to specified decimals.

package com.objectfrontier.training.java.math;

import java.math.BigDecimal;
import java.util.Scanner;

public class RoundingBigDecimalToDecimal {

 private static Scanner scanner;

public static void main(String[] args) {

     scanner = new Scanner(System.in);
     String input = scanner.next();
     BigDecimal bigDecimalValue = new BigDecimal(input);

     // Rounding down
     System.out.println(bigDecimalValue.setScale(2, BigDecimal.ROUND_DOWN));

     // Rounding down
     System.out.println(bigDecimalValue.setScale(2, BigDecimal.ROUND_UP));
 }

}
