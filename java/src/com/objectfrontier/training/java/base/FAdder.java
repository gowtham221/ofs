package com.objectfrontier.training.java.base;
class FPAdder {

    public static void main(String[] arg) {

        float sum = 0;
        
        if (arg.length > 1) {
            for(int i = 0; i < arg.length; i++) {
                sum += Float.parseFloat(arg[i]);
            }
            System.out.println("The sum is " + sum);
        } else {
            System.out.println("Please enter more than one value to the adder");
        }
    }
}
