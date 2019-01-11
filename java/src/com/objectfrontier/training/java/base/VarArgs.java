package com.objectfrontier.training.java.base;

class VarArgs {

    public static void main(String[] args) {

        display(22, 5.0f, 'i', "gowtham", "suhail", "dipak", "manik", "issac");
    }

    static void display(int a, float b,char c, String... s) {

        System.out.println("The number is " + a);
        System.out.println("The decimal is " + b);
        System.out.println("The alphabet is " + c);

        for(String d: s) {
            System.out.println("The string is " + d);
        }
    }
}
