package com.objectfrontier.training.java.base;
class CompoundAssignment {

    public static void main (String[] args){

        int result = 1;
        result += 2;
        System.out.println(result);

        result -= 1;
        System.out.println(result);

        result *= 2;
        System.out.println(result);

        result /= 2;
        System.out.println(result);

        result += 8;
        result %= 7;
        System.out.println(result);
    }
}
