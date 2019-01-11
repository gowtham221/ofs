package com.objectfrontier.training.java.base;
class OverloadingWrapperType {

    public static void main(String[] arg) {
        wrapperFunction(33, 0.43f, 0.48, 's');
    }

    static void wrapperFunction() {
        System.out.println("Method without parameters");
    }

    static void wrapperFunction(Integer a, Float b, Double c, Character d) {
        System.out.println("Method with parameters " + a + " " + b + " " + c + " " + d);
    }
}
