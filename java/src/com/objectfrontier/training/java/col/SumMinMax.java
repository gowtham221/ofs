//sum/Max/Min
//
//    Consider a following code snippet:
//        List<Integer> randomNumbers = Array.asList( {1, 6, 10, 25, 78} );
//    Find the sum of all the numbers in the list using java.util.Stream
//    Find the maximum of all the numbers in the list using java.util.Stream
//    Find the minimum of all the numbers in the list using java.util.Stream


package com.objectfrontier.training.java.col;

import java.util.Arrays;
import java.util.List;

// class SumMinMax {
public class SumMinMax {

    public static void main(String[] args) {

        Integer array[] = { 1, 6, 10, 25, 78 };
        List<Integer> randomNumbers = Arrays.asList(array);

        // int sum = calculateSum();
        int sum = randomNumbers.stream()
                               .mapToInt(e -> e.intValue())
                               .sum();

        // print(sum);
        System.out.println(sum);

        // int minValue = findMinValue();
        int minValue = randomNumbers.stream()
                                    .mapToInt(e -> e.intValue())
                                    .min()
                                    .getAsInt();

        // print(minValue);
        System.out.println(minValue);

        // int maxValue = findMaxValue();
        int maxValue = randomNumbers.stream()
                                    .mapToInt(e -> e.intValue())
                                    .max()
                                    .getAsInt();

        // print(maxValue);
        System.out.println(maxValue);
    }

}
