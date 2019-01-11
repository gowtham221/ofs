package com.objectfrontier.training.java.base;
public class FibonacciSeries {

    // Fibonacci series using for loop
    private void fibonacciUsingFor(int a, int b, int count) {
        int sum;
        for(int i = 0; i < count; i++) {
            System.out.println(a);
            sum = a + b;
            a = b;
            b = sum;                
        }
    }

    // Fibonacci series using while loop
    private void fibonacciUsingWhile(int a, int b, int count) {
        int sum, i = 0;
        while (i < count) {
            System.out.println(a);
            sum = a + b;
            a = b;
            b = sum;
            i++;
        }
    }

    // Fibonacci series using recursion
    private void recursion (int a, int b, int count) {

        if (count > 0) {
            System.out.println(a + " ");
            int c = a + b;
            a = b;
            b = c;
            recursion(a, b, count - 1);
        }
    }

    public static void main(String[] args) {

        int a = 0, b = 1, count = 10;
        FibonacciSeries objFib = new FibonacciSeries();
        System.out.println("Fibonacci series using for loop");
        objFib.fibonacciUsingFor(a, b, count);
        System.out.println("Fibonacci series using while loop");
        objFib.fibonacciUsingWhile(a, b, count);
        System.out.println("Fibonacci series using recursion");
        objFib.recursion(a, b, count);
    }
}
