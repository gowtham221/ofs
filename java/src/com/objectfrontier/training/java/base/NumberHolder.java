package com.objectfrontier.training.java.base;
public class NumberHolder {
    
    public int anInt;
    public float aFloat;
   
    public static void main(String[] args) {

        NumberHolder nh = new NumberHolder();
        nh.anInt = 5;
        nh.aFloat = 8.7F;
        System.out.println(nh.anInt);
        System.out.println(nh.aFloat);
   }
}